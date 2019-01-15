let IndexController = function(model, view) {
    this.model = model;
    this.view = view;
};

IndexController.prototype = {
    //Links view to model, loads application cards
    init: function() {
        this.view.retrieveVideoChatRoom = this.model.retrieveVideoChatRoom.bind(this.model);
        this.view.retrieveHangMan = this.model.retrieveHangMan.bind(this.model);
        this.view.retrieveJSQuiz = this.model.retrieveJSQuiz.bind(this.model);
        this.view.retrieveAndroidQuiz = this.model.retrieveAndroidQuiz.bind(this.model);
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.getUserAppInfo = this.model.getUserAppInfo.bind(this.model);
        this.view.loadAppCards();
    }
};