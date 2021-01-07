package bourichi.akram.tp5;

import bourichi.akram.tp5.model.Pokemon;
import bourichi.akram.tp5.model.PokemonResumeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("pokemon")
    Call<PokemonResumeResponse> getPokemons();

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonsDetails(@Path("id") String id);

}
