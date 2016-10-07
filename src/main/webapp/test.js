$( function() {
  function runEffect() {
    $( "#effect" ).effect("shake", 500);
  };
  $( "#login" ).on( "click", function() {
    runEffect();
  });
} );
