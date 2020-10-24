package service;

import model.dao.iVoteDao;
import model.dao.impl.VoteDao;
import model.entity.Vote;

import java.util.List;

public class VoteService {
    iVoteDao dao = new VoteDao();
    public List<Vote> getVoteByPostId(long postId){
        return dao.findByPostId(postId);
    }
}
