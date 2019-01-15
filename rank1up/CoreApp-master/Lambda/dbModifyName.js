const mysql = require('mysql');

exports.handler = (event, context, callback) => {
    
    const firstName = event["body-json"].fName;
    const lastName  = event["body-json"].lName;
    const userSub   = event["body-json"].userSub;
    
    const connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });    
    
    const updateQuery = `Update UserInfo SET fName = '${firstName}', lName = '${lastName}' WHERE userSub = '${userSub}'`;
    
    // Run the query
    connection.query(updateQuery, function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;

        } else { // connected
            console.log("Updated");
            connection.end(function (err) { callback(err, "Modified");});
        }
    });

    // callback(null, firstName + " | " + lastName + " | " + userSub + " | Token: " + token);
};