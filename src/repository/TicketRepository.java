package repository;
import model.RegularTicket;
import model.StudentTicket;
import model.Ticket;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    public Ticket save(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO tickets(session_id, seat_number, customer_name, ticket_type) VALUES (?, ?, ?, ?) RETURNING id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getSessionId());
            stmt.setInt(2, ticket.getSeatNumber());
            stmt.setString(3, ticket.getCustomerName());
            stmt.setString(4, ticket instanceof RegularTicket ? "REGULAR" : "STUDENT");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ticket.setId(rs.getInt("id"));
            }
        }
        return ticket;
    }

    public List<Ticket> findAll() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("ticket_type");
                Ticket t = type.equals("REGULAR") ?
                        new RegularTicket(rs.getInt("session_id"), rs.getInt("seat_number"), rs.getString("customer_name")) :
                        new StudentTicket(rs.getInt("session_id"), rs.getInt("seat_number"), rs.getString("customer_name"));
                tickets.add(t);
            }
        }
        return tickets;
    }

    public boolean isSeatTaken(int sessionId, int seatNumber) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tickets WHERE session_id = ? AND seat_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sessionId);
            stmt.setInt(2, seatNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
