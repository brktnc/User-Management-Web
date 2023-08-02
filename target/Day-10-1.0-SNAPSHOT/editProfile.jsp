<!DOCTYPE html>
<html lang="tr">
<head>
    <title>Profil Duzenle</title>
</head>
<body>
<h1>Profil Duzenle</h1>
<form action="updateProfile" method="post">
    <label for="username">Kullanici Adi:</label>
    <input type="text" id="username" name="username" value="<%= request.getAttribute("username") %>"><br>

    <label for="email">E-posta:</label>
    <input type="email" id="email" name="email" value="<%= request.getAttribute("email") %>"><br>

    <label for="profile_picture">Profil Resmi URL:</label>
    <input type="text" id="profile_picture" name="profile_picture" value="<%= request.getAttribute("profilePicture") %>"><br>

    <label for="bio">Biyografi:</label><br>
    <textarea id="bio" name="bio" rows="4" cols="50"><%= request.getAttribute("bio") %></textarea><br>

    <input type="submit" value="Guncelle">
</form>
<a href="profile.jsp">Profili Goruntule</a>
</body>
</html>
