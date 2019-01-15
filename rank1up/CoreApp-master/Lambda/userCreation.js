global.fetch = require('node-fetch');
const mysql = require('mysql');
let AmazonCognitoIdentity = require('amazon-cognito-identity-js');
let CognitoUserPool = AmazonCognitoIdentity.CognitoUserPool;
let CognitoUserAttribute = AmazonCognitoIdentity.CognitoUserAttribute;


exports.handler = (event, context, callback) => {
  
  console.log(event);
  
  // Define AWS Cognito User Pool
  let poolData = {
    "UserPoolId": "",
    "ClientId": ""
  };
  
  let userPool = new CognitoUserPool(poolData);
  console.log('userPool:',userPool);

  // Define User Attributes
  let attributeList = [];
  let dataEmail = {
    "Name": "email",
    "Value": event.email
  };
  let datafname = {
    "Name": "given_name",
    "Value": event.fName
  };
  let datalname = {
    "Name": "family_name",
    "Value": event.lName
  };
 
  let attributeEmail = new CognitoUserAttribute(dataEmail);
  let attributefname = new CognitoUserAttribute(datafname);
  let attributelname = new CognitoUserAttribute(datalname);
  attributeList.push(attributeEmail);
  attributeList.push(attributefname);
  attributeList.push(attributelname);
  console.log('attributeList:',attributeList);

  // Create User via AWS Cognito
  userPool.signUp(event.email,event.password ,attributeList, null, function(err, result) {
    if(err) {
      console.log('err:',err);
      callback(err, null);
    } else {
      console.log('result:', result);
  
      let connection = mysql.createConnection({
        host: "",
        user: "",
        password: "",
        database: "",
        multipleStatements: true
      });
      
      let sql = `INSERT INTO UserInfo (fName, lName, emailAddress, userSub, imageUrl) VALUES ('${event.fName}', '${event.lName}', '${event.email}', '${result.userSub}', 'https://i.imgur.com/Knh0xQk.png' ); INSERT INTO UserAppSub (userSub) VALUES ('${result.userSub}');`;
      console.log(sql);
      
      connection.query(sql, function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;
        } else {
            // connected!
            console.log(results);
            connection.end(function (err) { callback(err, results);});
        }
      });
      
      callback(null,result);
    }
  });
};
