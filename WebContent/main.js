/**
 * 
 */

$(document).ready(function(){
  $("form").submit(function(event){
    console.log("Prevented default submit.");
    event.preventDefault();
  });
});