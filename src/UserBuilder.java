import javax.servlet.http.HttpServletRequest;

/**
 * Created by Abio on 19.08.2017.
 */
public class UserBuilder implements Builder<User>
{
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String USER_FIRST_NAME = "name";
    private static final String USER_SECOND_NAME = "surname";

    private HttpServletRequest request;

    public UserBuilder(HttpServletRequest request)
    {
        this.request = request;
    }

    @Override
    public User build()
    {
        return new User(
                request.getParameter(USER_LOGIN),
                request.getParameter(USER_PASSWORD),
                request.getParameter(USER_FIRST_NAME),
                request.getParameter(USER_SECOND_NAME));
    }
}
