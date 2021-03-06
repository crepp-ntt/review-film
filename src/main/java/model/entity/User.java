package model.entity;


public class User {

  private String username;
  private String password;
  private String name;
  private String email;
  private java.sql.Date dob;
  private String avt;
  private String phone;
  private long role;
  private String status;
  private int posts;
  private int upVotes;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public java.sql.Date getDob() {
    return dob;
  }

  public void setDob(java.sql.Date dob) {
    this.dob = dob;
  }


  public String getAvt() {
    return avt;
  }

  public void setAvt(String avt) {
    this.avt = avt;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getPosts() {
    return posts;
  }

  public void setPosts(int posts) {
    this.posts = posts;
  }

  public int getUpVotes() {
    return upVotes;
  }

  public void setUpVotes(int upVotes) {
    this.upVotes = upVotes;
  }
}
