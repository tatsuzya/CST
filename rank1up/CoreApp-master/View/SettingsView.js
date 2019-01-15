let SettingsView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

SettingsView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.setListeners();
        this.appBar.init(this.navContainer);
        this.appBar.hidePreloader();
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.opassword = $('#opassword');
        this.npassword = $('#npassword');
        this.cpassword = $('#cpassword');
        this.form = $('.settings-form');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.npassword.on('keyup', this.validatePass.bind(this));
        this.cpassword.on('keyup', this.validatePass.bind(this));
        this.form.submit(this.submitPass.bind(this));
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
    /**
     * Checks if user is logged in.
     */
    checkAuth: function() {
        if (!this.getCurUser()) {
            window.location.href = "./AccessError.html";
        }
    },
    /**
     * Change logged in user's password.
     */
    submitPass: function() {
        $.when(this.changePass(this.opassword.val(), this.npassword.val())).done((data) => {
            if (data.errorMessage) {
                M.toast({html: rankupmsg.password.cantsave, classes: 'red'});
            } else {
                M.toast({html: rankupmsg.password.saved, classes: 'green'});
                this.logout();
                setInterval(()=>{window.location.replace('./Login.html');}, 2000);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    }
};