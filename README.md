# Spring boot OAuth2 with WSO2 Demo applications

Download and install WSO2 API Manager. The default port for the server is 9443. This can be changed by setting the Port offset in carbon.xml which is located in config directory of the WSO2 installation. The examples shown below have a port offset of 1.

## Demo 1: OAuth2 Authorisation Flow ##

Demo app for this feature is app1-oauth-securityprovider. It is a spring boot application with security configuration for WSO2 (modified version of the Spring social-manual example application ). Security configuration in the code and application.yml have been modified to make it work for WSO2. This serves as the client application which requires WSO2 API manager to verify user. In this use case, the Authorisation server (WSO2) will grant access for user (user-agent) upon successful verification of user credentials (from based login/password). Comparing with Authorisation service provided by social platforms like Facebook / Twitter, the difference is in the user permission to disclose the requested users attributes like email from the social account to the client application. Since the secured resources are hosted by the client application, authorisation scope and user consent flow will be suppressed. Suggest reading [WSO2 Documentation](https://docs.wso2.com/display/APICloud/Authorization+Code+Grant) before trying this demo.
1. Register the application in WSO2. This is done through ADD Application in WSO2 store app. If the WSO2 is installed on the localhost, the store will be accessible at https://localhost:9444/store. The callback URL provides the redirect path and it should match with the preEstablishedRedirectUri in the application.yml
2. Generate keys for the and update clientId and clientSecret in application.yml
3. Create a self-signed certificate for the application using keytool or openssl. Update application.yml with the keystore password and class path. Running the client application on HTTP will cause spring to reinitialise the security context and hence will reject the OAuth2 token resulting in authorisation failure.
4. Import WSO2 certificate into the keystore which will be required for the token request (triggered by client application after user authorisation). The accessTokenUri in a local deployment will be https://localhost:8244/token (port might differ depending on the offset explained previously)
5. Change SkipUserConsent to true in identity.xml which s located in config directory of the WSO2 installation.
6. Application context for the client application is mandatory for the authorisation flow. It will prevent [CSRF related InvalidSecurityException](https://stackoverflow.com/questions/34219911/why-is-accesstokenrequests-preservedstate-perpetually-null-with-a-resultant-csr)
7. Run the client application and launch the index page in the browser. Login action will redirect to WSO2 form login. The WSO2 installation comes with a default admin user which can be used for testing the flow.

## Demo 2: SSO Flow
This will demonstrate the use of OAuth2 authorisation for single-signon. It is an extension of the previous demo, so it will work only if authorisation flow is successful. The second demo application app2-oauth-serviceprovider is required for this scenario.
1. Repeat step 1 and step 2 described in Demo1 for this spring application
2. The certificate created previously can be reused. Update application.yml with the keystore password and class path.
3. Run the client application and try accessing https://[host]:[port]/[contextPath]/v1/persons. It will redirect to the login page. To verify SSO, do not login into this application. **NOTE:** If the browser has a valid auth session from previous demo, the xml response will be displayed due to SSO behaviour.
4. Open another browser tab and login to application that was running from Demo 1. Try https://[host]:[port]/[contextPath]/v1/persons. The xml response will be displayed without login redirection.


**More to come**
* OAuth Client Credentials example 
* SOAP <--> REST Mediation demo