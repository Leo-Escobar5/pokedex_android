package com.almaralengineering.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PokemonListAdapter extends ArrayAdapter<Pokemon> {
    private Context context;
    private ArrayList<Pokemon> pokemonList;
    private int layoutId;

    public PokemonListAdapter(Context context, int resource, ArrayList<Pokemon> pokemonList) {
        super(context, resource, pokemonList);

        this.context = context;
        this.pokemonList = pokemonList;
        layoutId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PokemonViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layoutId, null);

            holder = new PokemonViewHolder();
            holder.pokemonIdTextView = (TextView) convertView.findViewById(R.id.pokemon_list_item_id_textView);
            holder.pokemonNameTextView = (TextView) convertView.findViewById(R.id.pokemon_list_item_name_textView);
            holder.pokemonTypeImageView = (ImageView) convertView.findViewById(R.id.pokemon_list_item_type_image);

            convertView.setTag(holder);
        } else {
            holder = (PokemonViewHolder) convertView.getTag();
        }

        Pokemon pokemon = pokemonList.get(position);

        holder.pokemonIdTextView.setText(String.valueOf(pokemon.getId()));
        holder.pokemonNameTextView.setText(pokemon.getName());

        final Pokemon.Type type = pokemon.getType();

        switch (type) {
            case FIRE:
                holder.pokemonTypeImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.fire));
                break;
            case WATER:
                holder.pokemonTypeImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.water));
                break;
            case PLANT:
                holder.pokemonTypeImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.plant));
                break;
            case ELECTRIC:
                holder.pokemonTypeImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.electric));
                break;
        }

        return convertView;
    }

    private class PokemonViewHolder {
        public TextView pokemonIdTextView;
        public TextView pokemonNameTextView;
        public ImageView pokemonTypeImageView;
    }
}
