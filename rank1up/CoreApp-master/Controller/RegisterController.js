let RegisterController = function(model, view) {
    this.model = model;
    this.view = view;
};

RegisterController.prototype = {
    //Links view to model
    init: function() {
        this.view.registerUser = this.model.registerUser.bind(this.model);
        this.view.saveProfileDesc = this.model.saveProfileDesc.bind(this.model);
    }
};