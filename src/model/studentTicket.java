package model;

public class studentTicket extends ticket {
    public studentTicket(int session_id, int seat_number, int price, String customer_name) {
        super(session_id, seat_number, price, customer_name);
    }

    @Override
    public double calculate_price() {
        return 1800;
    }

}
