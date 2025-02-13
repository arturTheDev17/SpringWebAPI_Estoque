package net.weg.produtosestoque.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaPostRequestDTO(
        @NotBlank String nome,
        String descricao) {
}
