<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add good to storage</title>
</head>
<body>



<form class="modal-content animate" action="MyController"
			method="post">
			<input type="hidden" name="command" value="registration">
			<div class="imgcontainer">
				<img src="img/img_avatar2.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label for="name"><b>${name}</b></label> <input type="text"
					placeholder="${enter_name}" name="name" required> <label
					for="surname"><b>${surname}</b></label> <input type="text"
					placeholder="${enter_surname}" name="surname" required> <label
					for="login"><b>${login}</b></label> <input type="text"
					placeholder="${enter_login}" name="login" required> <label
					for="psw"><b>${password}</b></label> <input type="password"
					placeholder="${enter_pass}" name="psw" required> <label
					for="address"><b>${enter_address}</b></label> <input type="text"
					placeholder="${enter_address}" name="address" required>

				<button type="submit">${registration}</button>
			</div>
		</form>

</body>
</html>