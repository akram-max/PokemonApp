package fr.eilco.dao.web;


import fr.eilco.model.BaseGeneration;
import fr.eilco.model.Generation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GenerationRepository {

    @GET("generation")
    Call<BaseGeneration> findAll();

    @GET("generation/{id}")
    Call<Generation> findOneById(@Path("id") String id);

    @GET("generation/{name}")
    Call<Generation> findOneByName(@Path("name") String name);
}
