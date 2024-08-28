package br.com.praticandoexercicio.livros.service;

import br.com.praticandoexercicio.livros.entities.Livro;
import br.com.praticandoexercicio.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //Declarar o método save
    public String save (Livro livro){
        this.livroRepository.save(livro);
        return "Livro salvo com sucesso!";

    }

    public Livro findById(Long id){ //Recebo um id inteiro mais retorno um livro
      Livro livro = this.livroRepository.findById(id).get();
      return livro;
    }

    public List<Livro> findAll(){
        List<Livro> livro = new ArrayList<>();

        Livro livros = new Livro();
        livros.setId(1);
        livros.setTitulo("Livro 2");
        livros.setAno(1950);
        livros.setAutor("Maria Silva");
        livros.setEditora("Abril");

        livro.add(livros);
        livros = new Livro();
        livros.setId(2);
        livros.setTitulo("Livro 3");
        livros.setAno(1950);
        livros.setAutor("Maria Silva");
        livros.setEditora("Abril");
        livro.add(livros);

        return livro;
    }

    public Livro update(Livro livro,Long id){

        Livro updateLivro = findById(id);
        livro.setId(livro.getId());
        livro.setTitulo(livro.getTitulo());
        livro.setAno(livro.getAno());
        livro.setAutor(livro.getAutor());
        livro.setEditora(livro.getEditora());
        return livro;
    }
}
