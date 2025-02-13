package net.weg.produtosestoque.service;

import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.dto.CategoriaPostRequestDTO;
import net.weg.produtosestoque.model.entity.Categoria;
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

    public Categoria criarCategoria(CategoriaPostRequestDTO categoriaDTO) {
        if (repository.existsByNome(categoriaDTO.nome())) {
            throw new IllegalArgumentException("Já existe uma categoria com o nome " + categoriaDTO.nome());
        }
        Categoria categoria = categoriaDTO.converter();
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
        return repository.save(categoria);
    }

    public void deletarCategoria(Integer id) {
        repository.deleteById(id);
    }
}
