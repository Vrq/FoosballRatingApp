$(document).ready(function () {
    let rankTableID = "#rank-table";
    let rankTableBody = '#rank-table tbody';
    let tableSettings = {
        "lengthChange": false,
        "paging": false,
        "info": false,
        //   "dom": -f'<"toolbar">rtip' // TODO: fix this to move search box to the middle
    };

    function populateTable() {
        $.ajax({
            url: '/players/getAll',
            type: 'GET',
            success: function (response) {
                $(rankTableID).find("tr:gt(0)").remove();
                var rankNo = 1;
                for (playerRow of response) {
                    $(rankTableBody).append("<tr class='player-row' id='" + playerRow.username + "'><td>" + rankNo + "</td><td>" + playerRow.username + "</td><td>" + playerRow.points + "</td><td>" + playerRow.gamesWon + "</td><td>" + playerRow.gamesLost + "</td><td>" + playerRow.setsWon + " : " + playerRow.setsLost + "</td></tr>");
                    rankNo++;
                    $('.players').append($("<option></option>").text(playerRow.username));
                }
                let table = $(rankTableID).DataTable(tableSettings);
            }
        });
    }
    populateTable();

    $("#backToRankButton").click(function () {
        $("#li-tab-rank").click()
    });

    $("body").on("click", ".player-row", function (event) {
        console.log("table click")
        const playerId = event.currentTarget.id
        console.log(playerId)
        $('#player-stats-div').empty();
        $("#li-tab-player-stats").click()
        $.ajax({
            url: '/players/getByUsername?username=' + playerId,
            type: 'GET',
            success: function (response) {
                console.log(response)
                $('#player-stats-div').append("<h4>Player: " + response.username + "</h4><h4>Rating: " + response.points + "</h4><h4>Games won: " + response.gamesWon + "</h4><h4>Games lost: " + response.gamesLost + "</h4>")
            }
        });
    });
});
