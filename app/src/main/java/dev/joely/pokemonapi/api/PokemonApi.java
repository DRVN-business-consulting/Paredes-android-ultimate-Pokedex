package dev.joely.pokemonapi.api;

import dev.joely.pokemonapi.dto.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface PokemonApi {

    @GET("pokemon")
    Call<List<Pokemon>> getPokemonList(@Header("Authorization") String authHeader);
}
