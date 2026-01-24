package model;

public abstract class ticket {
    protected int id;
    protected int session_id;
    protected int seat_number;
    protected int price;
    protected String customer_name;

    public  ticket(int session_id, int seat_number, int price, String customer_name) {
        this.session_id = session_id;
        this.seat_number = seat_number;
        this.price = price;
        this.customer_name = customer_name;
    }

    public abstract double calculate_price();


}
