public class Commuter {
    private String name;
    private String ticketNumber;

    public Commuter(String name, String ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Commuter{" +
                "name='" + name + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                '}';
    }
}
