<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>

<style>
    .selected {
        color: #0a6aa1;
    }
</style>
<body class="fixed-left">

<!-- Begin page -->
<div id="wrapper">

    <%@include file="/includes/top_bar.jsp" %>


    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div>
        <!-- Start content -->
        <div class="content">
            <div class="container">

                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="btn-group pull-right m-t-15">
                            <button type="button" class="btn btn-default dropdown-toggle waves-effect waves-light"
                                    data-toggle="dropdown" aria-expanded="false">Settings <span class="m-l-5"><i
                                    class="fa fa-cog"></i></span></button>
                            <ul class="dropdown-menu drop-menu-right" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>

                        <h4 class="page-title">Dashboard</h4>
                        <p class="text-muted page-title-alt">Welcome to Ubold admin panel !</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">
                        <div class="card-box">

                            <button class="header-title selected" style="text-align: center" id="post"><b>Post</b>
                            </button>
                            <button class="header-title" style="text-align: center" id="activity"><b>Activity</b>
                            </button>


                            <div style="padding: 20px 20px 20px">
                                <button class="header-title" style="text-align: center;" id="delete" disabled>
                                    <b>Delete</b>
                                </button>
                                <table class="table table-bordered m-0">

                                    <thead>
                                    <tr>
                                        <th><input id="select_all" value="1" type="checkbox"></th>
                                        <th>ID</th>
                                        <th style="width: 300px">Title</th>
                                        <th style="width: 100px">Status</th>
                                        <th style="width: 100px">Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody id="posts">
                                    <%--                                    <c:forEach items="${posts}" var="post">--%>
                                    <%--                                        <tr>--%>
                                    <%--                                            <th scope="row">${post.getId()}</th>--%>
                                    <%--                                            <td>${post.getTitle()}</td>--%>
                                    <%--                                            <td>${post.getStatus()}</td>--%>
                                    <%--                                            <td><a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>--%>
                                    <%--                                            </td>--%>
                                    <%--                                        </tr>--%>
                                    <%--                                    </c:forEach>--%>

                                    </tbody>
                                </table>

                            </div>
                            <nav aria-label="Page navigation example" style="text-align: center; margin-bottom: 0;">
                                <ul class="pagination">

                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>


            </div> <!-- container -->

        </div> <!-- content -->


    </div>


    <!-- ============================================================== -->
    <!-- End Right content here -->
    <!-- ============================================================== -->


</div>
<!-- END wrapper -->


<script>
    var resizefunc = [];
</script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- jQuery  -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>

<script src="assets/js/jquery.slimscroll.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/waves.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>

<script src="assets/plugins/peity/jquery.peity.min.js"></script>

<!-- jQuery  -->
<script src="assets/plugins/waypoints/lib/jquery.waypoints.js"></script>
<script src="assets/plugins/counterup/jquery.counterup.min.js"></script>


<%--<script src="assets/plugins/morris/morris.min.js"></script>--%>
<script src="assets/plugins/raphael/raphael-min.js"></script>

<script src="assets/plugins/jquery-knob/jquery.knob.js"></script>

<%--<script src="assets/pages/jquery.dashboard.js"></script>--%>

<script src="assets/js/jquery.core.js"></script>
<script src="assets/js/jquery.app.js"></script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>

<script>

</script>

<script>
    let type = "post";
    $(function () {
        $.get("get-activity", {type: "post", page: 1}, function (data, status) {
            $('#posts').html(data.result);
            $('.pagination').html(data.pagination);
        })
    })

    function reload() {
        $.get("get-activity", {type: "post", page: 1}, function (data, status) {
            $('#posts').html(data.result);
            $('.pagination').html(data.pagination);
        })
    }

    $("#activity").on('click', function (e) {
        e.preventDefault();
        type = "activity";
        $(this).attr("class", "header-title selected");
        document.getElementById("post").setAttribute("class", "header-title");
        $.get("get-activity", {type: "activity", page: 1}, function (data, status) {
            $('#posts').html(data.result);
            $('.pagination').html(data.pagination);
        })
    })

    $("#post").on('click', function (e) {
        e.preventDefault();
        type = "post";
        $(this).attr("class", "header-title selected");
        document.getElementById("activity").setAttribute("class", "header-title");
        $.get("get-activity", {type: "post", page: 1}, function (data, status) {
            $('#posts').html(data.result);
            $('.pagination').html(data.pagination);
        })
    })

    function pagination(e, page) {
        e.preventDefault();
        $.ajax({
            url: "/get-activity",
            type: "GET",
            data: {
                "page": page,
                "type": "post"
            },
            success: function (data) {
                document.getElementById('delete').disabled = true;
                document.getElementById('select_all').checked = false;
                $('#posts').html(data.result);
                $('.pagination').html(data.pagination);
            },
            error: function () {
                alert("aw damn, something bad happened");
            }
        })
    }

    $('#select_all').on('click', function () {
        let baseCheck = document.getElementById('select_all').checked;
        let items = document.getElementsByName('select_all');
        items.forEach((item) => {
            item.checked = baseCheck;
        })
        document.getElementById('delete').disabled = !baseCheck;

    })

    function check (e) {
        let checkAll = 0;
        let checkDelete = 0;
        let items = document.getElementsByName('select_all');
        items.forEach((item) => {
            if (item.checked === false)
                checkAll += 1;
            else
                checkDelete += 1;
        })
        if (checkAll !== 0)
            document.getElementById('select_all').checked = false;
        document.getElementById('delete').disabled = checkDelete === 0;
    }

    $('#delete').on('click', function (e){
        e.preventDefault();

        let data = [];
        let items = document.getElementsByName('select_all');
        items.forEach((item) => {
            if(item.checked)
                data.push(item.value);
        })
        $.ajax({
            url:"/get-activity",
            type: "POST",
            dataType: 'JSON',
            data:{
                "data": data,
                "type": type,
            },
            success: function (response){
                document.getElementById('select_all').checked = false;
                document.getElementById('delete').disabled = true;
                if(type === "post")
                    $.get("get-activity", {type: "post", page: 1}, function (data, status) {
                        $('#posts').html(data.result);
                        $('.pagination').html(data.pagination);
                    })
                else
                    $.get("get-activity", {type: "activity", page: 1}, function (data, status) {
                        $('#posts').html(data.result);
                        $('.pagination').html(data.pagination);
                    })

            },
            err: function (){
                alert("aw damn, something bad happened");
            }
        })
    })

</script>


</body>
</html>
