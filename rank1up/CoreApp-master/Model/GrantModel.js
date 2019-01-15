let GrantModel = function() {
};

GrantModel.prototype = {
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
     * Makes API call to give user permission to an app.
     * @param app String. Application.
     * @return ajax promise.
     */
    grantPermission: function(app) {
        let userSub = this.getCurUser().sub;
        let token = this.getCurUser().AccessToken;
        let nameSplit = name.split(' ');
        let json = {
            'userSub': userSub,
            'app': app
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/grant',
            dataType: 'json',
            type: 'post',
            headers: {
                'AccessToken': token,
                'userSub': userSub
            },
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    }
};