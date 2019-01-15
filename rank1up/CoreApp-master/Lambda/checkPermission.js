const mysql = require('mysql');

//Checks if user has permission
exports.handler = (event, context, callback) => {  
    let userSub = event.userSub;
    let app = event.app;
    let connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "rank1",
        password: "adminadmin1",
        database: "userData",
    });

    let sql = `SELECT ${app} FROM UserAppSub WHERE userSub = '${userSub}';`;
    connection.query(sql, function(error, result, fields){
        if (error) {
            connection.destroy();
            throw error;
        } else {
            connection.end();
            if (result[0]) {
                callback(null, result[0]);
            } else {
                callback({errorMessage: 'Error'}, null);
            }
        }
    });
};
