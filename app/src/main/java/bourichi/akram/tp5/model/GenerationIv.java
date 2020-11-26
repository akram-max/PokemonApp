
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationIv {

    private DiamondPearl diamondPearl;
    private HeartgoldSoulsilver heartgoldSoulsilver;
    private Platinum platinum;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DiamondPearl getDiamondPearl() {
        return diamondPearl;
    }

    public void setDiamondPearl(DiamondPearl diamondPearl) {
        this.diamondPearl = diamondPearl;
    }

    public HeartgoldSoulsilver getHeartgoldSoulsilver() {
        return heartgoldSoulsilver;
    }

    public void setHeartgoldSoulsilver(HeartgoldSoulsilver heartgoldSoulsilver) {
        this.heartgoldSoulsilver = heartgoldSoulsilver;
    }

    public Platinum getPlatinum() {
        return platinum;
    }

    public void setPlatinum(Platinum platinum) {
        this.platinum = platinum;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
