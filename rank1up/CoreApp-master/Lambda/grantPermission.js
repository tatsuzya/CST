const mysql = require('mysql');

//Grants permission to a user for an app
exports.handler = (event, context, callback) => {  
    let userSub = event.userSub;
    let app = event.app;
    let connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });

    let sql = `INSERT INTO UserAppSub (userSub, ${app}) VALUES ('${userSub}', 1) ON DUPLICATE KEY UPDATE ${app} = 1;`;
    connection.query(sql, function(error, result, fields){
        if (error) {
            connection.destroy();
            throw error;
        } else {
            connection.end();
            callback(null, 'Success');
        }
    });
};
