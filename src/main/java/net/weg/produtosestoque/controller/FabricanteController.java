package net.weg.produtosestoque.controller;


import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.Fabricante;
import net.weg.produtosestoque.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
@AllArgsConstructor
public class FabricanteController {

    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> buscarTodosFabricantes() {
        try {
            return new ResponseEntity<>( service.buscarTodosFabricantes() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Fabricante> criarFabricante( @RequestBody Fabricante fabricante) {
        try {
            fabricante = service.criarFabricante(fabricante);
            return new ResponseEntity<>( fabricante , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscarFabricante( @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarFabricante(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> atualizarFabricante( @PathVariable Integer id, @RequestBody Fabricante fabricante) {
        try {
            fabricante = service.atualizarFabricante(id, fabricante);
            return new ResponseEntity<>( fabricante , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFabricante( @PathVariable Integer id) {
        try {
            service.deletarFabricante(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
