package net.weg.produtosestoque.repository;

import net.weg.produtosestoque.model.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


    boolean existsByNome(String nome);
}
