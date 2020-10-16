package model.dto;

public class PostDTO {
    private long id;
    private String username;
    private String avt;
    private String title;
    private String filmName;
    private String content;
    private String status;
    private long rate;


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFilm(String film) {
        this.filmName = film;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getContent() {
        return content;
    }

    public long getRate() {
        return rate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
