package net.weg.produtosestoque.repository;

import net.weg.produtosestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto , Integer> {
    boolean existsByNome(String nome);

}
