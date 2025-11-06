package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int userId = (int) session.getAttribute("user_id");
            int movieId = Integer.parseInt(request.getParameter("movie_id"));
            String theater = "Inox Bhubaneswar"; // ✅ Single fixed theater
            String showTime = request.getParameter("show_time");
            String seats = request.getParameter("seats");
            double totalPrice = Double.parseDouble(request.getParameter("total_price"));
            String bookingDate = new java.sql.Date(System.currentTimeMillis()).toString();

            // ✅ Connect to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cinema_db", "root", "Ritesh@2005");

            // ✅ Fetch all successfully booked seats
            Set<String> bookedSeats = new HashSet<>();
            PreparedStatement checkPs = conn.prepareStatement(
                    "SELECT seats FROM booking WHERE movie_id=? AND payment_status='SUCCESS'");
            checkPs.setInt(1, movieId);
            ResultSet rs = checkPs.executeQuery();

            while (rs.next()) {
                String bookedStr = rs.getString("seats");
                if (bookedStr != null && !bookedStr.trim().isEmpty()) {
                    for (String s : bookedStr.split(",")) {
                        bookedSeats.add(s.trim().toUpperCase());
                    }
                }
            }

            // ✅ Check if selected seat is already booked
            String[] seatArray = seats.split(",");
            for (String s : seatArray) {
                if (bookedSeats.contains(s.trim().toUpperCase())) {
                    conn.close();
                    request.setAttribute("errorMessage", "Seat " + s + " is already booked for this movie!");
                    request.setAttribute("movie_id", movieId);
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                    return;
                }
            }

            // ✅ If all seats free, insert booking
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO booking (user_id, movie_id, theater_name, seats, total_price, booking_date, show_time, payment_status) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, 'PENDING')",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);
            ps.setInt(2, movieId);
            ps.setString(3, theater);
            ps.setString(4, seats);
            ps.setDouble(5, totalPrice);
            ps.setString(6, bookingDate);
            ps.setString(7, showTime);
            ps.executeUpdate();

            ResultSet genKeys = ps.getGeneratedKeys();
            int bookingId = 0;
            if (genKeys.next()) bookingId = genKeys.getInt(1);
            conn.close();

            // ✅ Store session data
            session.setAttribute("booking_id", bookingId);
            session.setAttribute("movie_id", movieId);
            session.setAttribute("theater_name", theater);
            session.setAttribute("show_time", showTime);
            session.setAttribute("seats", seats);
            session.setAttribute("total_price", totalPrice);
            session.setAttribute("booking_date", bookingDate);

            response.sendRedirect("payment.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error in BookingServlet", e);
        }
    }
}
