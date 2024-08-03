package hn.unah.cristofer.examen2.prestamos.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.cristofer.examen2.prestamos.Modelos.Prestamo;
import hn.unah.cristofer.examen2.prestamos.Servicios.PrestamoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @PostMapping("/crear/{codigo}")
    public Prestamo crearPrestamo(@PathVariable(name = "codigo") String codigo,@RequestBody Prestamo prestamo) {
        
        return this.prestamoServicio.crearPrestamos(codigo, prestamo);
    } 
}
