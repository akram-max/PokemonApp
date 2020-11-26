package bourichi.akram.tp5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bourichi.akram.tp5.model.Pokemon;
import bourichi.akram.tp5.model.PokemonResume;

import java.util.List;

import com.bumptech.glide.Glide;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> mPokemons;
    private Context context;

    public RecyclerViewAdapter(List<Pokemon> mPokemons, Context context) {
        this.mPokemons = mPokemons;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.firstName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact,parent,false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = mPokemons.get(position);
        TextView firstNameTextView = holder.firstNameTextView;
        if (pokemon != null){
            firstNameTextView.setText(pokemon.getName());
            ImageView imageView = holder.imageView;
            System.out.println(pokemon.getSprites().getFrontShiny());
            if (pokemon.getSprites() != null){
                Glide.with(context).load(pokemon.getSprites().getFrontShiny()).into(imageView);
            }
        }


    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }
}