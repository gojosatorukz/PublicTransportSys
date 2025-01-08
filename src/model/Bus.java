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

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bus bus = (Bus) obj;
        return capacity == bus.capacity &&
                busNumber.equals(bus.busNumber) &&
                route.equals(bus.route);
    }

    @Override
    public int hashCode() {
        return busNumber.hashCode() + route.hashCode() + capacity;
    }
}
