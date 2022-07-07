package com.apiregistro2022.restcontroller;

import com.apiregistro2022.entity.Categoria;
import com.apiregistro2022.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//agregamos la anotacion para que sea un controlador

@RestController
//agregamos el nombre con el cual se va a buscar el controlador rest
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //para poder obtener valores utilizamos la anotacion GetMapping
    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/custom")
    public List<Categoria> findAllCustom() {
        return categoriaService.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    //enviar valores
    @PostMapping
    public Categoria add(@RequestBody Categoria c) {
        return categoriaService.add(c);
    }

    //actualizar valores
    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria c) {
        c.setCodigo(id);
        return categoriaService.update(c);
    }

    //eliminar valores
    @DeleteMapping("/{id}")
    public Categoria delete(@PathVariable Long id) {
        Categoria objCategoria= new Categoria();
        objCategoria.setCodigo(id);
        return categoriaService.delete(Categoria.builder().codigo(id).build());
    }
}
