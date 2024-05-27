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

                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td>${traineeDtos.id()}</td>
                            <td>${traineeDtos.name()}</td>
                            <td>${traineeDtos.email()}</td>
                            <td>${traineeDtos.location()}</td>

                        </tr>
                </tbody>
            </table>
        </body>

        </html>