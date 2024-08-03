package hn.unah.cristofer.examen2.prestamos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.cristofer.examen2.prestamos.Modelos.Cuotas;

@Repository
public interface CuotasRepositorio extends JpaRepository<Cuotas,Long>{
    
}
