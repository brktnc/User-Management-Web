<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kullanıcı Profili</title>
</head>
<body>
<h1>Kullanıcı Profili</h1>
<p>Kullanıcı Adı: ${sessionScope.username}</p>
<p>E-posta: ${sessionScope.email}</p>
<p>Biyografi: ${sessionScope.bio}</p>
<img src="${sessionScope.profilePicture}" alt="Profil Resmi">
<a href="editProfile.jsp">Profili Duzenle</a>
<a href="changePassword.jsp">Şifre Değiştir</a>
<a href="deleteProfile.jsp">Profili Sil</a>
<form action="logout" method="post">
    <input type="submit" value="Çıkış Yap">
</form>
</body>
</html>
