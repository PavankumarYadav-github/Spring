<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.navbar {
	background-color: black;
	border-radius: 30px;
}

.navbar ul {
	overflow: auto;
}

.navbar li {
	/* if we float left it overflow from parent to solve this we have to target ul and do overflow auto(It will fits into box)  */
	float: left;
	list-style: none;
	margin: 13px 20px;
}

.navbar li a {
	color: aliceblue;
	text-decoration: none;
	padding: 5px 5px;
}

.navbar li a:hover {
	background-color: aqua;
	border-radius: 20px;
	color: black;
}

.search {
	float: right;
	color: aliceblue;
	padding: 12px 110px;
}

.navbar input {
	border: 2px solid black;
	border-radius: 2px;
	border-radius: 15px;
	outline: none;
	padding: 2px 38px;
	width: 104px;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar">
			<ul>
				<li><a style="color: white;" href="./home">Home</a></li>
				<li><a style="color: white;" href="./add">Add Student</a></li>
				<li><a style="color: white;" href="./update">Update Student</a></li>	
				<li><a style="color: white;" href="./remove">Remove Student</a></li>
				<li><a style="color: white;" href="./search">Search Student</a></li>
				<li><a style="color: white;" href="./logout">Logout</a></li>
			</ul>

		</nav>
	</header>
</body>
</html>