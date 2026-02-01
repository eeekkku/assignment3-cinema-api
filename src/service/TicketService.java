package service;

import model.Ticket;
import repository.TicketRepository;
import repository.CrudRepository;
import java.sql.SQLException;
import java.util.List;

public class TicketService {


    private final CrudRepository<Ticket> repo;


    public TicketService(CrudRepository<Ticket> repo) {
        this.repo = repo;
    }

    public Ticket sellTicket(Ticket ticket) {
        ticket.validate();
        return repo.save(ticket);
    }
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }
}

