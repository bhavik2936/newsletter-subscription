<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Topic</title>

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
                        <div class="row">
                            <div class="col-md-12 mx-auto">
                                <div class="body-box border rounded">
                                    <h2>New Topic</h2>
                                    <form:form modelAttribute="topicBean" method="POST" action="/topic">
                                        <div class="container">
                                            <div class="row">
                                                <div id="errorMessage" class="alert alert-danger w-100 col-md-10 mx-auto d-none" role="alert"></div>
                                                <div id="successMessage" class="alert alert-success w-100 col-md-10 mx-auto d-none" role="alert"></div>
                                            </div>
                                            <div class="col-md-10 row mx-auto">
                                                <div class="form-group col-md-8 mx-auto">
                                                    <input type="text" id="subject" class="form-control" name="subject" placeholder="Enter subject" required>
                                                </div>
                                                <div class="form-group col-md-8 mx-auto">
                                                	<form:select path="categories" multiple="false" cssClass="form-control">
                                                		<form:option value="0" label="All Subscribers"></form:option><c:forEach items="${topicBean.categories}" var="category">
                                                		<form:option value="${category.category_id}" label="${category.category_name}"></form:option></c:forEach>
                                                	</form:select>
                                                </div>
                                                <div class="form-group col-md-8 mx-auto">
                                                    <textarea id="subject" class="form-control" name="message" placeholder="Enter message" aria-multiline="true" required></textarea>
                                                </div>
                                                <div class="form-group col-md-8 mx-auto">
                                                    <button type="submit" class="btn btn-primary">Publish Topic</button>
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
                            <div class="col-md-6 text-left mx-auto"><a class="text-decoration-none" href="/logout"><small>Logout</small></a></div>
                            <div class="col-md-5 text-right mx-auto"><a class="text-decoration-none" target="_blank" href="mailto:bhavik2936@gmail.com?subject=bvk-blog.herokuapp.com error report on page: 'New Topic Request'&body=reporting error on page 'New Topic Request'%0D%0A--"><small>Report an issue</small></a></div>
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
                    url: '/topic',
                    type: 'POST',
                    data: $('form').serialize()
                }).done(function (response) {
                    if (response == 0) {
                        $('#errorMessage').html('Published topic notified to 0 users');
                        $('#errorMessage').removeClass('d-none');
                        $('#errorMessage').show();
                        $('#successMessage').hide();
                    } else {
                        $('#successMessage').html('Published topic notified to ' + response + ' users');
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
                $(':submit').html('Publish Topic');
            });
        });
    </script>
</body>
</html>