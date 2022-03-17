//jquery 형 함수
checkNull = function(obj, value, message) {
	if (value == "" || value == null) {
		alert("validation.js: " + message);
		obj.focus();
		return false;
		//return false는 중지하는 구문이다
	} else {
		return true;
	}

}
/*
//javascript
function checkNull (obj, value, message) {
	if (value == "" || value == null) {
		alert("validation.js: " + message);
		obj.focus();
		return false;
		//return false는 중지하는 구문이다
	}

}
*/