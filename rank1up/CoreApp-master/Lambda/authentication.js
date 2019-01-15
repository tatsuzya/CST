global.fetch = require('node-fetch');
const AWS = require("aws-sdk");
const mysql = require('mysql');
let cognitoidentityserviceprovider = new AWS.CognitoIdentityServiceProvider({apiVersion: '2016-04-18'});
let expire;

exports.handler = (event, context, callback) => {
    let params = {
        AuthFlow: 'ADMIN_NO_SRP_AUTH',
        ClientId:'',
        UserPoolId:'',
        AuthParameters:{
            'USERNAME':event.email,
            'PASSWORD':event.password
        },
    };
    
    cognitoidentityserviceprovider.adminInitiateAuth(params, function(err, data) {
        if (err) {
            callback(err, null);
        } else {
            let accessToken = data.AuthenticationResult.AccessToken;
            let refreshToken = data.AuthenticationResult.RefreshToken;
            expire = data.AuthenticationResult.ExpiresIn;
            let user = {
                AccessToken: accessToken
            };
            
            cognitoidentityserviceprovider.getUser(user, function(err,data){
                if(err){
                    console.log(err,err.stack);
                }else{
                    let userName = data.Username;
                    
                    let connection = mysql.createConnection({
                        host: "",
                        user: "",
                        password: "",
                        database: "",
                    });
                    
                    let date = getDateTime();

                    let sql = "INSERT INTO UserTokens (userSub, accessToken, expiration) VALUES ? ON DUPLICATE KEY UPDATE accessToken = VALUES(accessToken), expiration = VALUES(expiration)";
                    
                    let value = [
                        ['' + userName, '' + accessToken, '' + date],
                    ];
                    
                    console.log(date);
                    
                    connection.query(sql, [value],function(error, result, fields){
                        if (error) {
                            connection.destroy();
                            throw error;
                        } else {
                            // connected!
                            console.log(result);
                            connection.end();
                        }
                    });
                    
                    let response ={
                        "Username": data.Username,
                        "AccessToken": accessToken,
                        "RefreshToken": refreshToken,
                        "Expiration": date
                    };
                    
                    data.UserAttributes.forEach((attribute) => {
                        response[attribute.Name] = attribute.Value;
                    });
                    
                    callback(null,response);
                }
            });
        }
    });
    
    function getDateTime() {
        var date = new Date();
                
        var hour = date.getHours() + (expire / 60 / 60);
        hour = (hour < 10 ? "0" : "") + hour;
        
        var min  = date.getMinutes();
        min = (min < 10 ? "0" : "") + min;
        
        var sec  = date.getSeconds();
        sec = (sec < 10 ? "0" : "") + sec;
        
        var year = date.getFullYear();
        
        var month = date.getMonth() + 1;
        month = (month < 10 ? "0" : "") + month;
                    
        var day  = date.getDate();
        day = (day < 10 ? "0" : "") + day;
        
        if (hour == 24){
            hour = 0; 
            day = date.getDate() + 1;
        }
        return year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
    }
};
