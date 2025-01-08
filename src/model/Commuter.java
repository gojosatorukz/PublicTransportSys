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

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNumber() {
        return ticketNumber;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Commuter commuter = (Commuter) obj;
        return name.equals(commuter.name) && ticketNumber.equals(commuter.ticketNumber);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + ticketNumber.hashCode();
    }
}
