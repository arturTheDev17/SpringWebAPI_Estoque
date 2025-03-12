package net.weg.produtosestoque.model.dto;
import java.time.Instant;
public record ErrorResponseDTO(String mensagem , Instant instant ) {
}
