const mysql  = require('mysql');
const moment = require('moment');

exports.handler = (event, context, callback) => {
    
    const sender    = event["body-json"].sender;
    const recipient = event["body-json"].recipient;
    const message   = event["body-json"].message;
    let   timeStamp = moment(Date.now()).utcOffset("-08:00").format('YYYY-MM-DD HH:mm:ss');
    
    const connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });   
    
    const insertMessage = `INSERT INTO Messages (message, sender, recipient, dateTime)\
        VALUES('${message}', '${sender}', '${recipient}', '${timeStamp}');`;
        
    // Run the query
    connection.query(insertMessage, function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;

        } else { // connected
            console.log("Updated");
            connection.end(function (err) { callback(err, "Success");});
        }
    });


    // callback(null, sender + " | " + recipient + " | Time: " + timeStamp);
};
