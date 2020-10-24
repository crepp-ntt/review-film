package controller;

import com.google.gson.Gson;
import model.entity.Vote;
import service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/get-votes")
public class get_vote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        //count upVote, downVote from votes
        for (Vote vote : votes) {
            if (vote.getVote().equals("UP"))
                upVote++;
            else
                downVote++;
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
        data.put("result",result);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }
}
