<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title> Users Delete ${id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link href="/css/demo.css" rel="stylesheet"> -->

            </head>

            <body>
                <!-- <h3> Delete the user with id = ${id}</h3>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
                        <use xlink:href="#exclamation-triangle-fill" />
                    </svg>
                    <div>
                        Are you sure delete this user?
                    </div>
                </div>
                <button class="btn btn-danger">Confirm</button>
                <a href="/admin/user" class="btn btn-success">ComeBack</a> -->
                <!-- </div> -->
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <div class="d-flex justify-content-between">
                                <h3>Delete the user with id = ${id}</h3>
                            </div>
                            <hr>
                            <div class="alert alert-danger">
                                Are you sure to delete this user ?
                            </div>
                            <form:form method="POST" action="/admin/user/delete" modelAttribute="deleteUser">
                                <div class="mb-3" style="display: none;">
                                    <label for="form-label" class="form-label">Id: </label>
                                    <form:input value="${id}" type="text" class="form-control" path="id" />
                                </div>
                                <button class="btn btn-danger">Confirm</button>
                                <!-- </form> -->
                            </form:form>
                        </div>
                        <a href="/admin/user" class="btn btn-success">ComeBack</a>
                    </div>
                </div>

            </body>

            </html>