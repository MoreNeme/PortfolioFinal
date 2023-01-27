package com.portfolio.mnc.Interface;

import com.portfolio.mnc.entity.Persona;
import java.util.List;

public interface IPersonaServicio {
//Traer Lista de persona
public List <Persona>getPersona();

//guardar objeto tipo persona
public void savePersona(Persona persona);

//eliminar un objeto persona

public void deletePersona(Long id);


//buscar una persona

public Persona findPersona(Long id);

}
