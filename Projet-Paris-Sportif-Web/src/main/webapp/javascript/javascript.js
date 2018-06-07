
	document.getElementById ("mdp1").addEventListener ("click", myFunction, false);

function myFunction() {
    var x = document.getElementById("mdp");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}