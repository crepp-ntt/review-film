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
                    <div class="col-sm-12">
                        <div class="card-box">

                            <div class="row">

                                <div class="col-md-12">

                                    <div class="form-horizontal change_profile">
                                        <div class="col-md-3 m-t-10">
                                            <div class="col-md-4"></div>

                                            <div class="col-md-6">
                                                <img id="blah" src="assets/images/users/avatar.jpg" alt="your image"
                                                     style="width: 200px; height: 200px; border-radius: 20px" />
                                                <input type='file' id="imgInp" name="img"/>
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
                                                    <input type="text" class="form-control" required placeholder="Name"
                                                           id="name" value="${user.getName()}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Email</label>
                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" required placeholder="Email"
                                                           id="email" value="${user.getEmail()}">
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-md-2 control-label">DoB</label>
                                                <div class="col-md-10">
                                                    <input placeholder="mm/dd/yyyy" class="form-control" id="datepicker"
                                                           required name="dob" value="${user.getDob()}">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-2 control-label">Phone</label>
                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" required placeholder="Phone"
                                                           id="phone" value="${user.getPhone()}">
                                                </div>
                                            </div>


                                            <div class="form-group text-center m-t-40">
                                                <div class="col-xs-2">
                                                </div>
                                                <div class="col-xs-5">
                                                    <a href=""
                                                       class="btn btn-primary btn-block text-uppercase waves-effect waves-light reset">Reset</a>
                                                </div>
                                                <div class="col-xs-5">
                                                    <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light"
                                                             id="submit">Save
                                                    </button>
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

    $('#datepicker').datepicker({
        uiLibrary: 'bootstrap4'
    });
</script>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            let reader = new FileReader();

            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result).width(200)
                    .height(200);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }


    $("#imgInp").change(function () {
        readURL(this);
    });
    $("#submit").on("click", function (e) {
        e.preventDefault();
        let data = {
            img: $("#blah").attr("src"),
            name: $("#name").val(),
            email: $("#email").val(),
            dob: $("#datepicker").val(),
            phone: $("#phone").val()
        }
        alert(JSON.stringify(data));
        $.ajax({
            url: "/change_profile",
            type: "POST",
            dataType: 'JSON',
            data:{
                alo: 1,
                test: JSON.stringify(data),
            },
            success: function (resutl) {
                //
            },
            error: function () {
                alert("error in ajax submission");
            }
        });
        return false;
    })
</script>

<script>


    $(".reset").click(function () {
        $(".change_profile").form().reset();
    });

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
