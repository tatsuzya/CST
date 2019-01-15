let UserProfileModel = function() {
};

UserProfileModel.prototype = {
    /**
     * Makes API call to retrieve an user's info.
     * @param userSub String. userSub.
     * @return ajax promise.
     */
    retrieveUser: function(userSub) {
        let json = {
            'userSub': userSub
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/user',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to retrieve an user's hangman rank.
     * @param userSub String. userSub.
     * @return ajax promise.
     */
    retrieveHangMan: function(userSub) {
        let json = {
            'rankupid': userSub
        };
        return $.post({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/retrieve/gamepercent',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to retrieve an user's JS quiz rank.
     * @param userSub String. userSub.
     * @return ajax promise.
     */
    retrieveJSQuiz: function(userSub) {
        let json = {
            'rankupid': userSub,
            'ver': '1'
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/retrieve/quizpercent',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to retrieve an user's android quiz rank.
     * @param userSub String. userSub.
     * @return ajax promise.
     */
    retrieveAndroidQuiz: function(userSub) {
        let json = {
            'rankupid': userSub,
            'ver': '2'
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/retrieve/quizpercent',
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
     * Retrieves access token from local storage and check expiration.
     * @return accessToken String. AccessToken.
     */
    getAccessToken: function() {
        let curUser = localStorage.getItem('rankUpUser');
        let utc = new Date().getTime();
        if (curUser) {
            curUser = JSON.parse(curUser)
            if (utc < new Date(curUser.Expiration).getTime()) {
                return curUser.AccessToken;
            } else {
                localStorage.setItem('rankUpUser', '');
                return null;
            }
        }
    },
    /**
     * Makes API call to save name of user.
     * @param name String. Name of user.
     * @return ajax promise.
     */
    saveName: function(name) {
        let user = this.getCurUser();
        if (user) {
            let userSub = user.sub;
            let token = user.AccessToken;
            let nameSplit = name.split(' ');
            let json = {
                'fName': nameSplit[0],
                'lName': nameSplit[1],
                'userSub': userSub
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/modify-name',
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
        } else {
            window.location.replace('./Login.html');
        }
    },
    /**
     * Makes API call to save description of user.
     * @param desc String. description of user.
     * @return ajax promise.
     */
    saveDesc: function(desc) {
        let user = this.getCurUser();
        if (user) {
            let userSub = user.sub;
            let token = user.AccessToken;
            let json = {
                'userSub': userSub,
                'description': desc
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/description',
                dataType: 'json',
                type: 'put',
                headers: {
                    'AccessToken': token,
                    'userSub': userSub
                },
                contentType: 'application/json',
                data: JSON.stringify(json),
                success: null,
                error: null
            });
        } else {
            window.location.replace('./Login.html');
        }
    },
    /**
     * Makes API call to save image of user.
     * @param img String. Image uploaded.
     * @param type String. Image extension.
     * @return ajax promise.
     */
    saveImg: function(img, type) {
        let user = this.getCurUser();
        if (user) {
            let userSub = user.sub;
            let token = user.AccessToken;
            let json = {
                'userSub': userSub,
                'image': img,
                'extension': type
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/uploadavatar',
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
        } else {
            window.location.replace('./Login.html');
        }
    }
};