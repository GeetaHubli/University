package com.allstate.respositories;

import com.allstate.entities.Klass;
import org.springframework.data.repository.CrudRepository;

public interface IKlassRepository extends CrudRepository<Klass, Integer>{
    public Klass findByName(String name);
}
