package net.weg.produtosestoque.service;

import lombok.AllArgsConstructor;
import net.weg.produtosestoque.model.dto.ProdutoPostRequestDTO;
import net.weg.produtosestoque.model.entity.Produto;
import net.weg.produtosestoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;

    public Produto criarProduto(ProdutoPostRequestDTO produtoDto) {
        if ( repository.existsByNome(produtoDto.getNome()) ) {
            throw new IllegalArgumentException
                    ("Já existe um produto com o nome " + produtoDto.getNome());
        }
        Produto produto = produtoDto.converter();
//        if ( produto.getPreco() <= 0 ) {
//            throw new IllegalArgumentException
//                    ("O preço do produto deve ser maior que zero");
//        }
//
//        if ( produto.getQuantidade() < 0 ) {
//            throw new IllegalArgumentException
//                    ("A quantidade do produto não pode ser negativa");
//        }

        return repository.save(produto);
    }

    public List<Produto> buscarTodosProdutos() {
        return repository.findAll();
    }

    public Produto buscarProduto(Integer id) {

        Optional<Produto> produto = repository.findById(id);
        if ( produto.isPresent() ) {
            //colocar aqui o DTO
            return produto.get();
        }
        throw new IllegalArgumentException("Produto não encontrado");
    }

    public Produto atualizarProduto(Integer id, Produto produto) {
        produto.setId(id);
        //return criarProduto(produto);
        return repository.save(produto);
    }

    public void deletarProduto(Integer id) {
        repository.deleteById(id);
    }
}
