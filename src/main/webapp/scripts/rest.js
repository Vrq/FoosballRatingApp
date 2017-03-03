$(document).ready(function() {
  $.ajax({
  url: '/players/getAll',
  type: 'GET',
  success: function(response) {
    $("#rank-table").find("tr:gt(0)").remove();
    var rankNo = 1;
    for(playerRow of response) {
      $('#rank-table tbody').append("<tr class='player-row' id='"+playerRow.username+"'><td>"+rankNo+"</td><td>"+playerRow.username+"</td><td>"+playerRow.points+"</td><td>"+playerRow.gamesWon+"</td><td>"+playerRow.gamesLost+"</td><td>"+playerRow.setsWon+" : "+playerRow.setsLost+"</td></tr>");
      rankNo++;
    }
     $('#example').DataTable({

     });
     $('#rank-table').DataTable({
       "lengthChange": false,
       "paging": false,
       "info": false,
    //   "dom": -f'<"toolbar">rtip' // TODO: fix this to move search box to the middle
     });

  }
  });

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
        $('#rank-table tbody').append("<tr class='player-row' id='"+playerRow.username+"'><td>"+rankNo+"</td><td>"+playerRow.username+"</td><td>"+playerRow.points+"</td><td>"+playerRow.gamesWon+"</td><td>"+playerRow.gamesLost+"</td><td>"+playerRow.setsWon+" : "+playerRow.setsLost+"</td></tr>");
        rankNo++;
      }
    }
    });
  });

  $("body").on("click",".player-row",function(event) {
    console.log("table click")
    const playerId = event.currentTarget.id
    console.log(playerId)
    $('#player-stats-div').empty();
    $("#li-tab-player-stats").click()
    $.ajax({
      url: '/players/getByUsername?username='+playerId,
      type: 'GET',
      success: function(response) {
        console.log(response)
        $('#player-stats-div').append("<h4>Player: "+response.username+"</h4><h4>Rating: "+response.points+"</h4><h4>Games won: "+response.gamesWon+"</h4><h4>Games lost: "+response.gamesLost+"</h4>")
      }
    });
  });

});
