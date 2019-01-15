$(function () {
    let model = new IndexModel(),
        appbar = new AppBar(),
        view = new IndexView(appbar),
        controller = new IndexController(model, view);
        
    controller.init();
});