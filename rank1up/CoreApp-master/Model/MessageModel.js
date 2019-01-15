let MessageModel = function() {
};

MessageModel.prototype = {
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
     * Makes API call to search for users.
     * @param search String. Search query.
     * @return ajax promise.
     */
    searchUsers: function(search) {
        let json = {
            'search': search,
        };
        return $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/search',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: null,
            error: null
        });
    },
    /**
     * Makes API call to send a message to a user.
     * @param to String. Recipient of message.
     * @param msg String. Message to send.
     * @return ajax promise.
     */
    sendMessage: function(to, msg) {
        let user = this.getCurUser();
        if (user) {
            let email = user.email;
            let userSub = user.sub;
            let token = user.AccessToken;
            let json = {
                'sender': email,
                'recipient': to,
                'message': msg
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/messages',
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
     * Makes API call to retrieve messages.
     * @return ajax promise.
     */
    retrieveMessages: function() {
        let user = this.getCurUser();
        if (user) {
            let email = user.email;
            let userSub = user.sub;
            let token = user.AccessToken;
            let json = {
                'email': email
            };
            return $.ajax({
                url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/usermessages',
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