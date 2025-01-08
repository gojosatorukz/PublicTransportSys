public class Main {
    public static void main(String[] args) {
        TransportService transportService = new TransportService();

        // Создаем автобусы
        Bus bus1 = new Bus("B001", "Route A", 50);
        Bus bus2 = new Bus("B002", "Route B", 40);
        Bus bus3 = new Bus("B003", "Route C", 30);

        transportService.addBus(bus1);
        transportService.addBus(bus2);
        transportService.addBus(bus3);

        // Создаем пассажиров
        Commuter commuter1 = new Commuter("Alice", "T001");
        Commuter commuter2 = new Commuter("Bob", "T002");

        transportService.addCommuter(commuter1);
        transportService.addCommuter(commuter2);

        // Вывод всех автобусов
        System.out.println("All Buses:");
        transportService.printAllBuses();

        // Фильтрация автобусов по вместимости
        System.out.println("\nBuses with capacity >= 40:");
        transportService.getBusesByCapacity(40).forEach(System.out::println);

        // Сортировка автобусов по вместимости
        System.out.println("\nBuses sorted by capacity:");
        transportService.sortBusesByCapacity().forEach(System.out::println);
    }
}
