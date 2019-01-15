let MessageController = function(model, view) {
    this.model = model;
    this.view = view;
};

MessageController.prototype = {
    //Links view to model, check authentication, load messages from db
    init: function() {
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.sendMessage = this.model.sendMessage.bind(this.model);
        this.view.searchUsers = this.model.searchUsers.bind(this.model);
        this.view.retrieveMessages = this.model.retrieveMessages.bind(this.model);
        this.view.checkAuth();
        this.view.loadMessages();
    }
};