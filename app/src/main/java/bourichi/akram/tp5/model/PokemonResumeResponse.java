package bourichi.akram.tp5.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonResumeResponse {
    @SerializedName("results")
    private ArrayList<PokemonResume> results;

    public ArrayList<PokemonResume> getResults() {
        return results;
    }

    public void setResults(ArrayList<PokemonResume> results) {
        this.results = results;
    }
}
