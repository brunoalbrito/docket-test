package br.com.docket.cartorioweb.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cartorio {

    private Long id;

    private String nome;

    protected Cartorio() {

    }

    private Cartorio(final Long id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cartorio of(final long id, final String nome) {
        return new Cartorio(id, nome);
    }
}
