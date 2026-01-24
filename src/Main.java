import model.*;
import repository.TicketRepository;
import service.TicketService;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connected to DB successfully!");

            TicketRepository repo = new TicketRepository();
            TicketService service = new TicketService(repo);


            Ticket t1 = new RegularTicket(1, 5, "Yerkezhan");
            Ticket t2 = new StudentTicket(1, 2, "Valeriya");

            service.sellTicket(t1);
            service.sellTicket(t2);

            try {
                Ticket t3 = new RegularTicket(1, 5, "Aiman");
                service.sellTicket(t3);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            List<Ticket> tickets = repo.findAll();
            for (Ticket t : tickets) {
                System.out.println(t.getCustomerName() + " bought ticket for seat " + t.getSeatNumber() + ", price: " + t.calculatePrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
