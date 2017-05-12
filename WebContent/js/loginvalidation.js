function validateCredentials() {
	var userName = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	
	var usernameRegexp = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	var passwordRegexp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	
	if(!usernameRegexp.test(userName) || !passwordRegexp.test(password)){
		var errorMessage = document.getElementsByClassName("errordiv")[0];
		if(errorMessage.classList.contains("display-none")) {
			errorMessage.classList.remove("display-none");
		}
		errorMessage.classList.add("display-block");
		return false;
	}
	return true;
}