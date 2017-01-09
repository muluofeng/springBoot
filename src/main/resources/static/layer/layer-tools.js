// 在引入css的基础上配置skin参数，如下所示
layer.config({
    skin : 'layer-ext-seaning',
    extend : ['extend/layer.ext.js']
});
function succAlert(msg) {
    layer.msg(msg, {
        icon : 1
    });
}
function succAlert(msg, fun) {
    layer.msg(msg, {
        icon : 1
    }, fun);
}
function failAlert(msg) {
    layer.msg(msg, {
        icon : 11
    });
}
function failAlert(msg, fun) {
    layer.msg(msg, {
        icon : 11
    }, fun);
}