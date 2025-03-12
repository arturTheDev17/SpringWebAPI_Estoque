package net.weg.produtosestoque.service;

import lombok.AllArgsConstructor;
import net.weg.produtosestoque.DuplicateEntryException;
import net.weg.produtosestoque.model.dto.ProdutoPostRequestDTO;
import net.weg.produtosestoque.model.entity.Categoria;
import net.weg.produtosestoque.model.entity.Fabricante;
import net.weg.produtosestoque.model.entity.Produto;
import net.weg.produtosestoque.repository.CategoriaRepository;
import net.weg.produtosestoque.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;
    private CategoriaService categoriaService;
    private FabricanteService fabricanteService;

    public Produto criarProduto(ProdutoPostRequestDTO produtoDto) {
        if ( repository.existsByNome(produtoDto.getNome()) ) {
            throw new IllegalArgumentException
                    ("Já existe um produto com o nome " + produtoDto.getNome());
        }
        Fabricante fabricante = fabricanteService.buscarFabricante( produtoDto.getFabricanteId() );
        Produto produto = produtoDto.converter( fabricante );
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

    public Page<Produto> buscarTodosProdutos(Pageable pageable) {
        return repository.findAll( pageable );
    }

    public Page<Produto> getProdutosPorIdCategoria( Pageable pageable , Integer categoriaId ) {
        Categoria categoria = categoriaService.buscarCategoria( categoriaId );
        return repository.findByCategoria( pageable , categoria );
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
