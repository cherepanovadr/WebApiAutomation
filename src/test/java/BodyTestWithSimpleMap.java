import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static entities.User.ID;
import static entities.User.LOGIN;

public class BodyTestWithSimpleMap extends BaseClass {

    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/andrejss88");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsObject = new JSONObject(jsonBody);
        String loginValue = (String) getValueFor(jsObject, LOGIN);
        Assert.assertEquals(loginValue, "andrejss88");

    }
    @Test
    public void returnCorrectID() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/andrejss88");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsObject = new JSONObject(jsonBody);
        Integer loginValue = (Integer) getValueFor(jsObject, ID);
        Assert.assertEquals(loginValue, Integer.valueOf(11834443));

    }

    private Object getValueFor(JSONObject jsObject, String key) {
        return jsObject.get(key);
    }

}
