
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<!-- include summernote css/js-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<style>
.card{
	padding: 10px;
    margin: 5px;
}

.child{

            padding: 1rem;
}
.note-editor{
    border: 1px solid red;
}

.card{
background: yellow;
width: 15rem;
    height: 18rem;
    float:left;
}

/* .card:first-child {
margin-left:15rem;
}

.card:last-child {
margin-right:15rem;

} */
</style>
<body >

<div class=" mine" >
<div class="child" id="sortable">
<%for(int i=0;i<10; i++){ %>
<div class="card">
  <div class="card-block">
    This is some text within a card block.
  </div>
</div>
<%} %>
</div>

</div>
<script>
$(document).ready(function() {
	  $( "#sortable" ).sortable({
	      placeholder: "card"
	    });
	    $( "#sortable" ).disableSelection();    $( "#sortable" ).disableSelection();
    $( ".card" ).each(function( index ) {
        var randomColor = "#"+((1<<24)*Math.random()|0).toString(16);
        $(this).css('background-color', randomColor);

    	});


	
	});
	
	
	
	</script>
</body>
</html>
