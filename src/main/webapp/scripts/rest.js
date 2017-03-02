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
    var rankNo = 1;
    $("#rank-table").find("tr:gt(0)").remove();
    for(playerRow of mockData) {
      console.log(playerRow)
      $('#rank-table tr:last').after("<tr class='player-row' id='"+playerRow.playerName+"'><td>"+rankNo+"</td><td>"+playerRow.playerName+"</td><td>"+playerRow.rating+"</td><td>"+playerRow.gameWins+"</td><td>"+playerRow.gameLoses+"</td><td>"+playerRow.setWins+" : "+playerRow.setLoses+"</td></tr>");
      rankNo++;
    }
      $.ajax({
      url: '/players',
      type: 'GET',
      success: function(response) {
        console.log(response)
      }
    });
  });

  $("body").on("click",".player-row",function(event) {
    console.log("table click")
    const playerId = event.currentTarget.id
    console.log(playerId)
    $("#li-tab-player-stats").click()
    $.ajax({
      url: '/player/'+playerId,
      type: 'GET',
      success: function(response) {
        console.log(response)
      }
    });
  });

});
