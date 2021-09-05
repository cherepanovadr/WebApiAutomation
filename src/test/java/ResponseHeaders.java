import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;


import static org.testng.Assert.assertEquals;

public class ResponseHeaders extends BaseClass {
    @Test
    public void contentTypeJson() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void serverIsGitHub() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        String headerValue = ResponseUtils.getHeader(response, "Server");
        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void xRateLimitIsSixty() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        String limitVal = ResponseUtils.getHeaderJava8way(response, "X-RateLimit-Limit");
        assertEquals(limitVal, "60");
    }

    @Test
    public void eTagIsPresent() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        boolean tagIsPresent = ResponseUtils.headerIsPresent(response, "eTag");
        assertEquals(tagIsPresent, true);
    }
}
