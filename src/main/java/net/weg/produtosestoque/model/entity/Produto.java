package net.weg.produtosestoque.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date data_validade;

//    @Positive - deve ser manipulado na DTO/Controller

    @Column(nullable = false)
    private Double preco;

//    @PositiveOrZero
    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private String descricao;

    @Column(unique = true)
    private String codigo_barras;

//    @Positive
    @Column(nullable = false)
    private Double peso;

//    @Positive
    @Column(nullable = false)
    private Double medida;

    @ManyToOne( cascade = CascadeType.PERSIST )
//    @JoinColumn(nullable = false)
    private Fabricante fabricante;

    @ManyToOne( cascade = CascadeType.ALL )
//    @JoinColumn(nullable = false)
    private Categoria categoria;
}
