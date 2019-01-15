const mysql = require('mysql');

//Retrieves messages from user's inbox and sent
exports.handler = (event, context, callback) => {  
    let email = event.email;
    let connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
        multipleStatements: true
    });

    let sql = `SELECT * FROM Messages WHERE recipient = '${email}' ORDER BY dateTime DESC; SELECT * FROM Messages WHERE sender = '${email}' ORDER BY dateTime DESC; `;
    connection.query(sql, function(error, result, fields){
        if (error) {
            connection.destroy();
            throw error;
        } else {
            let inboxMessages = [];
            let sentMessages = [];
            result[0].forEach((message) => {
                inboxMessages.push(message);
            });
            result[1].forEach((message) => {
                sentMessages.push(message);
            });
            connection.end();
            callback(null, {inbox: inboxMessages, sent: sentMessages});
        }
    });
};
