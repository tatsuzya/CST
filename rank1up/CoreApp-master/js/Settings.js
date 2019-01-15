$(function () {
    let model = new SettingsModel(),
        appbar = new AppBar(),
        view = new SettingsView(appbar),
        controller = new SettingsController(model, view);
        
    controller.init();
});