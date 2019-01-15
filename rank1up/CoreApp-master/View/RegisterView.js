let RegisterView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

RegisterView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.appBar.init(this.navContainer);
        this.setListeners();
        this.appBar.hidePreloader();
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.registerForm = $('.register-form');
        this.password = $('#password');
        this.cpassword = $('#cpassword');
        this.title = $('.page-title');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.registerForm.submit(this.register.bind(this));
        this.password.on('keyup', this.validatePass.bind(this));
        this.cpassword.on('keyup', this.validatePass.bind(this));
    },
    /**
     * Registers a user.
     */
    register: function() {
        $.when(this.registerUser($('#email').val(), $('#fName').val(), $('#lName').val(), $('#password').val())).done((data) => {
            if (data.user) {
                M.toast({html: rankupmsg.register.created, classes: 'green'});
                this.displayEditor(data);
            } else {
                console.log(data);
                M.toast({html: rankupmsg.error.accountcreate, classes: 'red'});
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
        if (this.cpassword.val() != this.password.val()) {
            this.cpassword[0].setCustomValidity(rankupmsg.password.dontmatch);
        } else {
            this.cpassword[0].setCustomValidity("");
        }
        if (this.password.val().length < 8) {
            this.password[0].setCustomValidity(rankupmsg.password.length);
        } else {
            this.password[0].setCustomValidity("");
        }
    },
    /**
     * Displays the editor to add profile description.
     * @param user Object. User object.
     */
    displayEditor: function(user) {
        let desc = '<div class="desc-container"><textarea name="ckeditor" id="ckeditor"></textarea><a id="saveBtn" class="waves-effect waves-light btn right purple">save</a></div>';
        this.title.html('Fill in your profile description');
        this.registerForm.replaceWith(desc);
        CKEDITOR.replace('ckeditor', {on: {instanceReady: () => {$('#saveBtn').on('click', ()=> {
            M.toast({html: rankupmsg.desc.saving, classes: 'green'});
            this.saveEditor(user)});
        }}});
    },
    /**
     * Saves the data in the editor to the user's profile.
     * @param user Object. User object.
     */
    saveEditor: function(user) {
        let desc = CKEDITOR.instances.ckeditor.getData();
        $.when(this.saveProfileDesc(user.userSub, desc)).done((data) => {
            if (data.errorMessage) {
                console.log(err);
                M.toast({html: rankupmsg.error.profilesave, classes: 'red'});
            } else {
                this.redirect();
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Redirects user to login page.
     * @param email String. User's email.
     */
    redirect: function(email) {
        M.toast({html: rankupmsg.desc.saved, classes: 'green'});
        let searchParams = new URLSearchParams(window.location.search);
        let redirect = searchParams.get('redirect');
        let app = searchParams.get('appId');
        setInterval(()=>{
            if (redirect) {
                window.location.replace('./Login.html?redirect=' + redirect + '&appId=' + app);
            } else {
                window.location.replace('./Login.html');
            }
        }, 2000);
    }
};