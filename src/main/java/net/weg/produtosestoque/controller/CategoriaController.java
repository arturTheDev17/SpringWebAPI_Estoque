package net.weg.produtosestoque.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.dto.CategoriaPostRequestDTO;
import net.weg.produtosestoque.model.entity.Categoria;
import net.weg.produtosestoque.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoriaController {

    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodasCategorias() {
        try {
            return new ResponseEntity<>( service.buscarTodasCategorias() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria( @RequestBody @Valid CategoriaPostRequestDTO categoriaDTO) {
        try {
            Categoria categoria = service.criarCategoria(categoriaDTO);
            return new ResponseEntity<>( categoria , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria( @PathVariable Integer id) {
        try {
            return new ResponseEntity<>( service.buscarCategoria(id) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria( @PathVariable Integer id, @RequestBody Categoria categoria) {
        try {
            categoria = service.atualizarCategoria(id, categoria);
            return new ResponseEntity<>( categoria , HttpStatus.OK);
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria( @PathVariable Integer id) {
        try {
            service.deletarCategoria(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
