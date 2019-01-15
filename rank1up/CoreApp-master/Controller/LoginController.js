let LoginController = function(model, view) {
    this.model = model;
    this.view = view;
};

LoginController.prototype = {
    //Links view to model, check authentication and URL for seach params
    init: function() {
        this.view.loginUser = this.model.loginUser.bind(this.model);
        this.view.sendRecoveryEmail = this.model.sendRecoveryEmail.bind(this.model);
        this.view.setNewPass = this.model.setNewPass.bind(this.model);
        this.view.storeUser = this.model.storeUser.bind(this.model);
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.checkPermission = this.model.checkPermission.bind(this.model);
        this.view.checkAuth();
        this.view.checkURL();
    }
};