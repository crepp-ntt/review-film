package service;

import model.dao.iVoteDao;
import model.dao.impl.VoteDao;
import model.entity.Vote;

import java.util.ArrayList;
import java.util.List;

public class VoteService {
    iVoteDao dao = new VoteDao();

    public int deleteByIdArray(String[] idArr){
        List<Long> longArray = new ArrayList<>();
        for(String item: idArr) {
            longArray.add(Long.parseLong(item));
        }
        return dao.deleteByIdArray(longArray);
    }

    public List<Vote> getVoteByPostId(long postId){
        return dao.findByPostId(postId);
    }

    public List<Vote> getVoteByUsername(String username){
        return dao.findByUsername(username);
    }

    public Vote getCheckVote(long postId, String username){
        return dao.findCheckVote(postId, username);
    }

    public int updateVote(Vote vote){
        return dao.update(vote);
    }

    public void saveVote(String username, String type, long postId, String title) {
        Vote vote = new Vote(username, type, postId, title);
        dao.insert(vote);
    }
}
