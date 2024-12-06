package net.weg.produtosestoque.service;

import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.Categoria;
import net.weg.produtosestoque.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository repository;

    public List<Categoria> buscarTodasCategorias() {
        return repository.findAll();
    }

    public Categoria criarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria buscarCategoria(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new IllegalArgumentException("Categoria não encontrada");
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria) {
        categoria.setId(id);
        return criarCategoria(categoria);
    }

    public void deletarCategoria(Integer id) {
        repository.deleteById(id);
    }
}
