$(function () {
    let model = new RegisterModel(),
        appbar = new AppBar(),
        view = new RegisterView(appbar),
        controller = new RegisterController(model, view);
        
    controller.init();
});