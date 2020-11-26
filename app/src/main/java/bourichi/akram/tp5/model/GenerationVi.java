
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class GenerationVi {

    private OmegarubyAlphasapphire omegarubyAlphasapphire;
    private XY xY;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public OmegarubyAlphasapphire getOmegarubyAlphasapphire() {
        return omegarubyAlphasapphire;
    }

    public void setOmegarubyAlphasapphire(OmegarubyAlphasapphire omegarubyAlphasapphire) {
        this.omegarubyAlphasapphire = omegarubyAlphasapphire;
    }

    public XY getXY() {
        return xY;
    }

    public void setXY(XY xY) {
        this.xY = xY;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
