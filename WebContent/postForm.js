/**
 * 
 */

$(document).ready(function(){
  $("form").submit(function(event){
    $("#return").text("").show();
    var data = $("form").serialize();
    var postData = $.ajax({
      method: "POST",
      url: "http://localhost:8080/TTG/login",
      data: data
    });
    postData.done(function(msg){
      $("#return").text(msg).show().fadeOut(2000);
    });
    event.preventDefault();
  });
  
  /**
   *  This click listener is made for index.html
   *  It looks at the id of the button clicked and send that to
   *  the router servlet for processing. Made specifically for CategoryDAO.
   */
  $('button').click(function(event){
    $.getJSON(
        "router", 
        "id="+$(this).attr("id"),
        function(data) {
          var $table = $('<table>').appendTo($('#return'));
          $.each(data, function(idx, account) {
            $('<tr>').appendTo($table)
              .append($('<td>').text(account.name))
              .append($('<td>').text(account.industry))
              .append($('<td>').text(account.country))
              .append($('<td>').text(account.phone));
          });
      });
  });
  
  /*
  $('button').click(function() {
    $.getJSON('categories.json', function(categoriesJson) {
        var $table = $('<table>').appendTo($('#somediv'));
        $.each(categoriesJson, function(index, category) {
            $('<tr>').appendTo($table)
                .append($('<td>').text(category.id))
                .append($('<td>').text(category.name))
                .append($('<td>').text(category.department));
        });
    });
});
*/
  
  
});