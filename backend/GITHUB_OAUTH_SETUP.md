# GitHub OAuth Setup - IMPORTANT

## ✅ What's Been Done

1. ✅ GitHub OAuth credentials added to `application.yml`
2. ✅ OAuth2 login enabled in `SecurityConfig.java`

## ⚠️ CRITICAL: Configure GitHub OAuth App

**You MUST do this or you'll get "access denied" errors!**

### Step 1: Go to GitHub OAuth Apps
Visit: https://github.com/settings/developers

### Step 2: Find Your OAuth App
Look for the app with Client ID: `Ov23likMwfQLsGH9E40I`

### Step 3: Set the Callback URL
**Authorization callback URL** must be EXACTLY:
```
http://localhost:8080/login/oauth2/code/github
```

⚠️ **This is the #1 cause of "access denied" errors!**

### Step 4: Save Changes
Click "Update application"

## 🚀 Running the Application

1. **Restart the application** (stop and start again - hot reload won't work)
2. The app will now have GitHub OAuth enabled

## 🔗 Test GitHub Login

After the app starts, visit:
```
http://localhost:8080/oauth2/authorization/github
```

This will redirect you to GitHub for authentication.

## 📝 Your Configuration

- **Client ID**: Ov23likMwfQLsGH9E40I
- **Client Secret**: eeab2b1c67fc06c98ac358cc1a75658014b947e5
- **Callback URL**: http://localhost:8080/login/oauth2/code/github

## 🐛 If You Get Errors

If you see compilation errors or "Unresolved compilation problem":

1. **Stop the application completely**
2. **Clean and rebuild**: In VS Code, press `Ctrl+Shift+P` and run "Java: Clean Java Language Server Workspace"
3. **Restart the application**

If errors persist, the OAuth beans might not be initializing properly. In that case, we may need to rollback again.
