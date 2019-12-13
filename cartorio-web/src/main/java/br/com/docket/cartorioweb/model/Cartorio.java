package br.com.docket.cartorioweb.model;


import lombok.Getter;

@Getter
public class Cartorio {

    private final long id;

    private final String nome;

    private Cartorio(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cartorio of(final long id, final String nome) {
        return new Cartorio(id, nome);
    }
}
