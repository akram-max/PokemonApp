
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationV {

    private BlackWhite blackWhite;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public BlackWhite getBlackWhite() {
        return blackWhite;
    }

    public void setBlackWhite(BlackWhite blackWhite) {
        this.blackWhite = blackWhite;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
