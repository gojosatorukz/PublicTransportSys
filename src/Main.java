import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/public_transport";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

class BusService {
    public void addBus(String busNumber, String route, int capacity) throws SQLException {
        String query = "INSERT INTO buses (bus_number, route, capacity) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, busNumber);
            statement.setString(2, route);
            statement.setInt(3, capacity);
            statement.executeUpdate();
        }
    }

    public void getAllBuses() throws SQLException {
        String query = "SELECT * FROM buses";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Bus ID: " + resultSet.getInt("id"));
                System.out.println("Bus Number: " + resultSet.getString("bus_number"));
                System.out.println("Route: " + resultSet.getString("route"));
                System.out.println("Capacity: " + resultSet.getInt("capacity"));
                System.out.println("----");
            }
        }
    }

    public void updateBus(int id, String newRoute) throws SQLException {
        String query = "UPDATE buses SET route = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newRoute);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    public void deleteBus(int id) throws SQLException {
        String query = "DELETE FROM buses WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}


class CommuterService {
    public void addCommuter(String name, String ticketNumber) throws SQLException {
        String query = "INSERT INTO commuters (name, ticket_number) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, ticketNumber);
            statement.executeUpdate();
        }
    }

    public void getAllCommuters() throws SQLException {
        String query = "SELECT * FROM commuters";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Commuter ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Ticket Number: " + resultSet.getString("ticket_number"));
                System.out.println("----");
            }
        }
    }

    public void updateCommuter(int id, String newName, String newTicketNumber) throws SQLException {
        String query = "UPDATE commuters SET name = ?, ticket_number = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, newTicketNumber);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    public void deleteCommuter(int id) throws SQLException {
        String query = "DELETE FROM commuters WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}



public class Main {
    public static void main(String[] args) {
        BusService busService = new BusService();
        CommuterService commuterService = new CommuterService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить автобус");
            System.out.println("2. Посмотреть список автобусов");
            System.out.println("3. Обновить автобус");
            System.out.println("4. Удалить автобус");
            System.out.println("5. Добавить пассажира");
            System.out.println("6. Посмотреть список пассажиров");
            System.out.println("7. Обновить пассажира");
            System.out.println("8. Удалить пассажира");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Введите номер автобуса: ");
                        String busNumber = scanner.nextLine();
                        System.out.print("Введите маршрут автобуса: ");
                        String route = scanner.nextLine();
                        System.out.print("Введите вместимость автобуса: ");
                        int capacity = scanner.nextInt();
                        busService.addBus(busNumber, route, capacity);
                        System.out.println("Автобус добавлен.");
                    }
                    case 2 -> busService.getAllBuses();
                    case 3 -> {
                        System.out.print("Введите ID автобуса: ");
                        int busId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Введите новый маршрут автобуса: ");
                        String newRoute = scanner.nextLine();
                        busService.updateBus(busId, newRoute);
                        System.out.println("Данные автобуса обновлены.");
                    }
                    case 4 -> {
                        System.out.print("Введите ID автобуса: ");
                        int busId = scanner.nextInt();
                        busService.deleteBus(busId);
                        System.out.println("Автобус удалён.");
                    }
                    case 5 -> {
                        System.out.print("Введите имя пассажира: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите номер билета: ");
                        String ticketNumber = scanner.nextLine();
                        commuterService.addCommuter(name, ticketNumber);
                        System.out.println("Пассажир добавлен.");
                    }
                    case 6 -> commuterService.getAllCommuters();
                    case 7 -> {
                        System.out.print("Введите ID пассажира: ");
                        int commuterId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Введите новое имя пассажира: ");
                        String newName = scanner.nextLine();
                        System.out.print("Введите новый номер билета: ");
                        String newTicketNumber = scanner.nextLine();
                        commuterService.updateCommuter(commuterId, newName, newTicketNumber);
                        System.out.println("Данные пассажира обновлены.");
                    }
                    case 8 -> {
                        System.out.print("Введите ID пассажира: ");
                        int commuterId = scanner.nextInt();
                        commuterService.deleteCommuter(commuterId);
                        System.out.println("Пассажир удалён.");
                    }
                    case 0 -> {
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Неверный выбор, попробуйте ещё раз.");
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при выполнении операции: " + e.getMessage());
            }
        }
    }
}
