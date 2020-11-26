
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationIii {

    private Emerald emerald;
    private FireredLeafgreen fireredLeafgreen;
    private RubySapphire rubySapphire;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Emerald getEmerald() {
        return emerald;
    }

    public void setEmerald(Emerald emerald) {
        this.emerald = emerald;
    }

    public FireredLeafgreen getFireredLeafgreen() {
        return fireredLeafgreen;
    }

    public void setFireredLeafgreen(FireredLeafgreen fireredLeafgreen) {
        this.fireredLeafgreen = fireredLeafgreen;
    }

    public RubySapphire getRubySapphire() {
        return rubySapphire;
    }

    public void setRubySapphire(RubySapphire rubySapphire) {
        this.rubySapphire = rubySapphire;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
