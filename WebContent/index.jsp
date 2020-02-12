<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/uikit.min.css" />
    <script src="assets/js/uikit.min.js"></script>
    <script src="assets/js/uikit-icons.min.js"></script>
</head>
<body>


<div>

	<form class="uk-grid-small" action="addBooks" method="POST" uk-grid>
	    <div class="uk-width-1-2@s">
	    	<label class="uk-label" for="txtLibro"></label>
	        <input class="uk-input" type="text" id="txtLibro" name="txtLibro" placeholder="Name of the book">
	    </div>
	    <div class="uk-width-1-2@s">
	    	<label class="uk-label" for="txtAuthor"></label>
	        <input class="uk-input" type="text" id="txtAuthor" name="txtAuthor" placeholder="Author">
	    </div>
	    <div class="uk-width-1-2@s">
	    	<label class="uk-label" for="txtIsbn"></label>
	        <input class="uk-input" type="text" id="txtIsbn" name="txtIsbn" placeholder="Introduce ISBN">
	    </div>
	    <div class="uk-width-1-2@s">
	        <input class="uk-button uk-button-primary" type="submit" value="Send">
	    </div>
	</form>

 </div>
</body>
</html>