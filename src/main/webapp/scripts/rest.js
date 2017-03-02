$("#rankButton").click(function() {
  console.log("elo")
  $.ajax({
    url: '/ranking',
    type: 'GET',
    success: function(response) {
      console.log(response)
    }
  });
});
