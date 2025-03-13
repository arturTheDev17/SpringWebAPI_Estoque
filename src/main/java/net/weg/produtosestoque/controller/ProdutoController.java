package net.weg.produtosestoque.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.dto.ProdutoPostRequestDTO;
import net.weg.produtosestoque.model.entity.Produto;
import net.weg.produtosestoque.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<Produto>> buscarTodosProdutos(
            @PageableDefault(
                    page = 1,
                    size = 5,
                    sort = "nome",
                    direction = Sort.Direction.DESC
            )
            Pageable pageable) {
        try {
            return new ResponseEntity<>( service.buscarTodosProdutos(pageable) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Produto>> filtrado(
            @RequestParam String texto
    ) {
        try {
            return new ResponseEntity<>(service.buscarFiltrado( texto ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Produto>> getProdutosPorIdCategoria(@PathVariable(name = "id" ) Integer categoriaId,
                                                                   @PageableDefault(
                                                                           size = 15,
                                                                           page = 2,
                                                                           sort = "nome",
                                                                           direction = Sort.Direction.ASC
                                                                   ) Pageable pageable ) {
        try {
            Page<Produto> produtos = service.getProdutosPorIdCategoria( pageable , categoriaId);
            return new ResponseEntity<>(produtos , HttpStatus.OK);
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
            System.out.println( e.getMessage() );
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
