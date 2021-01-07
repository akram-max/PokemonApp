package bourichi.akram.tp5;

import android.graphics.Color;
import android.os.Bundle;

import bourichi.akram.tp5.model.Pokemon;
import bourichi.akram.tp5.model.PokemonResume;
import bourichi.akram.tp5.model.PokemonResumeResponse;
import bourichi.akram.tp5.retrofit.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PokemonRecyclerViewActivity extends AppCompatActivity {

    /* List of pokemons and recycler view*/
    public List<Pokemon> pokemons_response = new ArrayList<Pokemon>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler_view);
        apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        /* RecyclerView */
        recyclerView = findViewById(R.id.rvContacts);
        recyclerViewAdapter = new RecyclerViewAdapter(pokemons_response, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        /* 1st API CALL */
        Call<PokemonResumeResponse> call = apiService.getPokemons();
        call.enqueue(new Callback<PokemonResumeResponse>() {
            @Override
            public void onResponse(Call<PokemonResumeResponse> call, retrofit2.Response<PokemonResumeResponse> response) {

                PokemonResumeResponse pokemonResumeResponse = response.body();

                assert pokemonResumeResponse != null;
                List<PokemonResume> list_pokemons = pokemonResumeResponse.getResults();
                for (PokemonResume pokemonResume : list_pokemons) {
                    if (response.body() != null) {
                        String url = pokemonResume.getUrl();
                        String id = url.substring(url.length() - 2);

                        //##############################################################

                        /* 2nd API CALL */
                        Call<Pokemon> call_pokemons_details = apiService.getPokemonsDetails(id);
                        call_pokemons_details.enqueue(new Callback<Pokemon>() {

                            @Override
                            public void onResponse(Call<Pokemon> call_pokemons_details, retrofit2.Response<Pokemon> response) {

                                Pokemon pokemonResponse = response.body();
                                pokemons_response.add(pokemonResponse);
                                recyclerViewAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<Pokemon> call, Throwable t) {
                                Log.e("Erreur_R", t.toString());
                            }
                        });
                        //##############################################################

                        Log.e("successs", "success");
                    } else {
                        Log.e("erreur_contacts", "erreur");
                    }
                }
            }


            @Override
            public void onFailure(Call<PokemonResumeResponse> call, Throwable t) {
                Log.e("Erreur_R", t.toString());
            }
        });

    }
}