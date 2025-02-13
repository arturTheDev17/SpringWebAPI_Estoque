package net.weg.produtosestoque.model.dto;

import jakarta.validation.constraints.NotBlank;
import net.weg.produtosestoque.model.entity.Categoria;

/**
 * A utilidade de uma record em uma api rest é ser um molde para consumo de objetos recebidos pela api,
 * mas não deve ser usado no retorno do banco de dados, ficando mais restingido nas controllers
 **/

public record CategoriaPostRequestDTO(
        @NotBlank String nome,
        String descricao) {
    public Categoria converter() {
        return Categoria.builder().nome(this.nome).descricao(this.descricao).build();
    }
}
