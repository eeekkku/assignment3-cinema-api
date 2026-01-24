package service;

import model.Ticket;
import repository.TicketRepository;
import java.sql.SQLException;

public class TicketService {
    private final TicketRepository repo;

    public TicketService(TicketRepository repo) { this.repo = repo; }

    public Ticket sellTicket(Ticket ticket) throws SQLException {
        ticket.validate();
        if (repo.isSeatTaken(ticket.getSessionId(), ticket.getSeatNumber())) {
            throw new IllegalArgumentException("Seat already taken");
        }
        return repo.save(ticket);
    }
}

