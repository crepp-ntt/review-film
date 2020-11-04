package controller.user;

import com.google.gson.Gson;
import model.entity.Post;
import model.entity.Vote;
import service.PostService;
import service.VoteService;
import util.AppUtils;

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

@WebServlet("/get-activity")
public class GetActivity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        String[] idArr = request.getParameterValues("data[]");
        if(type.equals("post")) {
            PostService postService = new PostService();
            postService.deleteByIdArray(idArr);
        }else if(type.equals("activity")){
            VoteService voteService = new VoteService();
            voteService.deleteByIdArray(idArr);
        }

        data.put("success", "gud");
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        int currentPage = 1;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(request.getParameter("page"));

        float itemPerPage = 10;
        int temp = (int) itemPerPage;
        int skipItems = (currentPage - 1) * (int) itemPerPage;
        String result = "";
        int totalPage;

        if (type.equals("post")) {
            PostService postService = new PostService();
            List<Post> allPosts = postService.getPostByUsername(AppUtils.getLoginedUser(request.getSession()).getUsername());


            totalPage = (int) Math.ceil(allPosts.size() / itemPerPage);

            List<Post> posts = new ArrayList<>();
            for (int i = 0; i < allPosts.size(); i++) {
                if (i < skipItems)
                    continue;
                if (temp == 0)
                    break;
                posts.add(allPosts.get(i));
                temp--;
            }
            for (Post item : posts) {
                String status ="";
                if(item.getCurrentStatus().equals("PENDING"))
                    status +="                                            <td style=\"color: yellow\">" + item.getCurrentStatus() + "</td>\n";
                else if(item.getCurrentStatus().equals("ACCEPTED"))
                    status +="                                            <td style=\"color: green\">" + item.getCurrentStatus() + "</td>\n";
                else
                    status +="                                            <td style=\"color: red\">" + item.getCurrentStatus() + "</td>\n";



                result += "<tr>\n" +
                        "                                            <td> <input name=\"select_all\" value=" + item.getId() + " type=\"checkbox\" onclick=\"check(event)\"></td>\n" +
                        "                                            <td scope=\"row\">" + item.getId() + "</td>\n" +

                        "                                            <td>" + item.getTitle() + "</td>\n" +
                        status +
                        "                                            <td><a href=\"/edit-post?postId=" + item.getId() + "\" class=\"on-default edit-row\"><i class=\"fa fa-pencil\"></i></a>\n" +
                        "                                            </td>\n" +
                        "                                        </tr>";
            }
        } else {
            VoteService voteService = new VoteService();
            List<Vote> allVotes = voteService.getVoteByUsername(AppUtils.getLoginedUser(request.getSession()).getUsername());


            totalPage = (int) Math.ceil(allVotes.size() / itemPerPage);

            List<Vote> votes = new ArrayList<>();
            for (int i = 0; i < allVotes.size(); i++) {
                if (i < skipItems)
                    continue;
                if (temp == 0)
                    break;
                votes.add(allVotes.get(i));
                temp--;
            }
            for (Vote item : votes) {

                result += "<tr>\n" +
                        "                                            <td> <input name=\"select_all\" value=" + item.getId() + " type=\"checkbox\" onclick=\"check(event)\"></td>\n" +
                        "                                            <td scope=\"row\">" + item.getId() + "</td>\n" +
                        "                                            <td>" + item.getPostTitle() + "</td>\n" +
                        "                                            <td>" + item.getVote() + "</td>\n" +
                        "                                            <td><a href=\"/post-detail?id=" + item.getPostId() + "\" class=\"on-default edit-row\"><i class=\"fa fa-pencil\"></i></a>\n" +
                        "                                            </td>\n" +
                        "                                        </tr>";
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
