package model.entity;


public class Comment {

  private long id;
  private String username;
  private String userAvt;
  private long postId;
  private String content;

  public Comment(String username, String userAvt, long postId, String content) {
    this.username = username;
    this.userAvt = userAvt;
    this.postId = postId;
    this.content = content;
  }

  public Comment() {
  }

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


  public String getUserAvt() {
    return userAvt;
  }

  public void setUserAvt(String userAvt) {
    this.userAvt = userAvt;
  }


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
