/**
 * Created by Abio on 19.08.2017.
 */
public class User {

    private Long id;
    private String password;
    private String name;
    private String surname;
    private String login;

    public User(){}

    public User(String login, String password, String name, String surname)
    {
        this(null, login, password, name ,surname);
    }

    public User(Long id, String login, String password, String name, String surname)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
