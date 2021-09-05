package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimit {
    private int coreLimit;
    private String searchlimit;
    private int integration_manifestLimit;

    public int getIntegration_manifestLimit() {
        return integration_manifestLimit;
    }

    public int getCoreLimit() {
        return coreLimit;
    }

    public String getSearchlimit() {
        return searchlimit;
    }


    //For NestedFileds
    @SuppressWarnings("unchecked")
    @JsonProperty("resources") //watch for resources on the top level
    public void unmarshallNested(Map<String, Object> resources) {
        Map <String,Integer> core = (Map<String, Integer>) resources.get("core");
        coreLimit = core.get("limit");

        Map<String, String> search = (Map<String, String>) resources.get("search");
        searchlimit = String.valueOf(search.get("limit"));


        Map<String, Integer> integration_manifest = (Map<String, Integer>) resources.get("integration_manifest");
        integration_manifestLimit = integration_manifest.get("limit");
    }
}
