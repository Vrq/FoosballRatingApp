$(document).ready(function() {
  $("#backToRankButton").click(function() {
    $("#li-tab-rank").click()
  });

  $("#li-tab-rank").click(function() {
    console.log("elo")
    $.ajax({
    url: '/players/getAll',
    type: 'GET',
    success: function(response) {
      $("#rank-table").find("tr:gt(0)").remove();
      var rankNo = 1;
      for(playerRow of response) {
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
