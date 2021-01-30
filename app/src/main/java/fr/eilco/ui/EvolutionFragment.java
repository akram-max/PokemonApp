package fr.eilco.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import fr.eilco.R;
import fr.eilco.dao.web.PokemonRepository;
import fr.eilco.model.PokemonEvolution;
import fr.eilco.api.ApiClientEvolution;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvolutionFragment extends Fragment {

    private PokemonRepository pokemonRepository;
    private TextView textViewPokName;
    private final List<ImageView> imageViewList = new ArrayList<>();
    private static int i = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_evolution, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");

        pokemonRepository = ApiClientEvolution.getRetrofitInstance().create(PokemonRepository.class);

        textViewPokName = view.findViewById(R.id.pokemon_name2);
        imageViewList.add(view.findViewById(R.id.pokemon_img3));
        imageViewList.add(view.findViewById(R.id.pokemon_img4));
        imageViewList.add(view.findViewById(R.id.pokemon_img5));

        getEvolutions(name);
    }

    private void getEvolutions(String name) {
        Call<List<PokemonEvolution>> pokemonEvolutionCall = pokemonRepository.findOneByName(name);
        pokemonEvolutionCall.enqueue(new Callback<List<PokemonEvolution>>() {
            @Override
            public void onResponse(@NotNull Call<List<PokemonEvolution>> call, @NotNull Response<List<PokemonEvolution>> response) {
                List<PokemonEvolution> pokemonEvolutions = response.body();
                textViewPokName.setText(name);
                getImageEvolutions(pokemonEvolutions.get(0).getFamily().getEvolutionLine());

                Log.d("evolutions", pokemonEvolutions.toString());
            }

            @Override
            public void onFailure(@NotNull Call<List<PokemonEvolution>> call, @NotNull Throwable t) {
                Log.e("ERROR_EV", t.toString());
            }
        });
    }

    private void getImageEvolutions(List<String> evolutions) {
        for (String evolution : evolutions) {
            Call<List<PokemonEvolution>> pokemonEvolutionCall = pokemonRepository.findOneByName(evolution);
            pokemonEvolutionCall.enqueue(new Callback<List<PokemonEvolution>>() {
                @Override
                public void onResponse(@NotNull Call<List<PokemonEvolution>> call, @NotNull Response<List<PokemonEvolution>> response) {
                    List<PokemonEvolution> pokemonEvolutions = response.body();

                    Glide.with(getContext())
                            .load(pokemonEvolutions.get(0).getSprite())
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(imageViewList.get(i));
                    i++;

                    Log.d("evolutions list", evolution);
                }

                @Override
                public void onFailure(@NotNull Call<List<PokemonEvolution>> call, @NotNull Throwable t) {
                    Log.e("ERROR_EV", t.toString());
                }
            });
        }
    }

}