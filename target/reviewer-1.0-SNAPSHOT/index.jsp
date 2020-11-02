<%--
  Created by IntelliJ IDEA.
  User: crepp
  Date: 07/10/2020
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    <% if (AppUtils.getLoginedUser(request.getSession()) != null && !AppUtils.getLoginedUser(request.getSession()).getStatus().equals("Block")) {%>

                    <div>
                        <a href="create-post" class="btn btn-primary text-uppercase waves-effect waves-light"
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
                                                onkeypress="return event.keyCode != 13;"

                                        />

                                    </div>
                                    <!-- form-group -->
                                </form>
                            </div>
                            <div class="col-sm-3">
                                <form role="form">
                                    <div class="contact-search m-b-10 m-t-10">


                                        <select id="sort"  class="form-control">
                                            <option value="dateIncrease">Newest</option>
                                            <option value="dateDecrease">Oldest</option>

                                        </select>

                                    </div>
                                    <!-- form-group -->
                                </form>
                            </div>

                        </div>
                        <div id="posts"></div>

                        <nav aria-label="Page navigation example" style="text-align: center">
                            <ul class="pagination">

                            </ul>
                        </nav>

                    </div> <!-- end col -->

                    <div class="row">

                        <div class="col-lg-4">
                            <div class="card-box">
                                <h4 class="text-dark header-title m-t-0 m-b-20">TOP REVIEWERS</h4>
                                <c:forEach items = "${topUsers}" var="item">
                                    <div class="card-box m-b-5">
                                        <div class="table-box opport-box">
                                            <div class="table-detail">
                                                <img src="${item.getAvt()}" alt="img"
                                                     class="img-circle thumb-lg m-r-10"/>


                                            </div>

                                            <div class="table-detail">
                                                <div class="member-info" style="text-align: left">
                                                    <h5 class="m-t-0"><b>${item.getUsername()} </b></h5>

                                                </div>
                                            </div>

                                            <div class="table-detail">
                                                <div class="member-info">
                                                    <span class="label label-info">Posts: ${item.getPosts()}</span>

                                                </div>
                                                <div class="member-info">
                                                    <span class="label label-success">Votes: ${item.getUpVotes()}</span>

                                                </div>

                                            </div>




                                        </div>
                                    </div>
                                </c:forEach>



                            <div class="card-box">
                                <h4 class="text-dark header-title m-t-0 m-b-30">TOP POSTS</h4>
                                <c:forEach items = "${topPosts}" var="item">
                                    <div class="card-box m-b-5">
                                        <div class="">
                                            <div class="table-detail">
                                                #ID: ${item.getId()}
                                            </div>

                                            <div class="table-detail">

                                                <div class="member-info">Title: ${item.getTitle()}</div>
                                            </div>

                                            <div class="table-detail" style="text-align: center">
                                                <span class="label label-success">Upvote: ${item.getUpVotes()}</span>
                                            </div>

                                        </div>
                                    </div>
                                </c:forEach>



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
        $.get("get-post",{"search": $('#search').val(),"sort": $('#sort').val()}, function (data, status) {
            $('#posts').html(data.result);

            $('.pagination').html(data.pagination);
        })
    })

    $('#sort').change(function (e){
        e.preventDefault();
        $.ajax({
            url: "/get-post",
            type: "GET",
            data: {
                "currentPage": 1,
                "search": $('#search').val(),
                "sort": this.value,
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
    })

    function pagination(e, page) {
        e.preventDefault();
        $.ajax({
            url: "/get-post",
            type: "GET",
            data: {
                "currentPage": page,
                "search": $('#search').val(),
                "sort": $('#sort').val(),
            },
            success: function (returnData) {               //success is deprecated, use done
                $('#posts').html(returnData.result);
                $('.pagination').html(returnData.pagination);
            },
            error: function (jqXHR) {          //dump the info to the console (hit f12 to see that in a browser)
                console.log(jqXHR);
                alert("aw damn, something bad happened");
            }


        })
    }


    $('#search').keyup(delay(function (e){
        e.preventDefault();
        $.ajax({
            url: "/get-post",
            type: "GET",
            data: {
                "currentPage": 1,
                "search": this.value,
                "sort": $('#sort').val(),
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
    }, 800))

    function delay(callback, ms) {
        let timer = 0;
        return function() {
            let context = this, args = arguments;
            clearTimeout(timer);
            timer = setTimeout(function () {
                callback.apply(context, args);
            }, ms || 0);
        };
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
