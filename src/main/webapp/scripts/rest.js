$(document).ready(function() {
  const mockData = [
    { "playerName": "Name1",
      "rating": 1000,
      "gameWins": 10,
      "gameLoses": 1,
      "setWins": 40,
      "setLoses": 1 },

    { "playerName": "Name2",
      "rating": 999,
      "gameWins": 9,
      "gameLoses": 1,
      "setWins": 30,
      "setLoses": 3 }
  ]

  $("#backToRankButton").click(function() {
    $("#li-tab-rank").click()
  });

  $("#li-tab-rank").click(function() {
    console.log("elo")
    $.ajax({
    url: '/players/getAll',
    type: 'GET',
    success: function(response) {
      for(playerRow of response) {
        var rankNo = 1;
        $("#rank-table").find("tr:gt(0)").remove();
        $('#rank-table tr:last').after("<tr class='player-row' id='"+playerRow.username+"'><td>"+rankNo+"</td><td>"+playerRow.username+"</td><td>"+playerRow.points+"</td><td>"+playerRow.gamesWon+"</td><td>"+playerRow.gamesLost+"</td><td>"+playerRow.setsWon+" : "+playerRow.setsLost+"</td></tr>");
        rankNo++;
      }
    }
    });
  });

  $("body").on("click",".player-row",function(event) {
    console.log("table click")
    const playerId = event.currentTarget.id
    console.log(playerId)
    $("#li-tab-player-stats").click()
    $.ajax({
      url: '/players/getByUsername?username='+playerId,
      type: 'GET',
      success: function(response) {
        console.log(response)
      }
    });
  });

});
