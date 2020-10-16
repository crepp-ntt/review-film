package constant;

public interface CONSTANT {

    //PostgreSQL
    String DRIVE_NAME = "org.postgresql.Driver";
    String DB_URL = "jdbc:postgresql://localhost:5432/reviewer";
    String ID = "crepp";
    String PASS = "password";

    String[] USER_URL= {"/create_post", "/change_pass", "/change_profile"};
    String[] ADMIN_URL = {"/manage_user", "/manage_post"};


}
