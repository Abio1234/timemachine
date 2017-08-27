import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Abio on 20.08.2017.
 */
@WebServlet(urlPatterns = "/ServletForRegistration")
public class ServletForRegistration extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        try {
            if (request.getParameter("password").equals(request.getParameter("password2")))
            {
                DBWorker.addUser(new UserBuilder(request).build()); // Регистрация
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            {
                throw new RegisterExeption();
            }
        } catch (RegisterExeption registerExeption) {
            registerExeption.printStackTrace();
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}