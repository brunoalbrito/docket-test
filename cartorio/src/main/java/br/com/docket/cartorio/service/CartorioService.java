package br.com.docket.cartorio.service;

import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository repository;

    public Iterable<Cartorio> findAll() {
        return repository.findAll();
    }

    public Optional<Cartorio> findById(@NotNull long id) {
        return repository.findById(id);
    }

    public Cartorio save(Cartorio cartorio) {
        return repository.save(cartorio);
    }

    public void delete(Cartorio cartorio) {
        repository.delete(cartorio);
    }
}
