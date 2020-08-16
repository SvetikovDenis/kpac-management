<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.dhtmlx.com/edge/dhtmlx.css">
    <link rel="stylesheet" type="text/css" href="/resources/styles/setkpacs.css">
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
            <li><a href="/kpacs">Kpacs</a></li>
            <li><a href="/sets">Sets</a></li>
        </ul>
    </div>
</nav>


<div class="container">


    <div class="row">
        <div class='col-md-offset-2 col-md-8'>

            <h2 align="center">Kpacs for set - [id: ${kpacSet.id} title: ${kpacSet.title}]</h2> <br>

            <table id="kpac_table" class="dhtmlxGrid" name="mygrid" width="100%" border="1" name="mygrid"
                   lightnavigation="true" onbeforeinit="initGrid()">
                <tr>
                    <td width="25" sort="int">Id</td>
                    <td sort="str">Title</td>
                    <td sort="na">Delete</td>
                </tr>

                <c:forEach items="${setKpacs}" var="kpac" varStatus="status">
                    <tr>
                        <td>${kpac.id}</td>
                        <td>${kpac.title}</td>
                        <td><a href="/sets/set/${kpacSet.id}/row/${kpacSetKpacs[status.index].id}/delete">
                            <span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>
            </table>

            <h3>Choose Kpac</h3>
            <sf:form class="form-inline" modelAttribute="kpacSetKpac" action="/sets/kpac" method="POST">

                <sf:input type="hidden" path="kpacSetId" value="${kpacSet.id}"/>


                <sf:select path="kpacId" items="${kpacs}" itemLabel="title" itemValue="id"
                           class="form-control">
                </sf:select>

                <input type="submit" name="submit" value="Add" class="btn btn-primary"/>

            </sf:form>

        </div>

    </div>


</div>
</div>

<script>

    function initGrid() {
        mygrid.attachHeader(",#text_filter,");
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
