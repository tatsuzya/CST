let LoginView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

LoginView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.appBar.init(this.navContainer);
        this.setListeners();
        this.appBar.hidePreloader();
        $('.modal').modal();
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.loginForm = $('.login-form');
        this.forgotPassForm = $('#forgotPassForm');
        this.newPassForm = $('#newPassForm');
        this.npassword = $('#newPass');
        this.cpassword = $('#cnewPass');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.loginForm.submit(this.login.bind(this));
        this.forgotPassForm.submit(this.recoverPass.bind(this));
        this.newPassForm.submit(this.setPass.bind(this));
        this.npassword.on('keyup', this.validatePass.bind(this));
        this.cpassword.on('keyup', this.validatePass.bind(this));
    },
    /**
     * Checks if user is logged in.
     */
    checkAuth: function() {
        if (this.getCurUser()) {
            window.location.href = "/";
        }
    },
    /**
     * Checks if user contains redirect and change link for signup.
     */
    checkURL: function() {
        let searchParams = new URLSearchParams(window.location.search);
        let redirect = searchParams.get('redirect');
        let app = searchParams.get('appId');
        if (redirect && app) {
            let user = this.getCurUser();
            if (user) {
                window.location.href = redirect + '?rankUpUser=' + JSON.stringify(user);
            }
            $('#signUpLink').attr('href', './Register.html?redirect=' + redirect + '&appId=' + app);
        }

    },
    /**
     * Attempts to log user in.
     */
    login: function() {
        M.toast({html: 'Signing in...', classes: 'green'});
        $.when(this.loginUser($('#email').val(), $('#password').val())).done((user) => {
            if (user.errorMessage) {
                M.toast({html: user.errorMessage, classes: 'red'});
            } else if (user.Username) {
                this.storeUser(user);
                this.redirect(user);
            } else {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(user);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Redirect user to index if there is no redirect URL in search params,
     * redirect user to specified redirect URL if there is one.
     * @param user Object. User object.
     */
    redirect: function(user) {
        let searchParams = new URLSearchParams(window.location.search);
        let redirect = searchParams.get('redirect');
        let app = searchParams.get('appId');
        if (redirect && app) {
            $.when(this.checkPermission()).done((data) => {
                switch(app) {
                    case 'hangman':
                        if (data.hangman && data.hangman == 1) {
                            window.location.href = redirect + '?rankUpUser=' + JSON.stringify(user);
                        } else {
                            window.location.href = './Grant.html?app=hangman&redirect=' + redirect;
                        }
                        break;
                    case 'quiz':
                        if (data.quiz && data.quiz == 1) {
                            window.location.href = redirect + '?rankUpUser=' + JSON.stringify(user);
                        } else {
                            window.location.href = './Grant.html?app=quiz&redirect=' + redirect;
                        }
                        break;
                    default:
                }
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        } else {
            window.location.replace('./index.html');
        }
    },
    /**
     * Sends recovery email.
     */
    recoverPass: function() {
        $.when(this.sendRecoveryEmail($('#recoveryEmail').val())).done((data) => {
            if (!data.errorMessage) {
                M.toast({html: rankupmsg.login.recovery, classes: 'green'});
                this.forgotPassForm.hide();
                this.newPassForm.show();
            } else {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(data);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Sets new password for user using code from recovery email.
     */
    setPass: function() {
        let instance = M.Modal.getInstance($('.modal'));
        $.when(this.setNewPass($('#code').val(), $('#newPass').val(), $('#recoveryEmail').val())).done((data) => {
            if (!data.errorMessage) {
                M.toast({html: rankupmsg.login.passset, classes: 'green'});
                this.forgotPassForm.show();
                this.newPassForm.hide();
                instance.close();
            } else {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(data);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Checks if password meets requirements.
     */
    validatePass: function() {
        if (this.cpassword.val() != this.npassword.val()) {
            this.cpassword[0].setCustomValidity(rankupmsg.password.dontmatch);
        } else {
            this.cpassword[0].setCustomValidity("");
        }
        if (this.npassword.val().length < 8) {
            this.npassword[0].setCustomValidity(rankupmsg.password.length);
        } else {
            this.npassword[0].setCustomValidity("");
        }
    },
};