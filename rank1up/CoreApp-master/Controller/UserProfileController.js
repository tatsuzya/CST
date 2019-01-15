let UserProfileController = function(model, view) {
    this.model = model;
    this.view = view;
};

UserProfileController.prototype = {
    //Links view to model, check authentication
    init: function() {
        this.view.retrieveUser = this.model.retrieveUser.bind(this.model);
        this.view.retrieveHangMan = this.model.retrieveHangMan.bind(this.model);
        this.view.retrieveJSQuiz = this.model.retrieveJSQuiz.bind(this.model);
        this.view.retrieveAndroidQuiz = this.model.retrieveAndroidQuiz.bind(this.model);
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.saveName = this.model.saveName.bind(this.model);
        this.view.saveDesc = this.model.saveDesc.bind(this.model);
        this.view.saveImg = this.model.saveImg.bind(this.model);
        this.view.checkAuth();
    }
};