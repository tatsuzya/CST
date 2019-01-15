/* jshint esversion: 6 */
const fetch = require('node-fetch');

exports.handler = (event) => {
    let result = {
        percentage:""
    };
    const url = "https://us-central1-a1-f09ef.cloudfunctions.net/getRankPercent";
    let data = {
        id: event.rankupid,
        ver: event.ver
    };
    let param = {
        headers: {
            "token":"",
            "Content-Type":"application/json"
        },
        method:"POST",
        body: JSON.stringify(data),
    };
    console.log(data);
    return fetch(url,param).then(response => {
        if (response.ok){
            console.log("OK");
            return response.json();
        }else{
            console.log("Bad");
            throw new Error('Server response wasn\'t OK');
        }
    }).then(json => {
        result.percentage = json.rankString;
        return result;
    });
};
