package net.weg.produtosestoque.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.produtosestoque.model.entity.Categoria;
import net.weg.produtosestoque.model.entity.Fabricante;
import net.weg.produtosestoque.model.entity.Produto;

import java.util.Date;
@AllArgsConstructor
@Data
public class ProdutoPostRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Date data_validade;

    @Positive
    @NotNull
    private Double preco;

    @PositiveOrZero
    private int quantidade;

    @NotBlank
    private String descricao;

    @NotBlank
    private String codigo_barras;

    @NotNull
    private Double peso;

    @NotNull
    private Double medida;

//    @NotNull
    private Integer fabricanteId;

//    @NotNull
    private Categoria categoria;

    public Produto converter( Fabricante fabricante ) {
        return Produto.builder().nome(this.nome)
                .data_validade(this.data_validade).preco(this.preco)
                .quantidade(this.quantidade).descricao(this.descricao)
                .codigo_barras(this.codigo_barras).peso(this.peso)
                .medida(this.medida).fabricante(fabricante).categoria(this.categoria)
                .build();
    }
}
