package fr.eilco.dao.web;

import java.util.List;

import fr.eilco.model.BasePokemon;
import fr.eilco.model.Pokemon;
import fr.eilco.model.PokemonEvolution;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;

public interface PokemonRepository {

    @GET("pokemon")
    Call<BasePokemon> findAll();

    @GET("pokemon/{id}")
    Call<Pokemon> findOneById(@Path("id") String id);

    @GET("pokemon/{name}")
    Call<List<PokemonEvolution>> findOneByName(@Path("name") String name);

}
