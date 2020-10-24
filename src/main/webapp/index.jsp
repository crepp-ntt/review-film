<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>

<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>

<body class="fixed-left">

<!-- Begin page -->
<div id="wrapper">

    <%@include file="includes/top_bar.jsp" %>


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
                    <% if (AppUtils.getLoginedUser(request.getSession()) != null) {%>
                    <div>
                        <a href="create_post" class="btn btn-primary text-uppercase waves-effect waves-light"
                           id="create_post">Create review
                        </a>
                    </div>
                    <% } %>


                    <div class="col-lg-7 card-box">
                        <div class="row">
                            <h4 class="m-t-0 header-title m-l-10"><b>List Review</b></h4>


                            <div class="col-sm-9">
                                <form role="form">
                                    <div class=" contact-search m-b-10 m-t-10">
                                        <input
                                                type="text"
                                                id="search"
                                                class="form-control"
                                                placeholder="Search"
                                                name="TENSP"
                                        />
                                        <button type="submit" class="btn btn-white m-b-10 m-t-10">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                    <!-- form-group -->
                                </form>
                            </div>
                            <div class="col-sm-3">
                                <form role="form">
                                    <div class="contact-search m-b-10 m-t-10">

                                        <input
                                                type="text"
                                                id="sort"
                                                class="form-control"
                                                placeholder="sort"
                                                name="TENSP"
                                        />
                                        <%--                                    <button type="submit" class="btn btn-white">--%>
                                        <%--                                        <i class="fa fa-search"></i>--%>
                                        <%--                                    </button>--%>
                                    </div>
                                    <!-- form-group -->
                                </form>
                            </div>

                        </div>
                        <div id="posts"></div>
                        <%--                        <c:forEach items="${posts}" var="item">--%>

                        <%--                            <c:url var="post_detail" value="post_detail">--%>
                        <%--                                <c:param name="id" value="${item.getId()}"/>--%>
                        <%--                            </c:url>--%>


                        <%--                            <div class="card-box m-b-8 post_detail" onclick="location.href='${post_detail}'">--%>

                        <%--                                <div class="table-box opport-box">--%>
                        <%--                                    <div class="table-detail" style="text-align: center">--%>
                        <%--                                        <img src="${item.getAvt()}" alt="img"--%>
                        <%--                                             class="img-circle thumb-lg m-r-15"/>--%>
                        <%--                                        <p class="text-dark m-t-10"><b>${item.getUsername()} </b></p>--%>
                        <%--                                    </div>--%>

                        <%--                                    <div class="table-detail">--%>
                        <%--                                        <div class="member-info">--%>
                        <%--                                            <h4 class="m-t-0" style="width: 250px"><b>${item.getTitle()}</b></h4>--%>
                        <%--                                            <p class="text-dark m-b-5"><b>#ID: </b> <span--%>
                        <%--                                                    class="text-muted">${item.getId()}</span>--%>
                        <%--                                            </p>--%>
                        <%--                                            <p class="text-dark m-b-5"><b>#Date: </b> <span--%>
                        <%--                                                    class="text-muted">20/20/2020</span></p>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>


                        <%--                                    <div class="table-detail">--%>
                        <%--                                        <div class="member-info">--%>
                        <%--                                            <h5 class="m-t-0"><b>Upvote </b></h5>--%>
                        <%--                                            <p class="text-dark m-b-5" style="width: 100px"><span--%>
                        <%--                                                    class="text-muted">10</span></p>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>

                        <%--                                    <div class="table-detail">--%>
                        <%--                                        <div class="member-info">--%>
                        <%--                                            <h5 class="m-t-0"><b>Downvote </b></h5>--%>
                        <%--                                            <p class="text-dark m-b-5" style="width: 100px"><span--%>
                        <%--                                                    class="text-muted">10</span></p>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>


                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </c:forEach>--%>
                        <nav aria-label="Page navigation example" style="text-align: center">
                            <ul class="pagination">

                            </ul>
                        </nav>

                    </div> <!-- end col -->

                    <div class="row">

                        <div class="col-lg-5">
                            <div class="card-box">
                                <h4 class="text-dark header-title m-t-0 m-b-20">TOP REVIEWERS</h4>

                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                            </div>

                            <div class="card-box">
                                <h4 class="text-dark header-title m-t-0 m-b-30">TOP POSTS</h4>

                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                                <div class="card-box m-b-5">
                                    <div class="table-box opport-box">
                                        <div class="table-detail">
                                            <img src="assets/images/brand/envato.jpg" alt="img"
                                                 class="img-circle thumb-lg m-r-10"/>
                                        </div>

                                        <div class="table-detail">
                                            <div class="member-info">
                                                <h4 class="m-t-0"><b>Envato Market Pty Ltd. </b></h4>
                                                <p class="text-dark m-b-5"><b>Category: </b> <span class="text-muted">Branch manager</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="table-detail lable-detail">
                                            <span class="label label-info">Hot</span>
                                        </div>


                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>
                    <!-- end row -->


                    <!-- end col -->


                </div>
                <!-- end row -->


            </div> <!-- container -->

        </div> <!-- content -->


    </div>


    <!-- ============================================================== -->
    <!-- End Right content here -->
    <!-- ============================================================== -->


</div>
<!-- END wrapper -->


<script>
    let resizefunc = [];
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

<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('.counter').counterUp({
            delay: 100,
            time: 1200
        });

        $(".knob").knob();

    });


    $(function () {
        $.get("get-posts", function (data, status) {
            $('#posts').html(data.result);

            $('.pagination').html(data.pagination);
        })
    })

    function pagination(e, page) {
        e.preventDefault();
        $.ajax({
            url: "/get-posts",
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

    // $('.page-item').click( (e)=>{
    //     alert(e);
    //
    // })

    // $('a').click(function(event) {
    //     event.preventDefault();
    //     $.ajax({
    //         url: $(this).attr('href'),
    //         success: function(response) {
    //             alert(response);
    //         }
    //     });
    //     return false; // for good measure
    // });


</script>


</body>
</html>
