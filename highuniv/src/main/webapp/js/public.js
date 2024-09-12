$(function () {
    const hamBtn = $(".ham-btn");
    const hamMenu = $(".ham-menu");
    // console.log(hamBtn);
    // console.log(hamMenu);

    hamBtn.click(() => {
        if (hamMenu.css('display') == 'none') {
            // console.log(hamMenu.css('display'));
            hamMenu.show();
        } else {
            // console.log(hamMenu.css('display'));
            hamMenu.hide();
        }

    });

});