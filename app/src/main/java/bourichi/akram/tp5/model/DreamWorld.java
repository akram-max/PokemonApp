
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class DreamWorld {

    private String frontDefault;
    private Object frontFemale;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public Object getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(Object frontFemale) {
        this.frontFemale = frontFemale;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
