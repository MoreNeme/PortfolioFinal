package com.portfolio.mnc.controller;

import com.portfolio.mnc.Interface.IPersonaServicio;
import com.portfolio.mnc.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaServicio ipersonaservicio;
    @GetMapping("personas/traer")
    public List <Persona>getPersona() {
        return ipersonaservicio.getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaservicio.savePersona(persona);
        return "se creo satisfactoriamente la persona";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaservicio.deletePersona(id);
        return "la persona fue eliminada con exito";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre")String nuevoNombre,
                                @RequestParam("apellido")String nuevoApellido,
                                @RequestParam("img")String nuevaImagen){
    Persona persona=ipersonaservicio.findPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevaImagen);
    ipersonaservicio.savePersona(persona);
    return persona;
}
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaservicio.findPersona((long)1);
    }
    
}
