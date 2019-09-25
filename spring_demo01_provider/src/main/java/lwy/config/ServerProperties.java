package lwy.config;


//@ConfigurationProperties(prefix = "server",ignoreUnknownFields = true)
public class ServerProperties {
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
