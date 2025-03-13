package net.weg.produtosestoque.repository;

import net.weg.produtosestoque.model.entity.Categoria;
import net.weg.produtosestoque.model.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutoRepository extends JpaRepository<Produto , Integer> , JpaSpecificationExecutor<Produto> {

    Page<Produto> findByCategoria(Pageable pageable, Categoria categoria);

    boolean existsByNome(String nome);


}
