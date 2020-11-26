
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationViii {

    private Icons_ icons;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Icons_ getIcons() {
        return icons;
    }

    public void setIcons(Icons_ icons) {
        this.icons = icons;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
