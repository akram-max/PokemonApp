
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationI {

    private RedBlue redBlue;
    private Yellow yellow;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RedBlue getRedBlue() {
        return redBlue;
    }

    public void setRedBlue(RedBlue redBlue) {
        this.redBlue = redBlue;
    }

    public Yellow getYellow() {
        return yellow;
    }

    public void setYellow(Yellow yellow) {
        this.yellow = yellow;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
