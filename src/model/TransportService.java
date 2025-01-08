import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransportService {
    private List<Bus> buses;
    private List<Commuter> commuters;

    public TransportService() {
        this.buses = new ArrayList<>();
        this.commuters = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void addCommuter(Commuter commuter) {
        commuters.add(commuter);
    }

    public List<Bus> getBusesByCapacity(int minCapacity) {
        return buses.stream()
                .filter(bus -> bus.getCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }

    public List<Bus> sortBusesByCapacity() {
        return buses.stream()
                .sorted(Comparator.comparingInt(Bus::getCapacity))
                .collect(Collectors.toList());
    }

    public void printAllBuses() {
        buses.forEach(System.out::println);
    }

    public void printAllCommuters() {
        commuters.forEach(System.out::println);
    }
}
