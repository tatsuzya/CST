let SettingsController = function(model, view) {
    this.model = model;
    this.view = view;
};

SettingsController.prototype = {
    //Links view to model, check authentication
    init: function() {
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.changePass = this.model.changePass.bind(this.model);
        this.view.logout = this.model.logout.bind(this.model);
        this.view.checkAuth();
    }
};