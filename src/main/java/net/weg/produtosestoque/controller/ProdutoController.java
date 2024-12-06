package net.weg.produtosestoque.controller;


import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.Produto;
import net.weg.produtosestoque.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/products")
@RestController
public class ProdutoController {

    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        try {
            return new ResponseEntity<>( service.buscarTodosProdutos() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto( @RequestBody Produto produto) {
        try {
            produto = service.criarProduto(produto);
            return new ResponseEntity<>( produto , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto( @PathVariable Integer id) {
        try {
            return new ResponseEntity<>( service.buscarProduto(id) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto( @PathVariable Integer id, @RequestBody Produto produto) {
        try {
            produto = service.atualizarProduto(id, produto);
            return new ResponseEntity<>( produto , HttpStatus.OK);
        } catch ( Exception e ) {
            System.out.println( e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto( @PathVariable Integer id) {
        try {
            service.deletarProduto(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
