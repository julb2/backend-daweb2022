package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class ServicioJugador {
    private RepositorioJugador repositorio;

    public ServicioJugador(RepositorioJugador repositorio){
        this.repositorio=repositorio;
    }

    public Jugador getJugadores(Integer id){
        Optional<Jugador> rta = this.repositorio.findById(id);
        if(rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Jugador> getJugadores(){
        return this.repositorio.findAll();
    }


    public Jugador guardar(Jugador j) {
        return this.repositorio.save(j);
    }

    public Jugador actualizar(Jugador j) {
        return this.repositorio.save(j);
    }

    public void eliminar(Integer id){
        this.repositorio.deleteById(id);
    }

    public Iterable<Jugador> getJugadoresTexto(String texto){
        return this.repositorio.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(texto, texto);
    }
    public Iterable<Jugador> getJugadoresCombo(String dis, String fac, String nac){
        return this.repositorio.findByDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContaining(dis, fac, nac);
    }

    public Iterable<Jugador> getJugadores(String texto, String dis, String fac, String nac){
        return this.repositorio.findByNombreContainingIgnoreCaseAndDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContainingOrApellidoContainingIgnoreCaseAndDisciplina_NombreContainingAndFacultad_NombreContainingAndNacionalidad_NombreContaining(texto, dis, fac, nac, texto, dis, fac, nac);
    }
}
