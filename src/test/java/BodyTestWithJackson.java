import entities.NotFound;
import entities.RateLimit;
import entities.User;
import entities.userAndrej;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithJackson extends BaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/andrejss88");
        response = client.execute(get);
        User user = ResponseUtils.unmarshallGeneric(response, User.class);
        Assert.assertEquals(user.getLogin(), "andrejss88");
    }

    @Test
    public void returnsCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/andrejss88");
        response = client.execute(get);
        User user = ResponseUtils.unmarshallGeneric(response, User.class);
        Assert.assertEquals(user.getId(), 11834443);
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexistingendpoint");
        response = client.execute(get);
        NotFound notFoundMessage = ResponseUtils.unmarshallGeneric(response, NotFound.class);
        Assert.assertEquals(notFoundMessage.getMessage(), "Not Found");
    }

    @Test
    public void correctRateLimitAreSet() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response = client.execute(get);
        RateLimit rateLimits = ResponseUtils.unmarshallGeneric(response, RateLimit.class);
        Assert.assertEquals(rateLimits.getCoreLimit(), 60);
        Assert.assertEquals(rateLimits.getSearchlimit(), "10");
        Assert.assertEquals(rateLimits.getIntegration_manifestLimit(), 5000);
    }

    @Test
    public void correctUserIsSet() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/andrejss88");
        response = client.execute(get);
        userAndrej userAnd = ResponseUtils.unmarshallGeneric(response, userAndrej.class);
        Assert.assertEquals(userAnd.getBio(), "QA professional and Test Automation Engineer in Java.");
    }
}
