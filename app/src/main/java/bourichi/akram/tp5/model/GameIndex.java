
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GameIndex {

    private Integer gameIndex;
    private Version version;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
