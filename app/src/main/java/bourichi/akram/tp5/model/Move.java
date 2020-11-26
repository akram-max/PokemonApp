
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Move {

    private Move_ move;
    private List<VersionGroupDetail> versionGroupDetails = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Move_ getMove() {
        return move;
    }

    public void setMove(Move_ move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
