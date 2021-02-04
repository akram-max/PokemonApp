package fr.eilco;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import fr.eilco.adapter.GenerationRVAdapter;
import fr.eilco.adapter.PokemonRVAdapter;
import fr.eilco.dao.database.PokemonResultDAO;
import fr.eilco.dao.web.GenerationRepository;
import fr.eilco.dao.web.PokemonRepository;
import fr.eilco.db.DbConfig;
import fr.eilco.model.BaseGeneration;
import fr.eilco.model.BasePokemon;
import fr.eilco.model.Generation;
import fr.eilco.model.GenerationResult;
import fr.eilco.model.PokemonResult;
import fr.eilco.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {

    private GenerationRVAdapter generationRVAdapter;
    private PokemonRVAdapter pokemonRVAdapter;
    private List<GenerationResult> generationResultList;
    private List<PokemonResult> pokemonResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewPok = findViewById(R.id.rv_pokemon);
        pokemonRVAdapter = new PokemonRVAdapter(this);
        recyclerViewPok.setAdapter(pokemonRVAdapter);

        recyclerViewPok.setLayoutManager(new GridLayoutManager(this, 3));

        setTitle("Pokemon project");

        getGenerations();
        getPokemons();

    }

    /**
     * Generation API Call
     */
    private void getGenerations() {
        RecyclerView rvGen = findViewById(R.id.rv_generation);
        generationRVAdapter = new GenerationRVAdapter(this, position -> {
            updatePokemonByGen(String.valueOf(position + 1));
            Toast.makeText(getApplicationContext(), "Loading generation : " + (position + 1) + ", please wait...", Toast.LENGTH_LONG).show();
        });
        rvGen.setItemAnimator(new DefaultItemAnimator());
        rvGen.setAdapter(generationRVAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvGen.setLayoutManager(layoutManager);

        GenerationRepository generationRepository = ApiClient.getRetrofitInstance().create(GenerationRepository.class);
        Call<BaseGeneration> baseGenerationCall = generationRepository.findAll();
        baseGenerationCall.enqueue(new Callback<BaseGeneration>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<BaseGeneration> call, Response<BaseGeneration> response) {
                BaseGeneration baseGeneration = response.body();
                assert baseGeneration != null;
                generationResultList = baseGeneration.getResults();
                generationRVAdapter.addGeneration(generationResultList);
                Log.d("Gen", generationResultList.toString());
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<BaseGeneration> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }

    /**
     * Pokemon API Call
     */
    private void getPokemons() {
        PokemonRepository pokemonRepository = ApiClient.getRetrofitInstance().create(PokemonRepository.class);
        Call<BasePokemon> basePokemonCall = pokemonRepository.findAll();
        basePokemonCall.enqueue(new Callback<BasePokemon>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<BasePokemon> call, Response<BasePokemon> response) {
                BasePokemon basePokemon = response.body();
                assert basePokemon != null;
                pokemonResultList = basePokemon.getResults();

                // ROOM database
                PokemonResultDAO pokemonResultDAO = DbConfig.getRoomInstance(getApplicationContext()).pokemonResultDAO();
                if (pokemonResultDAO.getAll().isEmpty()) {
                    pokemonResultList.forEach(pokemonResultDAO::insertAll);
                    pokemonRVAdapter.addPokemon(pokemonResultList);
                } else {
                    pokemonRVAdapter.addPokemon(pokemonResultDAO.getAll());
                    Log.d("ROOM : ", pokemonResultDAO.getAll().toString());
                }

            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<BasePokemon> call, Throwable t) {
                Log.d("ROOM ERROR : ", t.toString());
            }
        });
    }

    /**
     * @param id Pokemon update by generation
     */
    private void updatePokemonByGen(String id) {
        GenerationRepository generationRepository = ApiClient.getRetrofitInstance().create(GenerationRepository.class);
        Call<Generation> generationCall = generationRepository.findOneById(id);
        generationCall.enqueue(new Callback<Generation>() {
            @Override
            public void onResponse(@NotNull Call<Generation> call, @NotNull Response<Generation> response) {
                List<PokemonResult> pokemonResults = response.body().getPokemon_species();
                pokemonRVAdapter.addPokemon(pokemonResults);
                Log.d("NewGen : ", pokemonResults.toString());
            }

            @Override
            public void onFailure(@NotNull Call<Generation> call, @NotNull Throwable t) {
                Log.d("ERROR : ", t.toString());
            }
        });
    }

}