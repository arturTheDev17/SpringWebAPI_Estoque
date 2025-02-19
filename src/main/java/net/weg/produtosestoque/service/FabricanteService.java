package net.weg.produtosestoque.service;

import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.entity.Fabricante;
import net.weg.produtosestoque.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FabricanteService {

    private FabricanteRepository repository;

    public List<Fabricante> buscarTodosFabricantes() {
        return repository.findAll();
    }

    public Fabricante criarFabricante(Fabricante fabricante) {
        return repository.save(fabricante);
    }

    public Fabricante buscarFabricante(Integer id) {
        Optional<Fabricante> fabricante = repository.findById(id);
        return fabricante.get();

    }

    public Fabricante atualizarFabricante(Integer id, Fabricante fabricante) {
        fabricante.setId(id);
        return criarFabricante(fabricante);
    }

    public void deletarFabricante(Integer id) {
        repository.deleteById(id);
    }

}
