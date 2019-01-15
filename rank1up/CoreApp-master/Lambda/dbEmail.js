const mysql = require('mysql');

// Retrieves user info by email
exports.handler = (event, context, callback) => {
    
    var connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });
    var userSub = event.userSub;
 
    connection.query('SELECT * FROM UserInfo WHERE userSub= ?' ,['' + userSub], function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;
        } else {
            // connected!
            console.log(results);
            callback(error, results);
            connection.end(function (err) { callback(err, results);});
        }
    });
};