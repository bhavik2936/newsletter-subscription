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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

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
                                    <form:form modelAttribute="userBean">
                                        <div class="container">
                                            <div class="row">
                                                <div id="errorMessage" class="alert alert-danger w-100 col-md-10 mx-auto d-none" role="alert"></div>
                                                <div id="successMessage" class="alert alert-success w-100 col-md-10 mx-auto d-none" role="alert"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="form-group col-md-8">
                                                    <input type="email" id="email" class="form-control email-subscription" name="email" placeholder="Enter email" required>
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <button type="submit" class="btn btn-primary">Subscribe</button>
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
    <script>
        $(document).ready(function() {
            $('form').submit(function() {
                $(':submit').prop('disabled', true);
                $(':submit').html('<span class="spinner-border spinner-border-sm"></span>');

                $.ajax({
                    url: '/',
                    type: 'POST',
                    data: $('form').serialize()
                }).done(function (response) {
                    if (response == 2) {
                        $('#errorMessage').html('Already subscribed to mailing list');
                        $('#errorMessage').removeClass('d-none');
                        $('#errorMessage').show();
                        $('#successMessage').hide();
                    } else if (response == 0) {
                        $('#errorMessage').html('Couldn\'t subscribe to mailing list, Please try again');
                        $('#errorMessage').removeClass('d-none');
                        $('#errorMessage').show();
                        $('#successMessage').hide();
                    } else {
                        $('#successMessage').html('Successfully subscribed to mailing list');
                        $('#successMessage').removeClass('d-none');
                        $('#successMessage').show();
                        $('#errorMessage').hide();
                    }
                }).fail(function(jqXHR, textStatus, errorThrown) {
                    $('#errorMessage').html('An error occured, Please try again');
                    $('#errorMessage').removeClass('d-none');
                    $('#errorMessage').show();
                    $('#successMessage').hide();
                });

                return false;
            });

            $(document).ajaxComplete(function() {
                $(':submit').prop('disabled', false);
                $(':submit').html('Subscribe');
            });
        });
    </script>
</body>
</html>