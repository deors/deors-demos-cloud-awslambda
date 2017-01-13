package deors.demos.cloud.awslambda;

public class HelloResponse {

    private String greetingMessage;
    private String allowedMessage;

    public HelloResponse() {
        super();
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public String getAllowedMessage() {
        return allowedMessage;
    }

    public void setGreetingMessage(String newGreetingMessage) {
        this.greetingMessage = newGreetingMessage;
    }

    public void setAllowedMessage(String newAllowedMessage) {
        this.allowedMessage = newAllowedMessage;
    }
}
