package br.com.docket.cartorioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CartorioDTO {

    private long id;

    @NotBlank(message = "Não deve conter nome em branco")
    private String nome;

    public static CartorioDTO getInstance(){
        return new CartorioDTO();
    }
}
