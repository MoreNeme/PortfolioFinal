
package com.portfolio.mnc.service;

import com.portfolio.mnc.Interface.IPersonaServicio;
import com.portfolio.mnc.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.mnc.repository.IPersonaRepository;

@Service
public class ImpPersonaService implements IPersonaServicio{
    @Autowired IPersonaRepository ipersonarepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona>persona=ipersonarepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona=ipersonarepository.findById(id).orElse(null);
      return persona;
    }
    
}
