$(function () {
    let model = new MessageModel(),
        appbar = new AppBar(),
        view = new MessageView(appbar),
        controller = new MessageController(model, view);
        
    controller.init();
});