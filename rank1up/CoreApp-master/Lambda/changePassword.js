const AWS = require("aws-sdk");
let cognitoidentityserviceprovider = new AWS.CognitoIdentityServiceProvider({apiVersion: '2016-04-18'});

exports.handler = (event, context, callback) => {
    var params = {
      AccessToken: event.accessToken, /* required */
      PreviousPassword: event.previousPassword, /* required */
      ProposedPassword: event.proposedPassword /* required */
    };
    
    cognitoidentityserviceprovider.changePassword(params, function(err, data) {
        if (err) {
            callback(err, null);    // an error occurred
        }else{
            callback(null, "success");           // successful response    
        }
    });
};
