<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.dhtmlx.com/edge/dhtmlx.css">
    <link rel="stylesheet" type="text/css" href="/resources/styles/app.css">
    <script src="//cdn.dhtmlx.com/edge/dhtmlx.js"></script>

</head>

<body>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Kpac Management</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/index">Home</a></li>
            <li class="active"><a href="/kpacs">Kpacs</a></li>
            <li><a href="/sets">Sets</a></li>
        </ul>
    </div>
</nav>


<div class="container-fluid">


    <c:if test="${not empty message}">
        <div class="row">
            <div class="col-xs-12 col-md-offset-2 col-md-8">
                <div class="alert alert-danger fade in">${message}</div>
            </div>
        </div>
    </c:if>


        <div class="row">

            <div class="col-md-offset-2 col-md-8">

                <div class="panel panel-info">

                    <div class="panel-heading">

                        <h4>New Kpac</h4>

                    </div>

                    <div class="panel-body">
                        <sf:form class="form-horizontal" modelAttribute="kpac" action="/kpacs" method="POST">

                            <div class="form-group">
                                <label class="control-label col-md-4">Title</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="title" class="form-control"
                                              placeholder="Title"/>
                                    <sf:errors path="title" cssClass="error" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4">Description</label>
                                <div class="col-md-8">
                                    <sf:textarea rows="5" path="description" class="form-control" placeholder="Description"/>
                                    <sf:errors path="description" cssClass="error" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-md-offset-4 col-md-4">

                                    <input type="submit" name="submit" value="Save" class="btn btn-primary"/>

                                </div>
                            </div>

                        </sf:form>

                    </div>

                </div>

            </div>

        </div>

    <div class="row">
        <div class="col-lg-12">

            <table id="kpac_grid_table" class="dhtmlxGrid" name="mygrid" border="1" lightnavigation="true" onbeforeinit="initGrid()">
                <tr id="table_header_row">
                    <td width="25px"  sort="int" >Id</td>
                    <td width="250px" sort="str" >Title</td>
                    <td  sort="srt">Description</td>
                    <td width="100" format="%d-%m-%Y" type="dhxCalendar" sort="date" >Created</td>
                    <td  sort="na">Delete</td>
                </tr>

                <c:forEach items="${kpacs}" var="kpac">
                    <tr>
                        <td>${kpac.id}</td>
                        <td>${kpac.title}</td>
                        <td>${kpac.description}</td>
                        <td>${kpac.created}</td>
                        <td><a href="/kpacs/delete/${kpac.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>


            </table>

        </div>
    </div>
</div>

<script>
    function initGrid() {
        mygrid.setEditable(false);
        mygrid.enableAutoWidth(false);
        mygrid.enableAutoHeight(true);
        mygrid.setSizes();
    }
</script>







<script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
