package ru.rrenat358;

import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {

    private static final Pattern PATTERN = Pattern.compile("\\/(\\d+)");

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String pathInfo = request.getPathInfo();
        String contextPath = request.getContextPath();
        response.getWriter().println("request.getPathInfo() " + "<p>" + pathInfo + "</p>");
        response.getWriter().println("request.getContextPath() " + "<p>" + contextPath + "</p>");*/

        if (request.getPathInfo() == null || request.getPathInfo().equals("/")) {
            PrintWriter writer = response.getWriter();
            writer.println("<table>");
            writer.println("<tr>");
            writer.println("<th>id</th>");
            writer.println("<th>username</th>");
            writer.println("</tr>");

            for (User user : userRepository.findAll()) {
                writer.println("<tr>");
                writer.println("<td><a href='" + getServletContext().getContextPath() + "/user/" + user.getId() + "'>" + user.getId() + "</a></td>");
                writer.println("<td>" + user.getUsername() + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
        } else {
            Matcher matcher = PATTERN.matcher(request.getPathInfo());
            if (matcher.matches()) {
                long id = Long.parseLong(matcher.group(1));
                User user = userRepository.findById(id);
                if (user == null) {
                    response.getWriter().println("<p> User not found</p>");
                    response.setStatus(404);
                    return;
                }
                response.getWriter().println("<p>Id: " + user.getId() + "</p>");
                response.getWriter().println("<p>Username: " + user.getUsername() + "</p>");
            } else {
                response.getWriter().println("<p>" + "Bad parameters" + " </p>");
                response.setStatus(400);
            }
        }

    }
}
