package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/jugadores")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorJugador {
    private ServicioJugador servicio;

    public ControladorJugador(ServicioJugador servicio) {
        this.servicio=servicio;
    }

    //GET todos
    @RequestMapping
    public Iterable<Jugador> getJugadores(){
        return this.servicio.getJugadores();
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Jugador getJugadores(@PathVariable("id") Integer id){
        return this.servicio.getJugadores(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Jugador guardar(@RequestBody Jugador j){
        return this.servicio.guardar(j);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Jugador actualizar(@RequestBody Jugador j){
        return this.servicio.actualizar(j);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }

    //GET filtro textual
    @RequestMapping(value = "/texto", params = {"texto"})
    public Iterable<Jugador> getJugadoresTexto(@RequestParam(name = "texto") String texto){
        return this.servicio.getJugadoresTexto(texto);
    }

    //GET filtro combos
    @RequestMapping(value = "/combos", params = {"disciplina","facultad","nacionalidad"})
    public Iterable<Jugador> getJugadoresCombo(@RequestParam(name = "disciplina") String dis, @RequestParam(name = "facultad") String fac, @RequestParam(name = "nacionalidad") String nac){
        log.info(dis, fac, nac);
        return this.servicio.getJugadoresCombo(dis, fac, nac);
    }

    // GET filtro combinado
    @RequestMapping(value = "/filtros", params = {"disciplina","facultad","nacionalidad","texto"})
    public Iterable<Jugador> getJugadores(@RequestParam(name = "disciplina") String dis, @RequestParam(name = "facultad") String fac, @RequestParam(name = "nacionalidad") String nac, @RequestParam(name = "texto") String texto){
        log.info(dis, fac, nac, texto);
        return this.servicio.getJugadores(dis, fac, nac, texto);
    }
}
