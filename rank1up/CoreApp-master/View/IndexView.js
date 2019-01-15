let IndexView = function(appBar) {
    this.appBar = appBar;
    this.init();
    this.appBar.hidePreloader();
};

IndexView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.setListeners();
        this.appBar.init(this.navContainer);
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.appLinks = $('.app-links');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
    },
    /**
     * Retrieves video chat room link and appends to container.
     */
    retrieveRoom: function() {
        M.toast({html: 'Generating room...', classes: 'green'});
        $.when(this.retrieveVideoChatRoom()).done((data) => {
            console.log(data);
            if (data && data.url) {
                let linkHtml = `<a href="${data.url}" target="_blank">Open Video Chat</a>`;
                $('#linkText').html(linkHtml);
            } else {
                M.toast({html: rankupmsg.error.roomlink, classes: 'red'});
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Checks if user is logged in and load app cards.
     */
    loadAppCards: function() {
        let curUser = this.getCurUser();
        if(curUser) {
            $.when(this.getUserAppInfo(curUser.sub)).done((data) => {
                this.loadHangMan(curUser, data.hangman);
                this.loadQuiz(curUser, data.quiz);
                this.loadVideoChat(data.videochat);
            });
        } else {
            this.loadHangMan(null);
            this.loadQuiz(null);
            this.loadVideoChat(null);
        }
    },
    /**
     * Generates hangman card html and adds to container.
     */
    loadHangMan: function(user, data) {
        let html = '<div id="hangmanCard" class="col s12 m4">';
        if (data == 0) {
            html += '<a href="Grant.html?app=hangman">';
        }
        else {
            html += '<a href=\'https://comp4711-groupproject.firebaseapp.com/hangman.html?rankUpUser=' + JSON.stringify(user) + '\' target="_blank">';
        }
        html += '<div class="app-card card">';
        html += '<div class="card-content">';
        html += '<div class="card-title purple-text">HangMan</div>';
        if (data == 1) {
            html += '<div id="hangmanBadge"></div>';
        } 
        else if (data == 0) {
            html += '<div class="signin-message">Click to grant permission</div>';
        }
        else {
            html += '<div class="signin-message">Click to go to Hang Man</div>';
        }
        html += '</div></div></a></div>';
        this.appLinks.append(html);
        if (data == 1) {
            $.when(this.retrieveHangMan()).done((data) => {
                let badgeHtml = '<div class="badge">';
                    badgeHtml += '<i class="material-icons colored badge-icon">accessibility</i>';
                if (data && data.percentage) {
                    badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                } else {
                    badgeHtml += `<div class="center rank-text purple-text">No data</div>`;
                }
                badgeHtml += '</div>';
                $('#hangmanBadge').html(badgeHtml);
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        }
    },
    /**
     * Generates quiz card html and adds to container.
     */
    loadQuiz: function(user, data) {
        let html = '<div id="quizCard" class="col s12 m4">';
        if (data == 0) {
            html += '<a href="Grant.html?app=quiz">';
        }
        else {
            html += '<a href=\'https://a1-f09ef.firebaseapp.com?rankUpUser=' + JSON.stringify(user) + '\' target="_blank">';
        }
        html += '<div class="app-card card">';
        html += '<div class="card-content">';
        html += '<div class="card-title purple-text">Quiz</div>';
        if (data == 1) {
            html += '<div id="quizBadge"></div>';
        } 
        else if (data == 0) {
            html += '<div class="signin-message">Click to grant permission</div>';
        }
        else {
            html += '<div class="signin-message">Click to go to Quiz</div>';
        }
        html += '</div></div></a></div>';
        this.appLinks.append(html);
        if (data == 1) {
            $.when(this.retrieveJSQuiz()).done((data) => {
                let badgeHtml = '<div class="badge col s6">';
                    badgeHtml += '<i class="devicon-javascript-plain colored badge-icon"></i>';
                if (data && data.percentage) {
                    badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                } else {
                    badgeHtml += `<div class="center rank-text purple-text">No data</div>`;
                }
                badgeHtml += '</div>';
                $('#quizBadge').append(badgeHtml);
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
            $.when(this.retrieveAndroidQuiz()).done((data) => {
                let badgeHtml = '<div class="badge col s6">';
                    badgeHtml += '<i class="devicon-android-plain colored badge-icon"></i>';
                if (data && data.percentage) {
                    badgeHtml += `<div class="center rank-text purple-text">Top ${data.percentage}</div>`;
                } else {
                    badgeHtml += `<div class="center rank-text purple-text">No data</div>`;
                }
                badgeHtml += '</div>';
                $('#quizBadge').append(badgeHtml);
            }).fail((error) => {
                M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                console.log(error);
            });
        }
    },
    /**
     * Generates video chat card html and adds to container.
     */
    loadVideoChat: function(data) {
        let html = '<div id="videoChatCard" class="col s12 m4">';
        html += '<div class="app-card card">';
        html += '<div class="card-content">';
        html += '<div class="card-title purple-text">Video Chat</div>';
        if (data == 1) {
            html += '<a id="generateLink" class="waves-effect waves-light btn purple">Generate Link</a>';
            html += '<div id="linkText"></div>';
        } 
        else if (data == 0) {
            html += '<div class="signin-message"><a href="Grant.html?app=videochat" class="purple-text">Click to grant permission</a></div>';
        }
        else {
            html += '<div class="signin-message">Access denied</div>';
        }
        html += '</div></div></div>';
        this.appLinks.append(html);
        $('#generateLink').click(this.retrieveRoom.bind(this));
    }
};