<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<body>

<div class="account-pages"></div>
<div class="clearfix"></div>
<div class="wrapper-page">
    <div class=" card-box">
        <div class="panel-heading">

            <h3 class="text-center"> Sign In to <strong class="text-custom">Review</strong> </h3>
        </div>


        <div class="panel-body">
            <form class="form-horizontal m-t-20" action="/login">



                <div class="form-group ">
                    <div class="col-xs-12">
                        <input class="form-control" type="text" required="true" placeholder="Username" name="username">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control" type="password" required="true" placeholder="Password" name="password">
                    </div>
                </div>



                <div class="form-group text-center m-t-40">
                    <div class="col-xs-12">
                        <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light" type="submit">Log In</button>
                    </div>
                </div>




            </form>

            <div class="form-group text-center m-t-40">
                <div class="col-xs-12">
                    <button class="btn btn-red btn-block text-uppercase waves-effect waves-light" type="submit">Back to Review</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12 text-center">
            <p>Don't have an account? <a href="signup" class="text-primary m-l-5"><b>Sign Up</b></a></p>

        </div>
    </div>

</div>




<script>
    var resizefunc = [];
</script>

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


<script src="assets/js/jquery.core.js"></script>
<script src="assets/js/jquery.app.js"></script>

</body>
</html>
