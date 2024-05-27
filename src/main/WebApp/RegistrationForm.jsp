<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">
        <head>
        <style>
        div {text-align : center;}
        </style>
        </head>


<body>
            <meta charset="UTF-8">
            <title>Title</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">


<div>
<form action= "/register/save" method="post">
      <label for="name " > Name : </label>
      <input type = "text" id="name" name="name" required>
      <label for="email" > Email : </label>
      <input type="text" id="email" name="email" required>
      <label for ="location"> Location : </label>
      <input type-"text" id="location" name-"location" required>
      <button type="submit">Add Trainee</button>
 </form>
 </div>
</body>
</html>