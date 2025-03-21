package net.weg.produtosestoque.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Data
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false , unique = true)
    private String nome;

    private String descricao;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany( mappedBy = "categoria" )
    private List<Produto> produtos;
}
