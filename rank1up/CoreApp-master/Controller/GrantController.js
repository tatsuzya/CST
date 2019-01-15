let GrantController = function(model, view) {
    this.model = model;
    this.view = view;
};

GrantController.prototype = {
    //Links view to model, check authentication
    init: function() {
        this.view.getCurUser = this.model.getCurUser.bind(this.model);
        this.view.grantPermission = this.model.grantPermission.bind(this.model);
        this.view.checkAuth();
    }
};