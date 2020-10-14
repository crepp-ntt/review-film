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
<%@include file="includes/header.jsp"%>
</head>

<style>
    .ck-editor__editable {
        height: 200px !important;
    }
</style>
<body class="fixed-left">

<!-- Begin page -->
<div id="wrapper">

    <%@include file="/includes/top_bar.jsp"%>


    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div >
        <!-- Start content -->
        <div class="content">
            <div class="container">

                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="btn-group pull-right m-t-15">
                            <button type="button" class="btn btn-default dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false">Settings <span class="m-l-5"><i class="fa fa-cog"></i></span></button>
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
<%--                            <h4 class="m-t-0 header-title"><b>Profile</b></h4>--%>

                            <div class="row">

                                <div class="col-md-12">

                                    <div  class="form-horizontal" >
                                        <div class="col-md-2 m-t-10">
                                            <div class="col-md-1"></div>

                                            <div class="col-md-6">
                                                <img id="blah" src="assets/images/users/avatar.jpg" alt="your image" style="width: 150px; height: 150px"/>
                                                <label class="form-control">User</label>
                                            </div>
                                        </div>


                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="col-md-6"></div>
                                                <h4 class="m-t-0 header-title col-md-6" ><b>Title</b></h4>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Film</label>
                                                <div class="col-md-10">
                                                    <span type="text" class="form-control" >The boys</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 control-label" >Rate</label>
                                                <div class="col-md-10">
                                                    <span class="form-control"  >8/10</span>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Review</label>
                                                <div class="col-md-10">
                                                    <span class="form-control" style="height: 250px">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam asperiores cum, eaque hic iure magnam molestias officia placeat quidem repellendus. Aspernatur consectetur delectus
                                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam asperiores cum, eaque hic iure magnam molestias officia placeat quidem repellendus. Aspernatur consectetur delectus dolorem enim explicabodolorem enim explicabo necessitatibus optio quaerat voluptatibus.</span>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-2 control-label" >Upvote</label>
                                                <div class="col-md-2">
                                                    <span class="form-control" >10</span>
                                                </div>
                                                <label class="col-md-2 control-label" >Downvote</label>
                                                <div class="col-md-2">
                                                    <span class="form-control" >0</span>
                                                </div>
                                            </div>



                                            <div class="form-group text-center m-t-40">
                                                <div class="col-xs-2">
                                                </div>
                                                <div class="col-xs-5">
                                                    <a href="" class="btn btn-primary btn-block text-uppercase waves-effect waves-light reset" >Up</a>
                                                </div>
                                                <div class="col-xs-5">
                                                    <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light" >Down</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="col-md-1"></div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <div class="col-md-4"></div>
                                                    <h4 class="m-t-0 header-title col-md-6" ><b>Comment</b></h4>
                                                </div>

                                                <form>
                                                    <div class="form-group">
                                                        <div class="col-md-10">
                                                            <input class="form-control"  placeholder="Insert your comment"/>
                                                        </div>
                                                        <button class="col-md-2 btn btn-primary text-uppercase waves-effect waves-light" type="submit">Send</button>
                                                    </div>
                                                </form>

                                                <div class="form-group card-box">
                                                    <div class="col-md-3">
                                                        <img  src="assets/images/users/avatar.jpg" alt="your image" style="width: 75px; height: 75px"/>

                                                    </div>
                                                    <div class="col-md-9">
                                                        <div class="col-md-2"></div>
                                                        <div class="col-md-12">
                                                            <label class="" >User:</label>
                                                            <span>This movie iz gud phim hay thiet</span>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group card-box">
                                                    <div class="col-md-3">
                                                        <img  src="assets/images/users/avatar.jpg" alt="your image" style="width: 75px; height: 75px"/>

                                                    </div>
                                                    <div class="col-md-9">
                                                        <div class="col-md-2"></div>
                                                        <div class="col-md-12">
                                                            <label class="" >User:</label>
                                                            <span>Cong nhan</span>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group card-box">
                                                    <div class="col-md-3">
                                                        <img  src="assets/images/users/avatar.jpg" alt="your image" style="width: 75px; height: 75px"/>

                                                    </div>
                                                    <div class="col-md-9">
                                                        <div class="col-md-2"></div>
                                                        <div class="col-md-12">
                                                            <label class="" >User:</label>
                                                            <span>Cong nhan</span>
                                                        </div>
                                                    </div>
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
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

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
