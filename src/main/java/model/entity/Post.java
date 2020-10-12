package model.entity;


public class Post {

  private long id;
  private String username;
  private String userAvt;
  private String title;
  private long rate;
  private String content;
  private String currentStatus;
  private java.sql.Date date;


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


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public long getRate() {
    return rate;
  }

  public void setRate(long rate) {
    this.rate = rate;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(String currentStatus) {
    this.currentStatus = currentStatus;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

}
