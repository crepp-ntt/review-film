package controller.post;

import com.google.gson.Gson;
import model.dto.PostDTO;
import model.entity.Post;
import model.entity.Vote;
import service.PostService;
import service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/get-post")
public class GetIndexPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String search = request.getParameter("search") != null ? request.getParameter("search"): "";
        String sort = request.getParameter("sort") != null ? request.getParameter("sort"): "";

        int currentPage = request.getParameter("currentPage") != null ? Integer.parseInt(request.getParameter("currentPage")): 1;



        PostService postService = new PostService();
        List<Post> allPost = postService.getAllPosts("ACCEPTED", search);

        if(sort.equals("dateIncrease")){
            Collections.reverse(allPost);
        }

        float itemPerPage = 5;
        int temp = (int) itemPerPage;
        int skipItems = (currentPage - 1) * (int) itemPerPage;
        int totalPage = (int) Math.ceil(allPost.size() / itemPerPage);
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < allPost.size(); i++) {
            if (i < skipItems)
                continue;
            if (temp == 0)
                break;
            posts.add(allPost.get(i));
            temp--;
        }

        String result = "";
        VoteService voteService = new VoteService();
        for (Post item : posts) {
            if (item.getCurrentStatus().equals("ACCEPTED")) {
                List<Vote> votes = voteService.getVoteByPostId(item.getId());

                int upVote = 0;
                int downVote = 0;

                //count upVote, downVote from votes
                for (Vote vote : votes) {
                    if (vote.getVote().equals("UP"))
                        upVote++;
                    else
                        downVote++;
                }
                result +=
                        "                            <div class=\"card-box m-b-8\" onclick=\"location.href='/post-detail?id=" + item.getId() + "'\">\n" +
                                "\n" +
                                "                                <div class=\"table-box opport-box\">\n" +
                                "                                    <div class=\"table-detail\" style=\"text-align: center\">\n" +
                                "                                        <img src=\"" + item.getUserAvt() + "\" alt=\"img\"\n" +
                                "                                             class=\"img-circle thumb-lg \"/>\n" +
                                "                                        <p class=\"text-dark m-t-10\"><b>" + item.getUsername() + " </b></p>\n" +
                                "                                    </div>\n" +
                                "\n" +
                                "                                    <div class=\"table-detail\">\n" +
                                "                                        <div class=\"member-info\">\n" +
                                "                                            <h4 class=\"m-t-0\" style=\"width: 250px\"><b>" + item.getTitle() + "</b></h4>\n" +
                                "                                            <p class=\"text-dark m-b-5\"><b>#ID: </b> <span\n" +
                                "                                                    class=\"text-muted\">" + item.getId() + "</span>\n" +
                                "                                            </p>\n" +
                                "                                            <p class=\"text-dark m-b-5\"><b>#Date: </b> <span\n" +
                                "                                                    class=\"text-muted\">"+ item.getDate() +"</span></p>\n" +
                                "                                        </div>\n" +
                                "                                    </div>\n" +
                                "\n" +
                                "\n" +
                                "                                    <div class=\"table-detail\">\n" +
                                "                                        <div class=\"member-info\">\n" +
                                "                                            <h5 class=\"m-t-0\"><b>Upvote </b></h5>\n" +
                                "                                            <p class=\"text-dark m-b-5\" style=\"width: 100px\"><span\n" +
                                "                                                    class=\"text-muted\">" + upVote + "</span></p>\n" +
                                "                                        </div>\n" +
                                "                                    </div>\n" +
                                "\n" +
                                "                                    <div class=\"table-detail\">\n" +
                                "                                        <div class=\"member-info\">\n" +
                                "                                            <h5 class=\"m-t-0\"><b>Downvote </b></h5>\n" +
                                "                                            <p class=\"text-dark m-b-5\" style=\"width: 100px\"><span\n" +
                                "                                                    class=\"text-muted\">" + downVote + "</span></p>\n" +
                                "                                        </div>\n" +
                                "                                    </div>\n" +
                                "\n" +
                                "\n" +
                                "                                </div>\n" +
                                "                            </div>";
            }


        }

        String pagination = "";
        if (currentPage != 1)
            pagination += "<li class=\"page-item\" data-page=\"" + (currentPage - 1) + "\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">Previous</a></li>\n";
        if (currentPage > 1)
            pagination += "<li class=\"page-item\" data-page=\"" + (currentPage - 1) + "\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\" >" + (currentPage - 1) + "</a></li>\n";
        pagination += "<li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0)\" tabindex=\"-1\">" + currentPage + "</a></li>\n";
        if (currentPage < totalPage)
            pagination += "<li class=\"page-item\" data-page=\"" + (currentPage + 1) + "\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">" + (currentPage + 1) + "</a></li>\n";

        if (currentPage < totalPage)
            pagination += "<li class=\"page-item\" data-page=\"" + (currentPage + 1) + "\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">Next</a></li>\n";

        data.put("result", result);
        data.put("pagination", pagination);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }
}
