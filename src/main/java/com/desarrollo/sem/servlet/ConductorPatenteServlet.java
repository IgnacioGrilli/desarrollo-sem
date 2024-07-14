package com.desarrollo.sem.servlet;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.sem.model.ConductorPatente;
import com.desarrollo.sem.model.Patente;
import com.desarrollo.sem.service.ConductorPatenteService;
import com.desarrollo.sem.service.PatenteService;
import com.desarrollo.sem.service.UsuarioConductorService;

@RestController
@RequestMapping("conductorPatente")
public class ConductorPatenteServlet {

    // ConductorPatente conductorPataux;

    @Autowired
    private ConductorPatenteService service;
    
     @Autowired
    private PatenteService patenteService;


    @Autowired
    private UsuarioConductorService condService;


    @PostMapping("/new")
    public ConductorPatente create(@RequestBody ConductorPatente conductorPatente) {
        try {
            // Verificar si la patente existe
            Patente patente = patenteService.findByNumero(conductorPatente.getPatente().getNumero());
    
            // Si no existe, crearla
            if (patente == null) {
                patente = new Patente();
                patente.setNumero(conductorPatente.getPatente().getNumero());
                patente = patenteService.save(patente);
            }
    
            // Verificar si ya existe la relación entre conductor y patente
            ConductorPatente existingCP = service.findByConductorAndPatente(
                    conductorPatente.getConductor(), patente);
    
            if (existingCP != null) {
                // Aquí puedes manejarlo de acuerdo a tu lógica (lanzar excepción, actualizar, etc.)
                // En este ejemplo, se lanza una excepción indicando que ya existe la relación
                throw new RuntimeException("La relación entre conductor y patente ya existe.");
            }
    
            // Asignar la patente al conductorPatente
            conductorPatente.setPatente(patente);
    
            // Guardar conductorPatente
            return service.save(conductorPatente);
        } catch (NonUniqueResultException e) {
            // Manejar la excepción de NonUniqueResultException aquí
            // Puedes registrar un mensaje de error o lanzar una excepción más específica según tu necesidad
            throw new RuntimeException("Error al crear la relación entre conductor y patente.", e);
        }
    }
    

    @GetMapping("/all")
    public List<ConductorPatente> findAll() {
        return service.findAll();

    }

    @GetMapping("/patUsuario/{mail}") 
    public List<Patente> findPatentesUsuario(@PathVariable String mail) {
       return service.findByCondId(condService.findByMail(mail));

    }
    
      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Registro eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el registro.");
        }
    
    } 

    // Nuevo método para encontrar ConductorPatente por ID del conductor
    @GetMapping("/byConductor/{conductorId}")
    public List<ConductorPatente> findByConductorId(@PathVariable Long conductorId) {
        return service.findByConductorId(conductorId);
    }

}
