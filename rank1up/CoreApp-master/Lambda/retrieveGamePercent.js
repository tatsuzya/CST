/* jshint esversion:6 */
const fetch = require('node-fetch');

exports.handler = (event) => {
    let result = {
        percentage:""
    };
    const url = "https://cg3adfllh2.execute-api.us-west-2.amazonaws.com/development/user/percentage";
    let rankupid = event.rankupid;
    let param = {
        headers: {
            "Authorization":"",
            "rankupid":rankupid
        },
        method:"POST",
    };

    return fetch(url,param)
        .then(response =>  {
            if (response.ok){
                console.log("OK");
                return response.json();
            }else{
                console.log("Bad");
                throw new Error('Server response wasn\'t OK');
            }
        })
        .then(json => {
            result.percentage = json.Percentage;
            return result;
        });
};
