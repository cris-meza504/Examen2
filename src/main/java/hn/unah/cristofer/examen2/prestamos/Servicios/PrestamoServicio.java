package hn.unah.cristofer.examen2.prestamos.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.cristofer.examen2.prestamos.Modelos.Cliente;
import hn.unah.cristofer.examen2.prestamos.Modelos.Prestamo;
import hn.unah.cristofer.examen2.prestamos.Repositorios.ClienteRepositorio;
import hn.unah.cristofer.examen2.prestamos.Repositorios.PrestamosRepositorio;

@Service
public class PrestamoServicio {
    
    @Autowired
    private PrestamosRepositorio prestamosRepositorio;

    private ClienteRepositorio clienteRepositorio;

    public Prestamo crearPrestamos(String codigo, Prestamo prestamo){
        if (this.clienteRepositorio.existsById(codigo)) {
            Cliente cliente = this.clienteRepositorio.findById(codigo).get();
            if (cliente.getPrestamo().size() > 2) {
                return null;
            }else{
                prestamo.setCliente(cliente);
                this.clienteRepositorio.save(cliente);
                return this.prestamosRepositorio.save(prestamo);
            }
        }else{
            return null;
        }
    }

}
