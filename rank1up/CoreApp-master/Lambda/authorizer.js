const mysql = require('mysql');

//Checks token and subkey to see if it's valid
exports.handler = (event, context, callback) => {  
    let token = event.headers.accesstoken;
    let userSub = event.headers.usersub;
    let app = event.headers.appid;
    let subKey = event.headers.authorization;
    let connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "rank1",
        password: "adminadmin1",
        database: "userData"
    });
    let connection2 = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: ""
    });

    if (app && subKey) {
        let sql = `SELECT * FROM appData.AppInfo WHERE AppID = '${app}';`;
        connection2.query(sql, function(error, result, fields){
        if (error) {
            connection.destroy();
            throw error;
        } else {
            // connected!
            console.log(result);
            connection.end();
            if (result[0]) {
                if (result[0].Token == subKey) {
                    let sql = `SELECT * FROM UserTokens WHERE userSub = '${userSub}';`;
                    connection.query(sql, function(error, result, fields){
                        if (error) {
                            connection.destroy();
                            throw error;
                        } else {
                            // connected!
                            console.log(result);
                            connection.end();
                            if (result[0]) {
                                let userToken = result[0].accessToken;
                                let expiration = new Date(result[0].expiration);
                                let now = new Date();
                                if (userToken == token) {
                                    if (now.getTime() < expiration.getTime()) {
                                        callback(null, generatePolicy('user', 'Allow', event.methodArn, 'Valid token'));
                                    } else {
                                        console.log("Token expired");
                                        callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Token expired'));
                                    }
                                } else {
                                    console.log("Invalid token");
                                    callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid token'));
                                }
                            } else {
                                console.log("Invalid userSub");
                                callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid userSub'));
                            }
                        }
                    });
                } else {
                    console.log("Invalid sub key");
                    callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid sub key'));
                }
            } else {
                console.log("Invalid userSub");
                callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid userSub'));
            }
        }
    });
    } else {
        let sql = `SELECT * FROM UserTokens WHERE userSub = '${userSub}';`;
        connection.query(sql, function(error, result, fields){
            if (error) {
                connection.destroy();
                throw error;
            } else {
                // connected!
                console.log(result);
                connection.end();
                if (result[0]) {
                    let userToken = result[0].accessToken;
                    let expiration = new Date(result[0].expiration);
                    let now = new Date();

                    if (userToken == token) {
                        if (now.getTime() < expiration.getTime()) {
                            callback(null, generatePolicy('user', 'Allow', event.methodArn, 'Valid token'));
                        } else {
                            console.log("Token expired");
                            callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Token expired'));
                        }
                    } else {
                        console.log("Invalid token");
                        callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid token'));
                    }
                } else {
                    console.log("Invalid userSub");
                    callback(null, generatePolicy('user', 'Deny', event.methodArn, 'Invalid userSub'));
                }
            }
        });
    }
    
};

let generatePolicy = function(principalId, effect, resource, message) {
    let response = {};
    
    response.principalId = principalId;
    if (effect && resource) {
        let policyDocument = {};
        policyDocument.Version = '2012-10-17'; 
        policyDocument.Statement = [];
        let statementOne = {};
        statementOne.Action = 'execute-api:Invoke'; 
        statementOne.Effect = effect;
        statementOne.Resource = resource;
        policyDocument.Statement[0] = statementOne;
        response.policyDocument = policyDocument;
    }
    response.context = {
        "stringKey": message,
        "numberKey": 1,
        "booleanKey": true,
    };
    return response;
};