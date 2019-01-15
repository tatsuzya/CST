const mysql = require('mysql');

exports.handler = (event, context, callback) => {
    
    let connection = mysql.createConnection({

    });
    let sub = event.userSub;
    let des = event.description;
    
    connection.query('UPDATE UserInfo SET description =? WHERE userSub= ?' ,['' + des,'' + sub], function (error, results, fields) {
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

