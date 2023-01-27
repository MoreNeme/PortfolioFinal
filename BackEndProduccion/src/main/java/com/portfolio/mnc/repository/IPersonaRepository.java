
package com.portfolio.mnc.repository;

import com.portfolio.mnc.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository  <Persona,Long > {
    
}
        