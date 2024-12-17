public class TransportService {
    private String serviceName;

    public TransportService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "TransportService{" +
                "serviceName='" + serviceName + '\'' +
                '}';
    }
}
