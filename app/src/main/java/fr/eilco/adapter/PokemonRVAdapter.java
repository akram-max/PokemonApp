package fr.eilco.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import fr.eilco.DescriptionActivity;
import fr.eilco.R;

import fr.eilco.model.PokemonResult;

public class PokemonRVAdapter extends RecyclerView.Adapter<PokemonRVAdapter.ViewHolder> {

    private List<PokemonResult> pokemonResultList = new ArrayList<>();
    private final Context context;

    public PokemonRVAdapter(Context context) {
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewPok;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPok = itemView.findViewById(R.id.pokemon_img);
       }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRVAdapter.ViewHolder holder, int position) {
        PokemonResult pokemonResult = this.pokemonResultList.get(position);
        String[] url = pokemonResult.getUrl().split("/");
        String id = url[url.length - 1];
        Glide.with(context)
                .load("https://pokeres.bastionbot.org/images/pokemon/" + id + ".png")
                .centerCrop()
                .timeout(3000)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewPok);

        // Click event
        holder.imageViewPok.setOnClickListener(v -> {
            Intent descriptionIntent = new Intent(context, DescriptionActivity.class);
            descriptionIntent.putExtra("id", id);
            descriptionIntent.putExtra("name", pokemonResult.getName());
            context.startActivity(descriptionIntent);
        });

    }

    @Override
    public int getItemCount() {
        return this.pokemonResultList.size();
    }

    public void addPokemon(List<PokemonResult> pokemonResults) {
        this.pokemonResultList = pokemonResults;
        notifyDataSetChanged();
    }

}
