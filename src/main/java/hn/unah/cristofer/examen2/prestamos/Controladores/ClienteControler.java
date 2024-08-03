package hn.unah.cristofer.examen2.prestamos.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.cristofer.examen2.prestamos.Modelos.Cliente;
import hn.unah.cristofer.examen2.prestamos.Servicios.ClienteServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/cliente")
public class ClienteControler {

    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServicio.crearCliente(cliente);
    }

    @GetMapping("/obtener")
    public List<Cliente> obtenerClientes() {
        return this.clienteServicio.obtenerClientes();
    }
    
    
}
