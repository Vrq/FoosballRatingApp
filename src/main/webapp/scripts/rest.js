$(document).ready(function() {
  $("#backToRankButton").click(function() {
    console.log("elo")
    $("#li-tab-rank").click()
    $.ajax({
      url: '/ranking',
      type: 'GET',
      success: function(response) {
        console.log(response)
      }
    });
  });
  $(".player-row").click(function(event) {
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
