$(function () {
    let model = new UserProfileModel(),
        appbar = new AppBar(),
        view = new UserProfileView(appbar),
        controller = new UserProfileController(model, view);
        
    controller.init();
});