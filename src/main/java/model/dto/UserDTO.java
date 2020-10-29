package model.dto;

import java.sql.Date;

public class UserDTO {
    private String username;
    private String name;
    private String email;
    private java.sql.Date dob;
    private String avt;
    private String status;
    private String phone;
    private int posts;
    private int upVotes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
//    public void setDob(String dob) {
//        java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
//        try {
//            java.util.Date da = format.parse(dob);
//            java.sql.Date sqlDate = new java.sql.Date(da.getTime());
//            this.dob = sqlDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

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
