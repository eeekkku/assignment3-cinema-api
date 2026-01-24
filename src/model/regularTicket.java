package model;

public class regularTicket extends ticket {

    public regularTicket(int session_id, int seat_number, int price, String customer_name) {
        super(session_id, seat_number, price, customer_name);
    }

    @Override
    public double calculate_price() {
        return 2200;
    }
}
