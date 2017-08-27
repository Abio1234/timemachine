import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        User main_user = DBWorker.getUser(request.getParameter("login"), request.getParameter("password")); // Авторизация
        if (main_user != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("name", main_user.getName());
            session.setAttribute("surname", main_user.getSurname());
            session.setAttribute("id", main_user.getId());

            getServletContext().getRequestDispatcher("/fortable.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
