package model;

public abstract class Ticket implements PricedItem, Validatable {
    protected int id;
    protected int sessionId;
    protected int seatNumber;
    protected String customerName;

    public Ticket(int sessionId, int seatNumber, String customerName) {
        this.sessionId = sessionId;
        this.seatNumber = seatNumber;
        this.customerName = customerName;
    }

    @Override
    public abstract double calculatePrice();

    @Override
    public void validate() {
        if (seatNumber <= 0) {
            throw new IllegalArgumentException("Seat number must be positive");
        }
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name is required");
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getSessionId() { return sessionId; }
    public int getSeatNumber() { return seatNumber; }
    public String getCustomerName() { return customerName; }


}
