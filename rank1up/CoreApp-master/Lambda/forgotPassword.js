const AWS = require("aws-sdk");
let cognitoidentityserviceprovider = new AWS.CognitoIdentityServiceProvider({apiVersion: '2016-04-18'});

exports.handler = (event, context, callback) => {
    var params = {
      ClientId: '', /* required */
      Username: event.email, /* required */
    };
    
    cognitoidentityserviceprovider.forgotPassword(params, function(err, data) {        if (err) {
            callback(err, null); // an error occurred
        }else{
            callback(null, data); // successful response    
        }
    });
    
};
