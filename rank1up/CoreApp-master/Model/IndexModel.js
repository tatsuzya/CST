let IndexModel = function() {
};

IndexModel.prototype = {
    /**
     * Makes API call to generate video chat link.
     * @return ajax promise.
     */
    retrieveVideoChatRoom: function() {
        let user = this.getCurUser();
        if (user) {
            let email = user.email;
            let userSub = user.sub;
            let token = user.AccessToken;
            let json = {
                username: this.getCurUser().email
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/videochatlink',
                dataType: 'json',
                type: 'post',
                headers: {
                    'AccessToken': token,
                    'userSub': userSub
                },
                contentType: 'application/json',
                data: JSON.stringify(json),
                success: null,
                error: null,
                timeout: 10000
            });
        } else {
            window.location.replace('./Login.html');
        }
    },
    /**
     * Makes API call to retrieve hangman rank.
     * @return ajax promise.
     */
    retrieveHangMan: function() {
        let json = {
            'rankupid': this.getCurUser().sub
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
     * Makes API call to retrieve js quiz rank.
     * @return ajax promise.
     */
    retrieveJSQuiz: function() {
        let json = {
            'rankupid': this.getCurUser().sub,
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
     * Makes API call to retrieve android quiz rank.
     * @return ajax promise.
     */
    retrieveAndroidQuiz: function() {
        let json = {
            'rankupid': this.getCurUser().sub,
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
     * Makes API call to retrieve user's app permissions.
     * @return ajax promise.
     */
    getUserAppInfo: function(userSub) {
        let json = {
            userSub: userSub
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