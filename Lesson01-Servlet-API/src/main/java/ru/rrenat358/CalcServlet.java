package ru.rrenat358;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/calcServlet")
public class CalcServlet extends HttpServlet {

    // calcServlet?param1=10&param2=20&?date=2022-08-08
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param1 = Integer.parseInt(request.getParameter("param1"));
        int param2 = Integer.parseInt(request.getParameter("param2"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateRaw = request.getParameter("date");

        LocalDate localDate = LocalDate.parse(dateRaw, formatter);

        int sum = param1 + param2;

        response.getWriter().println("<p>" + sum + "</p>");
        response.getWriter().println("<p>" + localDate.plusDays(1) + "</p>");
    }
}
