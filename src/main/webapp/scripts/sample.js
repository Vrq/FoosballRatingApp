var button_save = "#button-save";
var element = ".form-control";
var gamescore = ".score-input";
var ratingupdate = ".rating-update";
var button_dashboard = "#button-dashboard";
$(document).ready(function () {
    $(ratingupdate).hide();
    $(button_save).click(function () {
        $(element).prop('disabled', true);
        $(gamescore).hide();
        $(ratingupdate).show();
    });
    $(button_dashboard).click(function () {
        window.location.href = 'index.html';
    });
    // $(".players").on('change', function() {
    //   `console.log( this );`
    // })
});
