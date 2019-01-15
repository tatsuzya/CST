let UserProfileView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

UserProfileView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.setListeners();
        this.appBar.init(this.navContainer);
        CKEDITOR.replace('ckeditor', {on: {instanceReady: () => {
            this.loadProfile();
            this.disableDescEditor(true);
            this.disableNameEditor(true);
        }}});
        $('.modal').modal();
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.profileId = $('#profileId');
        this.badgeFrame = $('.profile-badge-frame');
        this.descEditBtn = $('#descEditBtn');
        this.editDescBtn = $('#editDescBtn');
        this.saveDescBtn = $('#saveDescBtn');
        this.editNameBtn = $('#editNameBtn');
        this.saveNameBtn = $('#saveNameBtn');
        this.imgInput = $('#imgInput');
        this.uploadBtn = $('#uploadBtn');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.editDescBtn.click(this.enableDescEditor.bind(this));
        this.saveDescBtn.click(this.disableDescEditor.bind(this));
        this.editNameBtn.click(this.enableNameEditor.bind(this));
        this.saveNameBtn.click(this.disableNameEditor.bind(this));
        this.imgInput.change(this.checkImg.bind(this));
        this.uploadBtn.click(this.uploadImg.bind(this));
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
     * Loads a user's profile from the DB.
     */
    loadProfile: function() {
        let searchParams = new URLSearchParams(window.location.search);
        let userSub = searchParams.get('userSub');
        let user;
        if (userSub) {
            $.when(this.retrieveUser(userSub)).done((data) => {
                if (data.length > 0) {
                    user = new User(data[0].imageUrl, data[0].fName, data[0].lName, data[0].description);
                    this.loadInfo(user);
                    this.loadBadges(userSub);
                }
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        } else {
            let curUserSub = this.getCurUser().sub;
            if (curUserSub) {
                $.when(this.retrieveUser(curUserSub)).done((data) => {
                    if (data.length > 0) {
                        user = new User(data[0].imageUrl, data[0].fName, data[0].lName, data[0].description);
                        this.loadInfo(user);
                        this.loadBadges(curUserSub);
                        this.enableEditing();
                    }
                }).fail((error) => {
                    M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                    console.log(error);
                });
            } else {
                this.appBar.hidePreloader();
                window.location.href = "./AccessError.html";
            }
        }
    },
    /**
     * Generate and append html for user's name and avatar.
     * @param user Object. User object.
     */
    loadInfo: function(user) {
        console.log(user.imageUrl);
        let idHtml = '<img src="' + user.imageUrl + '" alt="Avatar" class="circle profile-img">';
        $('.profile-img-frame').html(idHtml);
        $('.profile-name').val(user.fName + ' ' + user.lName);
        CKEDITOR.instances.ckeditor.setData(user.description)
        $('.profile-img').on('error', (img) => {
            $(img.target).attr('src', './img/default.png');
        });
        this.appBar.hidePreloader();
    },
    /**
     * Retrieves user' ranking for external apps and generates html for them. Appends to badge frame.
     * @param curUserSub String. Current user's userSub.
     */
    loadBadges: function(curUserSub) {
        $.when(this.retrieveHangMan(curUserSub)).done((data) => {
            if (data && data.percentage) {
                let badgeHtml = '<div class="profile-badge row">';
                badgeHtml += '<i class="col s4 material-icons colored profile-badge-icon">accessibility</i>';
                badgeHtml += '<div class="col s8">';
                badgeHtml += '<div class="center">Hang Man</div>';
                badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                badgeHtml += '</div></div>';
                if (this.badgeFrame.html() == 'No badges') {
                    this.badgeFrame.html('');
                }
                this.badgeFrame.append(badgeHtml);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
        $.when(this.retrieveJSQuiz(curUserSub)).done((data) => {
            if (data && data.percentage) {
                let badgeHtml = '<div class="profile-badge row">';
                badgeHtml += '<i class="col s4 devicon-javascript-plain colored profile-badge-icon"></i>';
                badgeHtml += '<div class="col s8">';
                badgeHtml += '<div class="center">JavaScript</div>';
                badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                badgeHtml += '</div></div>';
                if (this.badgeFrame.html() == 'No badges') {
                    this.badgeFrame.html('');
                }
                this.badgeFrame.append(badgeHtml);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
        $.when(this.retrieveAndroidQuiz(curUserSub)).done((data) => {
            if (data && data.percentage) {
                let badgeHtml = '<div class="profile-badge row">';
                badgeHtml += '<i class="col s4 devicon-android-plain colored profile-badge-icon"></i>';
                badgeHtml += '<div class="col s8">';
                badgeHtml += '<div class="center">Android</div>';
                badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                badgeHtml += '</div></div>';
                if (badgeFrame.html() == 'No badges') {
                    badgeFrame.html('');
                }
                this.badgeFrame.append(badgeHtml);
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Enables editing profile.
     */
    enableEditing: function() {
        $('.edit-btn-container').show();
    },
    /**
     * Saves description and disables editing description.
     */
    disableDescEditor: function(init) {
        this.saveDescBtn.hide();
        this.editDescBtn.show();
        CKEDITOR.instances.ckeditor.setReadOnly(true);
        $('.cke_top').hide();
        $('.cke_bottom').hide();
        $('.cke_editor_ckeditor').css('border', 'none');
        if (init == true) {
        } else {
            $.when(this.saveDesc(CKEDITOR.instances.ckeditor.getData())).done((data) => {
                if (data.errorMessage) {
                    M.toast({html: rankupmsg.desc.cantupdate, classes: 'red'});
                } else {
                    M.toast({html: rankupmsg.desc.updated, classes: 'green'});
                }
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        }
    },
    /**
     * Enables description editor.
     */
    enableDescEditor: function() {
        this.saveDescBtn.show();
        this.editDescBtn.hide();
        CKEDITOR.instances.ckeditor.setReadOnly(false);
        $('.cke_top').show();
        $('.cke_bottom').show();
        $('.cke_editor_ckeditor').css('border', '1px solid #d1d1d1');
    },
    /**
     * Saves name and disables editing name.
     */
    disableNameEditor: function(init) {
        $('.profile-name').prop('disabled', true);
        $('.profile-name').css('border-bottom', 'none');
        this.saveNameBtn.hide();
        this.editNameBtn.show();
        if (init == true) { 
        } else {
            $.when(this.saveName($('.profile-name').val())).done((data) => {
                if (data.errorMessage) {
                    M.toast({html: rankupmsg.name.cantupdate, classes: 'red'});
                } else {
                    M.toast({html: rankupmsg.name.updated, classes: 'green'});
                }
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        }
    },
    /**
     * Enables name editor.
     */
    enableNameEditor: function() {
        $('.profile-name').prop('disabled', false);
        $('.profile-name').css('border-bottom', '1px solid white');
        this.saveNameBtn.show();
        this.editNameBtn.hide();
    },
    /**
     * Checks if image is the right size and type.
     */
    checkImg: function() {
        let imgfiles = $('#imgInput')[0].files;
        if(imgfiles && imgfiles[0]) {
            if (imgfiles[0].type != 'image/jpeg' && imgfiles[0].type != 'image/png' ) {
                M.toast({html: rankupmsg.error.imgtype, classes: 'red'});
                $('#uploadBtn').attr('disabled', true);
            }
            else if (imgfiles[0].size > 100000) {
                M.toast({html: rankupmsg.error.imgsize, classes: 'red'});
                $('#uploadBtn').attr('disabled', true);
            } else {
                $('#uploadBtn').attr('disabled', false);
            }
        }
    },
    /**
     * Uploads an image for the current user.
     */
    uploadImg: function() {
        let imgfiles = $('#imgInput')[0].files;
        if(imgfiles && imgfiles[0]) {
            let fs = new FileReader();
            fs.onload = (event) => {
                $('.profile-img').attr('src', event.target.result);
                $.when(this.saveImg(event.target.result, imgfiles[0].type.split('/')[1])).done((data) => {
                    if (data.errorMessage) {
                        M.toast({html: rankupmsg.img.cantupdate, classes: 'red'});
                        console.log(data);
                    } else {
                        M.toast({html: rankupmsg.img.updated, classes: 'green'});
                    }
                }).fail((error) => {
                    M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                    console.log(error);
                });
            }
            fs.readAsDataURL($('#imgInput')[0].files[0]);
        }
    }
};