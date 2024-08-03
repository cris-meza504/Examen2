package hn.unah.cristofer.examen2.prestamos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.cristofer.examen2.prestamos.Modelos.Cliente;
import hn.unah.cristofer.examen2.prestamos.Modelos.Prestamo;
import hn.unah.cristofer.examen2.prestamos.Repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente crearCliente( Cliente cliente){
        if (this.clienteRepositorio.existsById(cliente.getDni())) {
            return null;
        }else{
            List<Prestamo> prestamos = cliente.getPrestamo();
            if (prestamos != null) {
                for (Prestamo prestamo : prestamos) {
                    double cuota =(prestamo.getMonto()*(prestamo.getInteres()/12))/(1-(Math.pow((1+(0.09/12)),prestamo.getPlazo()*12)));
                    prestamo.setCuota(cuota);
                    prestamo.setCliente(cliente);
                }
            }

            return this.clienteRepositorio.save(cliente);
        }
    }

    public List<Cliente> obtenerClientes(){
        return this.clienteRepositorio.findAll();
    }
}
