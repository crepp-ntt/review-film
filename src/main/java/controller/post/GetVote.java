package controller.post;

import com.google.gson.Gson;
import model.entity.Vote;
import service.VoteService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/get-vote")
public class GetVote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        long postId = Long.parseLong(request.getParameter("postId"));
        String type = request.getParameter("type");
        String postTitle = request.getParameter("postTitle");
        String username = AppUtils.getLoginedUser(request.getSession()).getUsername();

        VoteService voteService = new VoteService();
        Vote checkVote = voteService.getCheckVote(postId, username);
        if(checkVote != null){
            if(!checkVote.getVote().equals(type))
                voteService.updateVote(checkVote);
        }
        else
            voteService.saveVote(username, type , postId, postTitle);

        data.put("success", "Vote");
        String res = new Gson().toJson(data);
        response.getWriter().write(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        long postId = Long.parseLong(request.getParameter("postId"));

        //get all vote of postId from database
        VoteService voteService = new VoteService();
        List<Vote> votes = voteService.getVoteByPostId(postId);

        int upVote = 0;
        int downVote = 0;
        Vote userVote = null;

        //count upVote, downVote from votes
        for (Vote vote : votes) {
            if (vote.getVote().equals("UP"))
                upVote++;
            else
                downVote++;
            if(AppUtils.getLoginedUser(request.getSession()) != null)
                if(vote.getUsername().equals(AppUtils.getLoginedUser(request.getSession()).getUsername()))
                    userVote = vote;
        }


        String result = "";
        result += "<div class=\"col-md-2\">\n" +
                "                                                    \n" +
                "                                                </div><label class=\"col-md-2 control-label\">Upvote</label>\n" +
                "                                                <div class=\"col-md-2\">\n" +
                "                                                    <span class=\"form-control\">"+ upVote+"</span>\n" +
                "                                                </div>\n" +
                "                                                <label class=\"col-md-2 control-label\">Downvote</label>\n" +
                "                                                <div class=\"col-md-2\">\n" +
                "                                                    <span class=\"form-control\">"+ downVote+ "</span>\n" +
                "                                                </div>";

        String voteBtn = "";
        if(userVote == null){
            voteBtn += "<div class=\"form-group text-center m-t-40\">\n" +
                    "                                                <div class=\"col-xs-2\">\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <a href=\"\"\n" +
                    "                                                       class=\"btn btn-primary btn-block text-uppercase waves-effect waves-light\" onclick=\"upVote(event)\">Up</a>\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <button class=\"btn btn-pink btn-block text-uppercase waves-effect waves-light\" onclick=\"downVote(event)\">\n" +
                    "                                                        Down\n" +
                    "                                                    </button>\n" +
                    "                                                </div>\n" +
                    "                                            </div>";
        }
        else if(userVote.getVote().equals("UP")){
            voteBtn += "<div class=\"form-group text-center m-t-40\">\n" +
                    "                                                <div class=\"col-xs-2\">\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <a href=\"\"\n" +
                    "                                                       class=\"btn btn-primary btn-block text-uppercase waves-effect waves-light\" disabled>Up</a>\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <button class=\"btn btn-pink btn-block text-uppercase waves-effect waves-light\" onclick=\"downVote(event)\">\n" +
                    "                                                        Down\n" +
                    "                                                    </button>\n" +
                    "                                                </div>\n" +
                    "                                            </div>";
        }else {
            voteBtn += "<div class=\"form-group text-center m-t-40\">\n" +
                    "                                                <div class=\"col-xs-2\">\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <a href=\"\"\n" +
                    "                                                       class=\"btn btn-primary btn-block text-uppercase waves-effect waves-light\" onclick=\"upVote(event)\">Up</a>\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"col-xs-5\">\n" +
                    "                                                    <button class=\"btn btn-pink btn-block text-uppercase waves-effect waves-light\" disabled>\n" +
                    "                                                        Down\n" +
                    "                                                    </button>\n" +
                    "                                                </div>\n" +
                    "                                            </div>";
        }
        data.put("result",result);
        data.put("voteBtn", voteBtn);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }
}
