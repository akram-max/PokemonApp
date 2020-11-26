
package bourichi.akram.tp5.model;

import java.util.HashMap;
import java.util.Map;

public class Versions {

    private GenerationI generationI;
    private GenerationIi generationIi;
    private GenerationIii generationIii;
    private GenerationIv generationIv;
    private GenerationV generationV;
    private GenerationVi generationVi;
    private GenerationVii generationVii;
    private GenerationViii generationViii;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public GenerationI getGenerationI() {
        return generationI;
    }

    public void setGenerationI(GenerationI generationI) {
        this.generationI = generationI;
    }

    public GenerationIi getGenerationIi() {
        return generationIi;
    }

    public void setGenerationIi(GenerationIi generationIi) {
        this.generationIi = generationIi;
    }

    public GenerationIii getGenerationIii() {
        return generationIii;
    }

    public void setGenerationIii(GenerationIii generationIii) {
        this.generationIii = generationIii;
    }

    public GenerationIv getGenerationIv() {
        return generationIv;
    }

    public void setGenerationIv(GenerationIv generationIv) {
        this.generationIv = generationIv;
    }

    public GenerationV getGenerationV() {
        return generationV;
    }

    public void setGenerationV(GenerationV generationV) {
        this.generationV = generationV;
    }

    public GenerationVi getGenerationVi() {
        return generationVi;
    }

    public void setGenerationVi(GenerationVi generationVi) {
        this.generationVi = generationVi;
    }

    public GenerationVii getGenerationVii() {
        return generationVii;
    }

    public void setGenerationVii(GenerationVii generationVii) {
        this.generationVii = generationVii;
    }

    public GenerationViii getGenerationViii() {
        return generationViii;
    }

    public void setGenerationViii(GenerationViii generationViii) {
        this.generationViii = generationViii;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
