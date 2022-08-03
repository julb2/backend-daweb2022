package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface RepositorioFacultad extends PagingAndSortingRepository<Facultad, Integer> {
    List<Facultad> findByNombreContainingIgnoreCase(String nombre, Pageable pagina);
}
