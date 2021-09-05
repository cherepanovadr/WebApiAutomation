import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends BaseClass {

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {"/rate_limit"},
                {"/rate_limit"}
        };
    }

    @Test
    //testNG
    public void baseUrlReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        //apacheHttpClient
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(dataProvider = "endpoints")
    public void baseUrlRateLimitReturns200(String endpoint)  throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + endpoint);
        //apacheHttpClient
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);

    }


}
