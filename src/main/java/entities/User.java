package entities;

public class User {
    //For tests using JsonObject
    public static final String LOGIN = "login";
    public static final String ID = "id";
    public static final String EMAIL = "email";

    private String login;
    private int id;


    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
