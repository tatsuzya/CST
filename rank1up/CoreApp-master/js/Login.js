$(function () {
    let model = new LoginModel(),
        appbar = new AppBar(),
        view = new LoginView(appbar),
        controller = new LoginController(model, view);
        
    controller.init();
});