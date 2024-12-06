package net.weg.produtosestoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fabricante {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @OneToMany( mappedBy = "fabricante" )
    private List<Produto> produtos;
}
