package fr.eilco.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fr.eilco.listener.ClickListener;
import fr.eilco.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import fr.eilco.model.GenerationResult;

public class GenerationRVAdapter extends RecyclerView.Adapter<GenerationRVAdapter.ViewHolder> {

    private List<GenerationResult> generationResults = new ArrayList<>();
    private final Context context;
    private final ClickListener listener;

    public GenerationRVAdapter(Context context, final ClickListener listener) {
        super();
        this.context = context;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ClickListener listener;
        ImageView imageViewGen;
        TextView textViewGen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewGen = itemView.findViewById(R.id.generation_img);
            textViewGen = itemView.findViewById(R.id.generation_name);
            imageViewGen.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.iconImageViewOnClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.generation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenerationRVAdapter.ViewHolder holder, int position) {
        GenerationResult generationResult = this.generationResults.get(position);
        Glide.with(context)
                .load("https://pngimg.com/uploads/pokeball/pokeball_PNG21.png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewGen);
        holder.textViewGen.setText(getGenName(generationResult.getName()));

        // Initialize listener
        holder.listener = this.listener;

    }

    @Override
    public int getItemCount() {
        return generationResults.size();
    }

    public void addGeneration(List<GenerationResult> generationResults) {
        this.generationResults = generationResults;
        notifyDataSetChanged();
    }

    private String getGenName(String baseName) {
        String newName = "";
        switch (baseName) {
            case "generation-i":
                newName = "Gen 1";
                break;
            case "generation-ii":
                newName = "Gen 2";
                break;
            case "generation-iii":
                newName = "Gen 3";
                break;
            case "generation-iv":
                newName = "Gen 4";
                break;
            case "generation-v":
                newName = "Gen 5";
                break;
            case "generation-vi":
                newName = "Gen 6";
                break;
            case "generation-vii":
                newName = "Gen 7";
                break;
            case "generation-viii":
                newName = "Gen 8";
                break;
        }
        return newName;
    }
}
