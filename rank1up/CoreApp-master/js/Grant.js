$(function () {
    let model = new GrantModel(),
        appbar = new AppBar(),
        view = new GrantView(appbar),
        controller = new GrantController(model, view);
        
    controller.init();
});