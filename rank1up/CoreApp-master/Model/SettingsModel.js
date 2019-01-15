let SettingsModel = function() {
};

SettingsModel.prototype = {
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
     * Makes API call to change password for an user.
     * @param opass String. Old password.
     * @param npass String. New password.
     * @return ajax promise.
     */
    changePass: function(opass, npass) {
        let json = {
            'accessToken': this.getCurUser().AccessToken,
            'previousPassword': opass,
            'proposedPassword': npass 
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/changepassword',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Logs a user out by clearing the local storage.
     */
    logout: function() {
        localStorage.setItem('rankUpUser', '');
    }
};