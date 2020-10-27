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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

    $(function () {
        $("#datepicker").datepicker({
            uiLibrary: 'bootstrap4',
            format: 'yyyy-mm-dd'
        });
    });

</script>
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
                    <div class="col-sm-12">
                        <div class="card-box">

                            <div class="row">

                                <div class="col-md-12">

                                    <div class="form-horizontal change_profile">
                                        <div class="col-md-3 m-t-10">
                                            <div class="col-md-4"></div>

                                            <div class="col-md-6">
                                                <img id="blah" alt="your image" src="${manageUser.getAvt()}"
                                                     style="width: 200px; height: 200px; border-radius: 20px"/>

                                                <div class="col-xs-2">
                                                    <span id="result1"></span>
                                                </div>
                                            </div>


                                        </div>


                                        <div class="col-md-7">
                                            <div class="form-group">
                                                <div class="col-md-6"></div>
                                                <h4 class="m-t-0 header-title col-md-6"><b>Profile</b></h4>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Name</label>
                                                <div class="col-md-10">
                                                    <label type="text" class="form-control"
                                                           id="name">${manageUser.getName()}</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Email</label>
                                                <div class="col-md-10">
                                                    <label type="text" class="form-control"
                                                           id="email">${manageUser.getEmail()}</label>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-md-2 control-label">DoB</label>
                                                <div class="col-md-10">
                                                    <label class="form-control"
                                                    >${manageUser.getDob()}</label>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Phone</label>
                                                <div class="col-md-10">
                                                    <label type="text" class="form-control"
                                                           id="phone" >${manageUser.getPhone()}</label>
                                                </div>
                                            </div>


                                        </div>
                                        <div class="col-md-2">
                                            <div class="col-md-1"></div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <div class="col-md-3"></div>
                                                    <h4 class="m-t-0 header-title col-md-6"><b>Status</b></h4>
                                                </div>
                                                <div id="status">
                                                    <c:choose>
                                                        <c:when test="${manageUser.getStatus() =='Block'}">
                                                            <div class="form-group table-detail lable-detail">
                                                                <div class="col-md-3"></div>
                                                                <span class="label label-warning"
                                                                      style="font-size: 15px">BLOCKED</span>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="col-md-3"></div>
                                                                <h4 class="m-t-10 header-title col-md-6"><b>Action</b>
                                                                </h4>
                                                            </div>
                                                            <div class="form-group">
                                                                <button class="m-t-10 btn btn-primary btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Active" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Unblock
                                                                </button>

                                                            </div>
                                                            <div class="form-group">
                                                                <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Ban" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Ban
                                                                </button>

                                                            </div>
                                                        </c:when>
                                                        <c:when test="${manageUser.getStatus() =='Active'}">
                                                            <div class="form-group table-detail lable-detail">
                                                                <div class="col-md-3"></div>
                                                                <span class="label label-success"
                                                                      style="font-size: 15px">ACTIVED</span>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-md-3"></div>
                                                                <h4 class="m-t-10 header-title col-md-6"><b>Action</b>
                                                                </h4>
                                                            </div>
                                                            <div class="form-group">
                                                                <button class="m-t-10 btn btn-white btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Block" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Block
                                                                </button>

                                                            </div>
                                                            <div class="form-group">
                                                                <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Ban" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Ban
                                                                </button>

                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group table-detail lable-detail">
                                                                <div class="col-md-3"></div>
                                                                <span class="label label-danger"
                                                                      style="font-size: 15px">BANNED</span>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-md-3"></div>
                                                                <h4 class="m-t-10 header-title col-md-6"><b>Action</b>
                                                                </h4>
                                                            </div>
                                                            <div class="form-group">
                                                                <button class="m-t-10 btn btn-primary btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Active" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Unban
                                                                </button>

                                                            </div>
                                                            <div class="form-group">
                                                                <button class="btn btn-white btn-block text-uppercase waves-effect waves-light"
                                                                        data-type="Block" onclick="changeStatus(event, this.getAttribute('data-type'))">
                                                                    Block

                                                                </button>

                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>


                                            </div>


                                        </div>


                                    </div>
                                </div>


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
    function changeStatus(e, status){
        e.preventDefault();
        $.ajax({
            url: "/manage-user",
            type: "POST",
            data: {
                "username": "${manageUser.getUsername()}",
                "status" : status
            },
            success: function (response){
                $('#status').html(response.result);
            },
            err: function (){
                alert("error in ajax submission");
            }
        })
    }

    <%--$('#blah').attr('src', ${user.getAvt()}).width(200)--%>
    <%--    .height(200);--%>
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
