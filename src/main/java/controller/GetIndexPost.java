package controller;

import com.google.gson.Gson;
import model.dto.PostDTO;
import model.entity.Vote;
import service.PostService;
import service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/get-post")
public class GetIndexPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String search ="";
        int currentPage = 1;
        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        if (request.getParameter("search") != null)
            search += request.getParameter("search");

        PostService postService = new PostService();
        List<PostDTO> allPost = postService.getAllPosts("ACCEPTED", search);

        float itemPerPage = 5;
        int temp = (int) itemPerPage;
        int skipItems = (currentPage - 1) * (int) itemPerPage;
        int totalPage = (int) Math.ceil(allPost.size() / itemPerPage);
        List<PostDTO> posts = new ArrayList<>();
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
        for (PostDTO item : posts) {
            if (item.getStatus().equals("ACCEPTED")) {
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
                                "                                        <img src=\"" + item.getAvt() + "\" alt=\"img\"\n" +
                                "                                             class=\"img-circle thumb-lg m-r-15\"/>\n" +
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
                                "                                                    class=\"text-muted\">20/20/2020</span></p>\n" +
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
