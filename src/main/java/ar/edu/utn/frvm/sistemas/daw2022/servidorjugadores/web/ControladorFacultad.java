package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioFacultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@Slf4j
@RequestMapping(value = "/facultades")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorFacultad {

    private ServicioFacultad servicio;

    public ControladorFacultad(ServicioFacultad servicio) {
        this.servicio=servicio;
    }

    //GET todos
    @RequestMapping
    public Iterable<Facultad> getFacultades() {
        return this.servicio.getFacultades();
    }

    @RequestMapping(params = {"page"})
    public Page<Facultad> getFacultades(Pageable pagina) {
        return this.servicio.getFacultades(pagina);
    }

    @RequestMapping(params = {"filtro","pag"})
    public Iterable<Facultad> getFacultades(@RequestParam(name = "filtro") String filtro, @RequestParam(name = "pag") String pag) {
        Pageable pageable = PageRequest.of(Integer.parseInt(pag), 2);
        //log.info(String.valueOf(pageable), filtro);
        return this.servicio.getFacultades(filtro, pageable);
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Facultad getFacultad(@PathVariable("id") Integer id) {
        return this.servicio.getFacultad(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Facultad guardar(@RequestBody Facultad f){
        return this.servicio.guardar(f);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Facultad actualizar(@RequestBody Facultad f){
        return this.servicio.actualizar(f);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }
}
