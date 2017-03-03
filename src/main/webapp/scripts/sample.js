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
        var playersArray = [player1, player2, player3, player4];
        console.log(playersArray)
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
                console.log("Game inserted");
                for(player of playersArray) {
                  $.ajax({
                    url: '/scores/latestScoreForPlayer?playerName=' + player,
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function(dataLatest) {
                      $.ajax({
                        url: '/scores/previousScoreForPlayer?playerName=' + dataLatest.username,
                        type: 'GET',
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function(dataPrevious) {
                          var arrowClass;
                          if(dataLatest.rank < dataPrevious.rank) {
                            arrowClass = "glyphicon-arrow-up glyphicon-move-up";
                          } else {
                            if(dataLatest.rank > dataPrevious.rank) {
                              arrowClass = "glyphicon-arrow-down glyphicon-move-down";
                            } else {
                              arrowClass = "glyphicon-arrow-right";
                            }
                          }
                          console.log(arrowClass)
                          $("#rankUpdateTable tbody").append("<tr class='player'><th>" + dataLatest.username + "</th><td><span class='glyphicon "+arrowClass+"'></span></td><td>"+dataPrevious.points+"</td><td>" + dataLatest.points + "</td></tr>");
                        }
                      });
                    }
                  });
                }
            },
            failure: function() {
                console.log("Game insert failure");
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
        var username = $("#add-username-input").val();
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
