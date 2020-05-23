<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Panel</title>

<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</head>
<body>
    <div class="container-md">
        <div class="row">
            <div class="col-md-10 mx-auto">
                <div class="outer-box rounded">
                    <div class="container-md">
                        <div class="row">
                            <div class="col-md-10 mx-auto">
                                <div class="body-box border rounded">
                                    <h2>Admin Access</h2>
                                    <form:form modelAttribute="adminBean" method="POST" action="/admin">
                                        <div class="container">
                                            <div class="row">
                                            	<form:errors id="errorMessage" cssClass="alert alert-danger w-100 col-md-10 mx-auto d-none"></form:errors>
                                            </div>
                                            <div class="col-md-10 row mx-auto">
                                                <div class="form-group col-md-8 mx-auto">
                                                    <input type="text" id="username" class="form-control" name="username" placeholder="Enter username" required>
                                                </div>
                                                <div class="form-group col-md-8 mx-auto">
                                                    <input type="password" id="password" class="form-control" name="password" placeholder="Enter passcode" required>
                                                </div>
                                                <div class="form-group col-md-8 mx-auto">
                                                    <button type="submit" class="btn btn-primary">Get Access</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-md">
                        <div class="row">
                            <div class="col-md-6 text-left mx-auto"><a class="text-decoration-none" href="/"><small>Dashboard</small></a></div>
                            <div class="col-md-5 text-right mx-auto"><a class="text-decoration-none" target="_blank" href="mailto:bhavik2936@gmail.com?subject=bvk-blog.herokuapp.com error report on page: 'Admin Panel'&body=reporting error on page 'Admin Panel'%0D%0A--"><small>Report an issue</small></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>