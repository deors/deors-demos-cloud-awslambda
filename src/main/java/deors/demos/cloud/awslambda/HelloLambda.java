package deors.demos.cloud.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloLambda implements RequestHandler<HelloRequest, HelloResponse> {

    private LambdaLogger logger;

    @Override
    public HelloResponse handleRequest(HelloRequest request, Context context) {

        logger = context.getLogger();
        logger.log(context.getAwsRequestId() + ": request received id");
        logger.log(context.getAwsRequestId() + ": name = " + request.getName());
        logger.log(context.getAwsRequestId() + ": age = " + request.getAge());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        String greetingMessage = MessageFormat.format(
            "hello {0} we received your request at {1} on {2}",
            request.getName(), now.format(dateFormatter), now.format(timeFormatter));

        String allowedMessage;
        if (request.getAge() >= 21) {
            allowedMessage = "you are allowed to use our services";
        } else {
            allowedMessage = "apologies but your request has been denied; only people 21 or above can use our services";
        }

        HelloResponse response = new HelloResponse();
        response.setGreetingMessage(greetingMessage);
        response.setAllowedMessage(allowedMessage);

        return response;
    }
}
