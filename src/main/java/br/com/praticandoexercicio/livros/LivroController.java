package br.com.praticandoexercicio.livros;

import br.com.praticandoexercicio.livros.entities.Livro;
import br.com.praticandoexercicio.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livro livro) {
        //Tentar salvar? Tente Try
        try {
            String mensagem = this.livroService.save(livro);
            //Chama a service, o método save e retorna uma mensaagem
        return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        //Algo deu errado? Catch nele
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu algo errado ao salvar",HttpStatus.BAD_REQUEST);

        }

    }
@GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable int id){
       try {
         Livro livro = this.livroService.findById(id); // Retornar o livro
           return new ResponseEntity<>(livro,HttpStatus.OK);


       }catch(Exception e ){
           return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        try {
            List livro = this.livroService.findAll();
            return new ResponseEntity<>(livro,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> update(@RequestBody Livro livro, @PathVariable int id){
        try {
            Livro updateLivro = this.livroService.update(livro,id);
            return new ResponseEntity<>(updateLivro,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}