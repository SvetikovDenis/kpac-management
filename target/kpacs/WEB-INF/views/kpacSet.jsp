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
            <li><a href="/kpacs">Kpacs</a></li>
            <li class="active"><a href="/sets">Sets</a></li>
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

                    <h4>New Kpac Set</h4>

                </div>

                <div class="panel-body">
                    <sf:form class="form-horizontal" modelAttribute="kpacSet" action="/sets" method="POST">

                        <div class="form-group">
                            <label class="control-label col-md-4">Title</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="title" class="form-control"
                                          placeholder="Title"/>
                                <sf:errors path="title" cssClass="error" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Kpac</label>
                            <div class="col-md-8">

                                <sf:select path="kpacId" class="form-control" >
                                    <sf:option value="">Select Kpac</sf:option>
                                    <sf:options items="${kpacs}" itemValue="id" itemLabel="title" ></sf:options>
                                </sf:select>

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
        <div class="col-md-offset-2 col-md-8">

            <table id="kpac_grid_table" class="dhtmlxGrid" width="100%" border="1" name="mygrid"  lightnavigation="true" onbeforeinit="initGrid()" oninit="postGridInit()">
                <tr>
                    <td width="25"  sort="int">Id</td>
                    <td sort="str">Title</td>
                    <td sort="na">Delete</td>
                </tr>

                <c:forEach items="${kpacSets}" var="kpacSet">
                    <tr>
                        <td>${kpacSet.id}</td>
                        <td>${kpacSet.title}</td>
                        <td><a href="/sets/delete/${kpacSet.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>

            </table>

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
    function postGridInit() {
            mygrid.attachEvent("onRowDblClicked", function(rId,cInd){
                var setId = mygrid.cells(rId, 0).getValue();
                var set_url = "/sets/set/" + setId;
                window.open(set_url,'_self');
            });
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
