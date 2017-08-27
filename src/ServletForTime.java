import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletForTime")
public class ServletForTime extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        session.setAttribute("id_time", DBWorker.addBeginTime((Long) session.getAttribute("id")));
        session.setAttribute("begin_time", DBWorker.getBeginTime((Long) session.getAttribute("id_time"))); // Время прибытия на работу

        getServletContext().getRequestDispatcher("/fortable.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        DBWorker.addEndTime((Long) session.getAttribute("id_time"));
        session.setAttribute("end_time", DBWorker.getEndTime((Long) session.getAttribute("id_time"))); // Время ухода с работы
        session.setAttribute("all_time", DBWorker.getAllTime((Long) session.getAttribute("id_time"))); // Время проведенное на работе

        getServletContext().getRequestDispatcher("/fortable.jsp").forward(request, response);
    }
}
