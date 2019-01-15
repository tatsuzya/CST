let RegisterModel = function() {
};

RegisterModel.prototype = {
    /**
     * Makes API call to register an user.
     * @param email String. Email of user.
     * @param fName String. First name of user.
     * @param lName String. Last name of user.
     * @param password String. Password.
     * @return ajax promise.
     */
    registerUser: function(email, fName, lName, password) {
        let json = {
            'email': email,
            'fName': fName,
            'lName': lName,
            'password': password
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/register',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to save an user.
     * @param sub String. userSub.
     * @param desc String. Description.
     * @return ajax promise.
     */
    saveProfileDesc: function(sub, desc) {
        let json = {
            'userSub': sub,
            'description': desc
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/description',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    }
};