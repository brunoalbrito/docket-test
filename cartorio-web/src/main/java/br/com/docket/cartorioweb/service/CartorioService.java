package br.com.docket.cartorioweb.service;


import br.com.docket.cartorioweb.model.Cartorio;
import br.com.docket.cartorioweb.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private Retrofit retrofit;

    private CartorioRepository repository;

    @PostConstruct
    private void setup() {
        repository = retrofit.create(CartorioRepository.class);
    }

    public Iterable<Cartorio> findAll() {
        Iterable cartorios = Collections.emptyList();
        try {
            cartorios = repository.findAll().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartorios;
    }

    public Optional<Cartorio> findById(Long id) {
        Optional<Cartorio> cartorio = Optional.empty();
        try {
            cartorio = Optional.of(repository.findById(id).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartorio;
    }

    public void delete(Cartorio cartorio) {
        try {
            repository.delete(cartorio).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(Cartorio cartorio) {
        try {
            repository.save(cartorio).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(Cartorio cartorio) {
        try {
            repository.edit(cartorio).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
