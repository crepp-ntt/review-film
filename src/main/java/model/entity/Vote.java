package model.entity;


public class Vote {

  private long id;
  private String username;
  private long postId;
  private String vote;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public String getVote() {
    return vote;
  }

  public void setVote(String vote) {
    this.vote = vote;
  }

}
