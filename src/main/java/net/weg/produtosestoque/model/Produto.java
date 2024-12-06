package net.weg.produtosestoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Produto {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;


    private Date data_validade;

    @Positive
    private Double preco;

    @PositiveOrZero
    private int quantidade;

    private String descricao;

    private String codigo_barras;

    @Positive
    private Double peso;

    @Positive
    private Double medida;

    @ManyToOne
    private Fabricante fabricante;

    @ManyToOne
    private Categoria categoria;
}
