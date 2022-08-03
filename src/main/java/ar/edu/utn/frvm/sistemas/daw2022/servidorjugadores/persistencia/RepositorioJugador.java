package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {
    Iterable<Jugador> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String texto, String texto2);
    Iterable<Jugador> findByDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContaining(String dis, String fac, String nac);
    Iterable<Jugador> findByNombreContainingIgnoreCaseAndDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContainingOrApellidoContainingIgnoreCaseAndDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContaining(String texto1, String dis1, String fac1, String nac1, String texto2, String dis2, String fac2, String nac2);
}
