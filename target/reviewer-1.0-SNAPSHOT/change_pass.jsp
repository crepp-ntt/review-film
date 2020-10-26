<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes/header.jsp" %>
<body>

<div class="account-pages"></div>
<div class="clearfix"></div>
<div class="wrapper-page">
    <div class=" card-box">
        <div class="panel-heading">

            <h3 class="text-center"> Change password</h3>
        </div>


        <div class="panel-body">
            <div class="form-horizontal m-t-20">


                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control" type="password" required="required" placeholder="Old Password"
                               id="pass"
                               name="password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control" type="password" required placeholder="New Password" name="password"
                               id="pass1">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control" type="password" required placeholder="Confirm Password" id="pass2"
                               name="password">
                    </div>
                </div>


                <div class="form-group text-center m-t-40 ">
                    <div class="col-xs-6">
                        <a href=""
                           class="btn btn-primary btn-block text-uppercase waves-effect waves-light " id="reset">Reset</a>
                    </div>
                    <div class="col-xs-6">
                        <button class="btn btn-pink btn-block text-uppercase waves-effect waves-light" id="change">
                            Change
                        </button>
                    </div>
                </div>

            </div>

            <div class="form-group text-center m-t-40">
                <div class="col-xs-12">
                    <span id="result1"></span>

                    <button class="btn btn-red btn-block text-uppercase waves-effect waves-light" id="back">Back to Review
                    </button>
                </div>
            </div>
        </div>
    </div>


</div>


<script>
    var resizefunc = [];
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


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

<script>

    $("#reset").click(function () {
        $("#pass").val("");
        $("#pass1").val("");
        $("#pass2").val("");

    });

    $('#change').on('click', function (e){
        e.preventDefault();
        $.ajax({
            url: "/change-password",
            type: "POST",
            data:{
                oldPass: $('#pass').val(),
                newPass: $('#pass1').val(),
                confirm: $('#pass2').val()
            },
            success: function (returndata){
                if(returndata.success){
                    $('#result1').html(returndata.success);
                }
                else{
                    document.getElementById("reset").click();
                    $('#result1').html(returndata.false);
                }

            },
            err: function (){
                alert("False");
            }
        })
    });

    $('#back').on('click', function (e){
        e.preventDefault();
        window.location.href="/";
    })

</script>
</body>
</html>

