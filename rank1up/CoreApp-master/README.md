# Rank Up

Hosted at: https://rankup.pro

Note: Please test the site through the hosted URL instead of locally.
      Signing up for Rank Up will require email verification before you can log in. Check the junk folder in your email.
      Password recovery will send a code to your email. Check the junk folder in your email.

Login: You can login from this page, or click the link to sign up for an account, or recover your password.
Landing page: you may click the app cards after granting permission to be directed to the external apps. Your ranking will be displayed if you ahve taken the quiz or played hangman.
Userprofile: after logging in, click your name on the appbar and click profile to go to your user profile, where you can edit your name, description and image.
Settings: after logging in, click your name on the appbar and click settings to go to the settings page, where you can change your password.
Message: after logging in, click the message icon in the appbar to go to the messaging page, where you can send messages to other users by email (you can search for users in the input field). Your sent and received messages can be found in the Sent and Inbox tab. You will need to refresh the page for new messages to display.
Search: click the search icon in the appbar to open search, where you can do compound search and filter by ranking.


Backend uses AWS API Gateway + mysql + AWS lambda, all hosted on AWS.
Lambda functions (in Lambda folder) are used to communicate with external app APIs and with our database. The authorizer function is used when writing to a user's profile and it will check the validity of a user's access token and subcription key if coming from external apps. Communication with external app APIs use the subscription keys for Authorization.