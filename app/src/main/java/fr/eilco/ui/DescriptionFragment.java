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

import fr.eilco.R;
import fr.eilco.dao.web.PokemonRepository;
import fr.eilco.model.Pokemon;
import fr.eilco.model.Types;
import fr.eilco.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionFragment extends Fragment {

    private Pokemon pokemon;
    private ImageView imageViewPok;
    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewHeight;
    private TextView textViewWeight;
    private TextView textViewType;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");

        imageViewPok = view.findViewById(R.id.pokemon_img2);
        textViewName = view.findViewById(R.id.pokemon_name);
        textViewDescription = view.findViewById(R.id.pokemon_description);
        textViewHeight = view.findViewById(R.id.pokemon_height);
        textViewWeight = view.findViewById(R.id.pokemon_weight);
        textViewType = view.findViewById(R.id.pokemon_type);

        getPokemonDetails(id);
    }

    private void getPokemonDetails(String id) {
        PokemonRepository pokemonRepository = ApiClient.getRetrofitInstance().create(PokemonRepository.class);
        Call<Pokemon> pokemonCall = pokemonRepository.findOneById(id);
        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NotNull Call<Pokemon> call, @NotNull Response<Pokemon> response) {
                pokemon = response.body();
                Glide.with(getContext())
                        .load("https://pokeres.bastionbot.org/images/pokemon/" + id + ".png")
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imageViewPok);
                textViewName.setText(pokemon.getName());
                textViewDescription.setText("...");
                String h = "Taille : " + pokemon.getHeight() + "m";
                textViewHeight.setText(h);
                String w = "Poids : " + pokemon.getWeight() + " Kg";
                textViewWeight.setText(w);
                StringBuilder tempType = new StringBuilder();
                for (Types types : pokemon.getTypes()) {
                    tempType.append(" - ").append(types.getType().getName());
                }
                String t = "Types : " + tempType;
                textViewType.setText(t);
                Log.d("OnePokemon : ", pokemon.toString());
            }

            @Override
            public void onFailure(@NotNull Call<Pokemon> call, @NotNull Throwable t) {
                Log.d("Error", t.toString());
            }
        });

    }

}