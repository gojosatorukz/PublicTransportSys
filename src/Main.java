public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("B123", "Downtown", 50);
        Bus bus2 = new Bus("B124", "Uptown", 45);

        Commuter commuter1 = new Commuter("Alice", "T001");
        Commuter commuter2 = new Commuter("Bob", "T002");

        TransportService service = new TransportService("City Bus Service");

        System.out.println("Bus Details:");
        System.out.println(bus1);
        System.out.println(bus2);

        System.out.println("\nCommuter Details:");
        System.out.println(commuter1);
        System.out.println(commuter2);

        System.out.println("\nTransport Service Details:");
        System.out.println(service);

        System.out.println("\nBus Comparison:");
        System.out.println("Are bus1 and bus2 equal? " + bus1.getBusNumber().equals(bus2.getBusNumber()));
    }
}
