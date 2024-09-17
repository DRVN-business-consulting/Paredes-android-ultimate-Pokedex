package dev.joely.pokemonapi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dev.joely.pokemonapi.R;
import dev.joely.pokemonapi.adapters.PokemonAdapter;
import dev.joely.pokemonapi.api.ApiClient;
import dev.joely.pokemonapi.api.PokemonApi;
import dev.joely.pokemonapi.dto.Pokemon;
import dev.joely.pokemonapi.utils.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class PokemonListFragment extends Fragment {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_pokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fetchPokemonData();
        return view;
    }

    private void fetchPokemonData() {
        TokenManager tokenManager = new TokenManager(getActivity());
        String token = tokenManager.getToken();

        PokemonApi pokemonApi = ApiClient.getClient(getActivity()).create(PokemonApi.class);
        pokemonApi.getPokemonList("Bearer " + token).enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.isSuccessful()) {
                    List<Pokemon> pokemonList = response.body();
                    pokemonAdapter = new PokemonAdapter(pokemonList);
                    recyclerView.setAdapter(pokemonAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
