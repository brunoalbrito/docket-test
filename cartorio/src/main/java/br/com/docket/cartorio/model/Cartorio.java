package br.com.docket.cartorio.model;

import br.com.docket.cartorio.dto.CartorioDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    protected Cartorio(){

    }

    public Cartorio(final long id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cartorio of(CartorioDTO dto){
        return new Cartorio(dto.getId(), dto.getNome());
    }

    public void alterInfos(CartorioDTO cartorioDTO) {
        this.nome = cartorioDTO.getNome();
    }
}
