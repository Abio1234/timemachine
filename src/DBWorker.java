import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abio on 19.08.2017.
 */
class DBWorker {

    private static final String URL = "jdbc:postgresql://localhost:8082/timemachine";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "admin";

    private static final String CREATE_USER_SQL = "INSERT INTO time.users (login, password, name, surname) VALUES('%s','%s','%s','%s')";
    private static final String REQUEST_USER_SQL = "SELECT * FROM time.users WHERE login = '%s' AND password = '%s';";
    private static final String CREATE_BEGIN_TIME_SQL = "INSERT INTO time.usertime (id, user_id, begin_date) VALUES (nextval('usertime_id_seq'), ?, current_timestamp);";
    private static final String CREATE_END_TIME_SQL = "UPDATE time.usertime SET end_date = current_timestamp WHERE id = '%s';";
    private static final String SELECT_BEGIN_TIME = "SELECT begin_date FROM time.usertime WHERE id = '%s';";
    private static final String SELECT_END_TIME = "SELECT end_date FROM time.usertime WHERE id = '%s';";
    private static final String SELECT_ALL_TIME = "SELECT end_date::TIMESTAMP - begin_date::TIMESTAMP FROM time.usertime WHERE id = '%s'";
    private static final String SELECT_WORK_TIME = "SELECT to_char(my_qw.this_date, 'dd.mm.yyyy'), to_char(sum(my_qw.work_time), 'hh24:mi:ss')\n" +
                                                        "FROM (SELECT user_id,\n" +
                                                        "       date_trunc('day', begin_date) as this_date,\n" +
                                                        "       end_date - begin_date as work_time\n" +
                                                        "FROM time.usertime\n" +
                                                        "WHERE user_id = '%s' AND end_date IS NOT NULL) AS my_qw\n" +
                                                        "GROUP BY my_qw.user_id, my_qw.this_date;";

    private static Connection getCon()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static void addUser(User user)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

            Statement statement = connection.createStatement();
            statement.execute(String.format(CREATE_USER_SQL,
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getSurname()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static User getUser(String login, String password)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.execute(String.format(REQUEST_USER_SQL,
                        login,
                        password));
                ResultSet result = statement.getResultSet();
                result.last();
                int size = result.getRow();
                if (size != 1) return null;
                return new User(
                        statement.getResultSet().getLong("id"),
                        statement.getResultSet().getString("login"),
                        statement.getResultSet().getString("password"),
                        statement.getResultSet().getString("name"),
                        statement.getResultSet().getString("surname"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static Long addBeginTime(Long id)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BEGIN_TIME_SQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
                preparedStatement.getGeneratedKeys().next();
                return preparedStatement.getGeneratedKeys().getLong(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static void addEndTime(Long id_time)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

                Statement statement = connection.createStatement();
                statement.execute(String.format(CREATE_END_TIME_SQL, id_time));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String getTime(Long id_time, String sql_string)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.execute(String.format(sql_string, id_time));
                ResultSet resultSet = statement.getResultSet();
                resultSet.last();
                return resultSet.getString(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static String getBeginTime(Long id_time)
    {
        return getTime(id_time, SELECT_BEGIN_TIME);
    }

    static String getEndTime(Long id_time)
    {
        return getTime(id_time, SELECT_END_TIME);
    }

    static String getAllTime(Long id_time)
    {
        return getTime(id_time, SELECT_ALL_TIME);
    }

    static List getWorkTime(Long id_user)
    {
        try
        {
            Connection connection = getCon();
            if (connection == null)
                throw new NullPointerException();

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(String.format(SELECT_WORK_TIME, id_user));
            ResultSet resultSet = statement.getResultSet();
            List<String> list = new ArrayList();
            while (resultSet.next()){
                list.add(resultSet.getString(1) + " пользователь проработал: " + resultSet.getString(2) + "c");
            }
            return list;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
