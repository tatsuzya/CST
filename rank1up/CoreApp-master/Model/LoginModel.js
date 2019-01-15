let LoginModel = function() {
};

LoginModel.prototype = {
    /**
     * Makes call to authenticate API to log a user in.
     * @param email String. Email of user.
     * @param password String.  Password of user.
     * @return ajax promise.
     */
    loginUser: function(email, password) {
        let json = {
            'email': email,
            'password': password
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/authenticate',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Retrieves user from local storage and check expiration.
     * @return user Object. User json.
     */
    getCurUser: function() {
        let curUser = localStorage.getItem('rankUpUser');
        let utc = new Date().getTime();
        if (curUser) {
            curUser = JSON.parse(curUser)
            if (utc < new Date(curUser.Expiration).getTime()) {
                return curUser;
            } else {
                localStorage.setItem('rankUpUser', '');
                return null;
            }
        }
    },
    /**
     * Makes API call to send recovery email.
     * @param email String. email of user.
     * @return ajax promise.
     */
    sendRecoveryEmail: function(email) {
        let json = {
            'email': email
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/recoverpassword',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to set the new password for the user.
     * @param code String. Code to set new password.
     * @param pass String. New password.
     * @param email String. Email of user.
     * @return ajax promise.
     */
    setNewPass: function(code, pass, email) {
        let json = {
            'confirmationCode': code,
            'password': pass,
            'email': email
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/newpassword',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Stores user JSOn in local storage.
     * @param user Object. User object, contains email, sub, access tokens, expiration.
     */
    storeUser: function(user) {
        localStorage.setItem('rankUpUser',JSON.stringify(user));
    },
    /**
     * Makes API call to retrieve user's app permissions.
     * @return ajax promise.
     */
    checkPermission: function() {
        let json = {
            userSub: this.getCurUser().sub
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/userappinfo',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    }
};