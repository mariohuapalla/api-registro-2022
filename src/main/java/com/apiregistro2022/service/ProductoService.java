package com.apiregistro2022.service;

import com.apiregistro2022.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    List<Producto> findAllCustom();

    List<Producto> findbyName();

    Optional<Producto> findById(Long id);

    Producto add(Producto p);

    Producto update(Producto p);

    Producto delete(Producto p);
}
