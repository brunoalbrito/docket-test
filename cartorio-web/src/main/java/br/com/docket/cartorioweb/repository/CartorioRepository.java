package br.com.docket.cartorioweb.repository;

import br.com.docket.cartorioweb.model.Cartorio;
import retrofit2.Call;
import retrofit2.http.*;

public interface CartorioRepository {

    @GET("cartorio")
    Call<Iterable<Cartorio>> findAll();

    @POST("cartorio")
    Call<Void> save(@Body Cartorio cartorio);

    @GET("cartorio/{id}")
    Call<Cartorio> findById(@Path("id") Long id);

    @HTTP(method = "DELETE", path = "/cartorio", hasBody = true)
    Call<Void> delete(@Body Cartorio cartorio);

    @PUT("cartorio")
    Call<Void> edit(@Body Cartorio cartorio);
}
