<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, <%= session.getAttribute("username") %></h1>
<a href="logout">Logout</a>
</body>
</html>
