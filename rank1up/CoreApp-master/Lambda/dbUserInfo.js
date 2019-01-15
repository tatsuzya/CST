var mysql = require('mysql');

exports.handler = (event, context, callback) => {

    var connection = mysql.createConnection({
        host: <db-endpoint>,
        user: <db-user>,
        password: <db-password>,
        database: <db-name>,
    });

    connection.query('SELECT * FROM UserInfo', function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;
        } else {
            // connected!
            console.log(results);
            callback(error, results);
            connection.end();
        }
    });
};
