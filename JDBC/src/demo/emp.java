package demo;

public class emp {
    private int id;
    private String name;
    private double balance;

    public emp(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance;
    }
}
