let GrantView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

GrantView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.appBar.init(this.navContainer);
        this.setListeners();
        this.loadMessage();
        this.appBar.hidePreloader();
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.msgContainer = $('#message');
        this.grantBtn = $('#grantBtn');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.grantBtn.click(this.grant.bind(this));
    },
    /**
     * Checks if user is logged in.
     */
    checkAuth: function() {
        if (!this.getCurUser()) {
            window.location.href = './AccessError.html';
        }
    },
    /**
     * Loads message for granting permission to message container.
     */
    loadMessage: function() {
        let searchParams = new URLSearchParams(window.location.search);
        let message;
        this.app = searchParams.get('app');
        switch (this.app) {
            case 'hangman':
                message = rankupmsg.grant.hangman;
                break;
            case 'quiz':
                message = rankupmsg.grant.quiz;
                break;
            case 'videochat':
                message = rankupmsg.grant.videochat;
                break;
            default:
                message = rankupmsg.grant.invalid;
                this.grantBtn.attr('disabled', true);
        }
        this.msgContainer.html(message);
    },
    /**
     * Grants a user permission to an app and redirects if successful to landing page to specified URL.
     */
    grant: function() {
        $.when(this.grantPermission(this.app)).done((data) => {
            if (!data.errorMessage) {
                let searchParams = new URLSearchParams(window.location.search);
                let redirect = searchParams.get('redirect');
                M.toast({html: rankupmsg.grant.redirect, classes: 'green'});
                if (redirect) {
                    setInterval(()=>{window.location.replace(redirect + '?rankUpUser=' + JSON.stringify(this.getCurUser()));}, 2000);
                } else {
                    setInterval(()=>{window.location.replace('/');}, 2000);
                }
                
            } else {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(data);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    }
};