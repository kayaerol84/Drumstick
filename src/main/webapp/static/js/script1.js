function displayDateTime(){
	document.getElementById('button1').innerHTML = Date();
}

function showComment(){
	document.getElementById('commentBox').style.display = "block";
	
}

function closeComment(){
	document.getElementById('commentBox').style.display = "none";
	
}

function callSearchConnectUrl(){
	window.location="http://localhost:8080/drumstick/loadSearchAndConnect";
}


