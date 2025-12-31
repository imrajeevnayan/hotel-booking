package com.hotelbooking.security;

import com.hotelbooking.model.User;
import com.hotelbooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = "spring.security.oauth2.client.registration.github.client-id")
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        User user = processOAuth2User(registrationId, attributes);

        return new CustomOAuth2User(oAuth2User, user);
    }

    private User processOAuth2User(String registrationId, Map<String, Object> attributes) {
        if (!"github".equals(registrationId)) {
            throw new OAuth2AuthenticationException("Unsupported OAuth2 provider: " + registrationId);
        }

        String providerId = attributes.get("id").toString();
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String avatarUrl = (String) attributes.get("avatar_url");

        // If email is null, try to get it from the login
        if (email == null) {
            email = attributes.get("login") + "@github.com";
        }

        return userRepository.findByProviderAndProviderId(User.AuthProvider.GITHUB, providerId)
                .map(existingUser -> {
                    existingUser.setName(name);
                    existingUser.setProfilePicture(avatarUrl);
                    return userRepository.save(existingUser);
                })
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setName(name);
                    newUser.setProvider(User.AuthProvider.GITHUB);
                    newUser.setProviderId(providerId);
                    newUser.setProfilePicture(avatarUrl);
                    newUser.setEnabled(true);
                    newUser.setRole(User.Role.USER);
                    return userRepository.save(newUser);
                });
    }
}
