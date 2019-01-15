const mysql = require('mysql');
const axios = require('axios');
const axiosClient = axios.create();
axiosClient.defaults.timeout = 5000;

//Performs search using external app APIs and DB
exports.handler = (event, context, callback) => {
    let filterApp = event.filterApp;
    let filterType = event.filterType;
    let percent = event.percent;
    let comparator;
    let apiurl;
    let subkey;
    let body;
    let headers;
    let keywords = '';
    event.search.trim().split(' ').forEach((word) => {
        keywords += `+*${word}* `;
    });
    
    if (filterType == 'top') {
        comparator = '<=';
    } else {
        comparator = '>=';
    }
    
    switch(filterApp) {
        case "hangman":
            apiurl = 'https://cg3adfllh2.execute-api.us-west-2.amazonaws.com/development/searchpercentage';
            subkey = '';
            headers = {Authorization: subkey};
            body = {
                percentage: percent,
                comparator: comparator
            };
            break;
        case "js":
            apiurl = 'https://us-central1-a1-f09ef.cloudfunctions.net/getRankPercentUsers';
            subkey = '';
            headers = {token: subkey};
            body = {
                percentage: percent,
                comparator: comparator,
                ver: 1
            };
            break;
        case "android":
            apiurl = 'https://us-central1-a1-f09ef.cloudfunctions.net/getRankPercentUsers';
            subkey = '';
            headers = {token: subkey};
            body = {
                percentage: percent,
                comparator: comparator,
                ver: 2
            };
            break;
        default:
            break;
    }

    if (apiurl) {
        axiosClient.post(apiurl, body, 
        {
            headers: headers
        })
        .then((res) => {
            console.log(res);
            let connection = mysql.createConnection({
                host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
                user: "",
                password: "",
                database: "",
            });
            let searchQuery;
            let userlist = '';
            console.log(res.data);
            if (res.data.users) {
                console.log(res.data.users);
                res.data.users.forEach((user) => {
                    userlist += `'${user}',`;
                });
            } else {
                res.data.forEach((user) => {
                    userlist += `'${user.rankupid}',`;
                });
            }
            userlist = userlist.slice(0, -1);
            if (event.search.trim()) {
                searchQuery = `SELECT * FROM UserInfo WHERE MATCH (fName, lName, emailAddress, description) AGAINST ('${keywords}' IN BOOLEAN MODE) AND UserSub IN (${userlist});`;
            } else {
                searchQuery = `SELECT * FROM UserInfo WHERE UserSub IN (${userlist});`;
            }
            console.log(searchQuery);
            connection.query(searchQuery, function (error, results, fields) {
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
        })
        .catch((err) => {
            console.log(err);
            callback(err, null);
        });
    } else {
        let connection = mysql.createConnection({
            host: "core-app.cljbacshrdxd.us-west-1.rds.amazonaws.com",
            user: "",
            password: "",
            database: "",
        });
        let searchQuery;
        searchQuery = `SELECT * FROM UserInfo WHERE MATCH (fName, lName, emailAddress, description) AGAINST ('${keywords}' IN BOOLEAN MODE);`;
        connection.query(searchQuery, function (error, results, fields) {
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
    }
};