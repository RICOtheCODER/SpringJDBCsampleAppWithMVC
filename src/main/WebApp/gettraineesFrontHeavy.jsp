<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Title</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        </head>

        <body>
            <h1>Trainees</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="trainee" items="${traineeDtos}">
                        <tr>
                            <td>${trainee.id()}</td>
                            <td>${trainee.name()}</td>
                            <td>${trainee.email()}</td>
                            <td>${trainee.location()}</td>
                            <td>
                                <button onclick="deleteTrainee(${trainee.id()})" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

<script>
  let deleteTrainee = (id)=>{
            if(confirm("Deleting trainee with id: "+id)){
                window.location.href = "delete-trainee?id=" + id;
            }
        }

        </script>

        </html>