package com.apiregistro2022.restcontroller;

import com.apiregistro2022.entity.Producto;
import com.apiregistro2022.service.ProductoService;
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

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/custom")
    public List<Producto> findAllCustom() {
        return productoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public Producto add(@RequestBody Producto p) {
        return productoService.add(p);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        p.setCodigo(id);
        return productoService.update(p);
    }
    
    @DeleteMapping("/{id}")
    public Producto delete(@PathVariable Long id){
        Producto objproducto= new Producto();
        objproducto.setCodigo(id);
        return productoService.delete(objproducto);
    }
    

}
