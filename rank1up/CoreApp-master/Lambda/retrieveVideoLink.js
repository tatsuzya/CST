const mysql = require('mysql');
const axios = require('axios');
const axiosClient = axios.create();
axiosClient.defaults.timeout = 10000;

//Retrieves video link from video chat api
exports.handler = (event, context, callback) => {
    
    const connection = mysql.createConnection({
        host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
        user: "",
        password: "",
        database: "",
    });
    const SQLquery = `SELECT * FROM appData.AppInfo WHERE AppID = 'VideoChat03';`;
    
connection.query(SQLquery, function (error, results, fields) {
        if (error) {
            connection.destroy();
            throw error;
        } else {
            let apiURL = results[0].API;
            let token = results[0].Token;
            connection.end();
            axiosClient.post(apiURL, {
              username: event.username
            }, {
                headers: {token: token}
            })
            .then((res) => {
                console.log(res);
                callback(null, {url: res.data.url});
            })
            .catch((err) => {
                console.log(err);
                callback(err, null);
            })
        }
    });
};