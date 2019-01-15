const AWS = require("aws-sdk");
let cognitoidentityserviceprovider = new AWS.CognitoIdentityServiceProvider({apiVersion: '2016-04-18'});

exports.handler = (event, context, callback) => {
    var params = {
        ClientId: '', /* required */
        ConfirmationCode: event.confirmationCode, /* required */
        Password: event.password, /* required */
        Username: event.email, /* required */
    };
    
    cognitoidentityserviceprovider.confirmForgotPassword(params, function(err, data) {
        if (err) {
            callback(err,null);  // an error occurred
        }
        else{
            callback(null, data);    // successful 
        }
    });
};
