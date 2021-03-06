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
    .ck-editor__editable {
        height: 200px !important;
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

                            <h4 class="m-t-0 header-title" style="text-align: center"><b>Post Management</b></h4>


                            <div  style="padding: 20px 20px 20px">
                                <table class="table table-bordered m-0">

                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th style="width: 300px">Title</th>
                                        <th style="width: 100px">Status</th>
                                        <th style="width: 100px">Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody id="posts">
<%--                                    <c:forEach items = "${posts}" var="post">--%>
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
                                <nav aria-label="Page navigation example" style="text-align: center; margin-bottom: 0;">
                                    <ul class="pagination">

                                    </ul>
                                </nav>
                            </div>
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


<script src="assets/plugins/morris/morris.min.js"></script>
<script src="assets/plugins/raphael/raphael-min.js"></script>

<script src="assets/plugins/jquery-knob/jquery.knob.js"></script>

<script src="assets/pages/jquery.dashboard.js"></script>

<script src="assets/js/jquery.core.js"></script>
<script src="assets/js/jquery.app.js"></script>

<script>

    $(function () {
        $.get("get-manage-post", function (data, status) {
            $('#posts').html(data.result);

            $('.pagination').html(data.pagination);
        })
    })

    function pagination(e, page) {
        e.preventDefault();
        $.ajax({
            url: "/get-manage-post",
            type: "GET",
            data: {
                "currentPage": page
            },
            success: function (returndata) {               //success is deprecated, use done
                $('#posts').html(returndata.result);
                $('.pagination').html(returndata.pagination);
            },
            error: function (jqXHR) {          //dump the info to the console (hit f12 to see that in a browser)
                console.log(jqXHR);
                alert("aw damn, something bad happened");
            }


        })
    }


    // $(".reset").click(function() {
    //     $(this).closest('form').find("input[type=text], textarea").val("");
    //     $(this).closest('form').find("input[type=password], textarea").val("");
    // });

</script>
<%--<script type="text/javascript">--%>
<%--    jQuery(document).ready(function($) {--%>
<%--        $('.counter').counterUp({--%>
<%--            delay: 100,--%>
<%--            time: 1200--%>
<%--        });--%>

<%--        $(".knob").knob();--%>

<%--    });--%>
<%--</script>--%>


</body>
</html>
