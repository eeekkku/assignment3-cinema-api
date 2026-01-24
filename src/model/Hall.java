package model;

public class Hall {
    private int id;
    private String name;
    private int capacity;

    public Hall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

}


