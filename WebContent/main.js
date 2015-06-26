/**
 * 
 */

$(document).ready(function(){
  $("form").submit(function(event){
    console.log("Prevented default submit.");
    
    var frm = $("form");
    var data = JSON.stringify(frm.serializeArray());
    console.log(data);
    
    var postData = $.ajax({
      method: "POST",
      url: "http://localhost:8080/TTG/login",
      data: data
    });
    
    postData.done(function(msg){
      alert("finished ::"+msg);
    });
    
    event.preventDefault();
  });
});