let MessageView = function(appBar) {
    this.appBar = appBar;
    this.init();
};

MessageView.prototype = {
    /**
     * Initializes view.
     */
    init: function() {
        this.setElements();
        this.setListeners();
        this.appBar.init(this.navContainer);
        $('.tabs').tabs();
        CKEDITOR.replace('ckeditor', {on: {instanceReady: () => {
            this.searchInit();
            this.appBar.hidePreloader();
        }}});
    },
    /**
     * Sets html elements to variables.
     */
    setElements: function() {
        this.navContainer = $('.nav-container');
        this.composeForm = $('.compose-form');
        this.to = $('#to');
        this.inboxContainer = $('.inbox-container');
        this.sentContainer = $('.sent-container');
    },
    /**
     * Sets listeners.
     */
    setListeners: function() {
        this.composeForm.submit(this.send.bind(this));
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
     * Send a email to a user from logged in user.
     */
    send: function() {
        $.when(this.sendMessage(this.to.val(), CKEDITOR.instances.ckeditor.getData())).done((data) => {
            if (!data.errorMessage) {
                M.toast({html: rankupmsg.message.sent, classes: 'green'});
                this.to.val('');
                CKEDITOR.instances.ckeditor.setData('');
            } else {
                M.toast({html: rankupmsg.error.sendmsg, classes: 'red'});
            }
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Generates html for messages of logged in user for inbox and sent. Appends to containers.
     */
    loadMessages: function() {
        $.when(this.retrieveMessages()).done((data) => {
            let inboxHtml = '';
            let sentHtml = '';
            if (data.inbox && data.inbox.length > 0) {
                data.inbox.forEach((message) => {
                    let timestamp = new Date(message.dateTime);
                    inboxHtml += '<li class="collection-item row">';
                    inboxHtml += '<div class="col s6"><span class="purple-text message-title">From: </span>' + message.sender + '</div>';
                    inboxHtml += '<div class="col s6 timestamp"><span class="purple-text message-title">Time: </span>' + timestamp.toLocaleString() + '</div>';
                    inboxHtml += '<div class="col s12 message-text"><span class="purple-text message-title">Message: </span></div>';
                    inboxHtml += '<div class="col s12">' + message.message + '</div>';
                    inboxHtml += '</li>';
                });
            } else {
                inboxHtml = '<li class="collection-item center">No messages</li>';
            }
            if (data.sent && data.sent.length > 0) {
                data.sent.forEach((message) => {
                    let timestamp = new Date(message.dateTime);
                    sentHtml += '<li class="collection-item row">';
                    sentHtml += '<div class="col s6"><span class="purple-text message-title">To: </span>' + message.recipient + '</div>';
                    sentHtml += '<div class="col s6 timestamp"><span class="purple-text message-title">Time: </span>' + timestamp.toLocaleString() + '</div>';
                    sentHtml += '<div class="col s12 message-text"><span class="purple-text message-title">Message: </span></div>';
                    sentHtml += '<div class="col s12">' + message.message + '</div>';
                    sentHtml += '</li>';
                });
            } else {
                sentHtml = '<li class="collection-item center">No messages</li>';
            }
            this.inboxContainer.html(inboxHtml);
            this.sentContainer.html(sentHtml);
        }).fail((error) => {
            M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
            console.log(error);
        });
    },
    /**
     * Initializes search, adding listeners to input.
     */
    searchInit: function() {
        $('#to').focus(() => {
            $('.message-search-results').show();
        });
        $('#to').on('input', () => {
            this.startSearch();
        });
        $('body').click((event) => {
            if (event.target != $('#to')[0] && !$('.message-search-results').has(event.target).length) {
                $('.message-search-results').hide(); 
            }
        });
    },
    /**
     * Starts a search using the values from input.
     */
    startSearch: function() {
        let searchInput = $('#to').val()
        if (this.timer) {
            clearTimeout(this.timer);
        }
        if (searchInput) {
            this.timer = setTimeout(()=> {
                $.when(this.searchUsers(searchInput)).done((data) => {
                    if (data && !data.errorMessage) {
                        this.loadSearchResults(data);
                    }
                }).fail((error) => {
                    M.toast({html: rankupmsg.error.unexpected, classes: 'red'});
                    console.log(error);
                });
            }, 300);
        } else {
            $('.message-search-list').html('Search for a user');
        }
    },
    /**
     * Parse results, build html and add to search results container.
     * @param results Object.   result from API call.
     */
    loadSearchResults: function(results) {
        let resultsHtml = '';
        if (results.length > 0) {
            results.forEach((user) => {
                let fullname = user.fName + ' ' + user.lName;
                resultsHtml += '<li class="message-result-li"><div class="black-text" value="' + user.emailAddress + '">' + fullname + ' (' + user.emailAddress + ')</div></li>'
            });
        } else {
            resultsHtml = 'No results';
        }
        $('.message-search-list').html(resultsHtml);
        $('.message-result-li').click((event) => {
            console.log($(event.target));
            this.to.val($(event.target).attr('value'));
            $('.message-search-results').hide();
        });
    },
};