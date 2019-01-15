var aws = require('aws-sdk');
var ses = new aws.SES();

exports.handler = (event, context, callback) => {
    console.log(event);
    console.log(event.response);
    console.log(event.request);
    if (event.request.userAttributes.email) {
            sendEmail(event.request.userAttributes.email, "Congratulations " + event.userName + ", you have been confirmed: ", function(status) {

            // Return to Amazon Cognito
            callback(null, event);
        });
    } else {
        // Nothing to do, the user's email ID is unknown
        callback(null, event);
    }
};

function sendEmail(to, body, completedCallback) {
    var eParams = {
        Destination: {
            ToAddresses: [to]
        },
        Message: {
            Body: {
                Text: {
                    Data: body
                }
            },
            Subject: {
                Data: "Cognito Identity Provider registration completed"
            }
        },

        // Replace source_email with your SES validated email address
        Source: ""
    };

    var email = ses.sendEmail(eParams, function(err, data){
        if (err) {
            console.log(err);
        } else {
            console.log("===EMAIL SENT===");
        }
        completedCallback('Email sent');
    });
    console.log("EMAIL CODE END");
};
