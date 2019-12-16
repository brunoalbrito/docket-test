package br.com.docket.cartorioweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitFactory {

    @Bean
    public Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8090/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
