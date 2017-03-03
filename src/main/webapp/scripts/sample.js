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
        var player1=$("#player1").find(':selected').text();
        var player2=$("#player2").find(':selected').text();
        var player3=$("#player3").find(':selected').text();
        var player4=$("#player4").find(':selected').text();
        var json = {
            aPlayer1: player1,
            aPlayer2: player2,
            bPlayer1: player3,
            bPlayer2: player4,
            aScore: $("#score1").find(':selected').text(),
            bScore: $("#score2").find(':selected').text()
        };
        $.ajax({
            url: '/games/insertGame',
            type: 'POST',
            data: JSON.stringify(json),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
                console.log("OK");
            },
            failure: function() {
                console.log("FAIL");
            }
        });
        $("#username1").text(player1);
        $("#username2").text(player2);
        $("#username3").text(player3);
        $("#username4").text(player4);
    });
    $(button_dashboard).click(function () {
        window.location.href = 'index.html';
    });
});
