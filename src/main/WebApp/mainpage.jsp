<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">
        <head>
        <style>
        h1{text-align : center;}
        div{text-align : center ;}
        body{background-color : yellow;}
        </style>
        <Title>Trainee Management Application </Title>
        </head>


<body>

<h1> Trainee Management Application </h1>
            <meta charset="UTF-8">
            <title>Title</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">


<div>
 <form action="/mainpage/gettrainee" method="post" >
         <button type="submit">VIEW TRAINEES</a></button>
      </form>
 <form action="/mainpage/register" method="post">
       <button type="submit">ADD TRAINEES </a></button>
       </form>
       <form action="/mainpage/" method="post">
              <button type="submit">SEARCH TRAINEES BY NAME </a></button>
              </form>

 </div>
</body>
</html>