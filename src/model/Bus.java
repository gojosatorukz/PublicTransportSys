public class Bus {
    private String busNumber;
    private String route;
    private int capacity;

    public Bus(String busNumber, String route, int capacity) {
        this.busNumber = busNumber;
        this.route = route;
        this.capacity = capacity;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getRoute() {
        return route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", route='" + route + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
