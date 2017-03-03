var button_save = "#button-save";
var element = ".form-control";
var gamescore = ".score-input";
var ratingupdate = ".rating-update";
var button_dashboard = "#button-dashboard";
var button_input = "#button-input";
var button_add_player = "#button_add_player";
var username_input = "#username_input";

$(document).ready(function () {
    $(document).click(function () {
        $("#username_alert").hide();
        $("#username_add").hide();
    });
    $(ratingupdate).hide();
    $(button_save).click(function () {
        $(gamescore).hide();
        $(ratingupdate).show();
        var player1 = $("#player1").find(':selected').text();
        var player2 = $("#player2").find(':selected').text();
        var player3 = $("#player3").find(':selected').text();
        var player4 = $("#player4").find(':selected').text();
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
            success: function (data) {
                console.log("OK");
            },
            failure: function () {
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

    $(username_input).on('keydown', function () {
        $("#username_alert").hide();
        $("#username_add").hide();
    });

    $(button_add_player).click(function () {
        $("#username_add").hide();
        var username = $("#username_input").val();
        var json = {
            username: username
        };
        $.ajax({
            url: '/players/insertPlayer',
            type: 'POST',
            data: JSON.stringify(json),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $("#username_add").show();
            },
            error: function () {
                $("#username_alert").show();
                console.log("FAIL");
            }
        });
    });
    $(button_input).click(function () {
        window.location.href = 'submit.html';
    });
});
