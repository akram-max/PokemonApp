package fr.eilco.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientEvolution {
    private static final String BASE_URL_EVOLUTION = "https://pokeapi.glitch.me/v1/";
    private static Retrofit retrofit;

    private ApiClientEvolution() {}

    public static Retrofit getRetrofitInstance() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL_EVOLUTION)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}