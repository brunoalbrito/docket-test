package br.com.docket.cartorio.dto;

import br.com.docket.cartorio.model.Cartorio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
//@JsonIgnoreProperties(value = {"id"})
public class CartorioDTO {

    @NotNull
    private long id;

    @NotNull
    private String nome;

    protected CartorioDTO(@NotNull String nome) {
        this.nome = nome;
    }

    public CartorioDTO() {

    }

    public static CartorioDTO of(Cartorio cartorio){
        return new CartorioDTO(cartorio.getNome());
    }

    public static Cartorio convertToDtoWithId(Cartorio cartorio){
        return new Cartorio(cartorio.getId(), cartorio.getNome());
    }
}
