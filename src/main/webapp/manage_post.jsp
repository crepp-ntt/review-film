<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>

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

                            <h4 class="m-t-0 header-title" style="text-align: center"><b>User Management</b></h4>


                            <div  style="padding: 20px 20px 20px">
                                <table class="table table-bordered m-0">

                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th style="width: 300px">Name</th>
                                        <th style="width: 100px">Status</th>
                                        <th style="width: 100px">Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td><a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td><a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td><a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
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
