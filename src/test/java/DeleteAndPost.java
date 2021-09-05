import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DeleteAndPost extends BaseClass {

    //these tests will only be passed if token and uri are replaced with valid data


    @Test
    public void createRepoReturns201() throws IOException {
        HttpPost request = new HttpPost("https://api.github.com/user/repos");

        //Set the Basic Auth header
/*      String auth = "cherepanovadr@gmail.com:terran1A";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
*/
        //Set the JWT auth
        request.setHeader(HttpHeaders.AUTHORIZATION, "token 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");

        //Define Json to Post and set as Entity
        String json = "{\"name\": \"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void deleteIsSuccessful() throws IOException {
        HttpDelete request = new HttpDelete("https://api.github.com/repos/cherepanovadr/deleteme");
        //Basic, OAuth/2, JWT
        request.setHeader(HttpHeaders.AUTHORIZATION, "token myToken");
        response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }


}
