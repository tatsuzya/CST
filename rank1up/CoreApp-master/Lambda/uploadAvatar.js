/* jshint esversion: 6 */
const mysql = require('mysql');
const AWS = require('aws-sdk');
// get reference to s3 bucket
var s3 = new AWS.S3();
// upload images to s3 bucket
exports.handler = (event, context, callback) => {
    const connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });
    connection.connect();
    
    let encodedIamge = event.image;
    let decodedIamge = new Buffer(encodedIamge.replace(/^data:image\/\w+;base64,/, ""), 'base64');
    let extension = event.extension;
    var userSub = event.userSub;
    var filePath = `avatar/${userSub}.${extension}`;
    var params = {
        "Body": decodedIamge,
        "Bucket": "rankupuseravatar",
        "Key":filePath,
        "ContentEncoding": 'base64',
        "ContentType": `image/${extension}`
    };
    s3.upload(params,(err, data) =>{
        if(err){
            callback(err,null);
        }else{
            let response = {
                "statusCode":200,
                "headers":{
                    "header":"value"
                },
                "body":JSON.stringify(data),
                "isBase64Encoded": false
            };
            let query = `UPDATE UserInfo SET imageUrl = 'https://s3-us-west-1.amazonaws.com/rankupuseravatar/${filePath}' WHERE userSub = '${userSub}';`;
            // store the image link to database
            connection.query(query, function (error, results, fields) {
                if (error) {
                    connection.destroy();
                    throw error;
                } else {
                    // connected!
                    console.log(results);
                    connection.end();
                    callback(error, results);
                }
            });
        }
    });
};
