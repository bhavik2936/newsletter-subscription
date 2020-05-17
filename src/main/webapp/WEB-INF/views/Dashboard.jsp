<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bhavik Parmar</title>

<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
    <div class="container-md">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <div class="outer-box rounded">
                    <div class="container-md">
                        <div class="row header-box">
                            <div class="col-md-9">
                                <h1 style="height: 100%; vertical-align: middle;">Bhavik Parmar</h1>
                            </div>
                            <div class="col-md-3"><img src="/media/bvk.jpg" class="rounded" width="135px" height="135px"></div>
                        </div>
                    </div>
                    <div class="container-md">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="body-box border rounded">
                                    <h4>Email Subscription</h4>
                                    <form:form method="POST" action="/" modelAttribute="userBean">
                                        <div class="container">
                                            <div class="row">
                                                <form:errors title="failed" path="*" cssClass="alert alert-danger w-100 col-md-10 mx-auto" />
                                            </div>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="form-group col-md-8">
                                                    <input type="email" id="email" class="form-control email-subscription" name="email" placeholder="Enter email" required>
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <input type="submit" class="btn btn-primary" value="Subscribe">
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</body>
</html>