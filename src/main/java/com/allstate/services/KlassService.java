package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.respositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {

    private IKlassRepository iKlassRepository;

    @Autowired
    public  void setKlassRepository(IKlassRepository iKlassRepository){
        this.iKlassRepository = iKlassRepository;
    }

    public Klass create(Klass klass) {
        return this.iKlassRepository.save(klass);
    }

    public Klass findById(int id) {
        return this.iKlassRepository.findOne(id);
    }

    public Klass findByName(String name) {
        return this.iKlassRepository.findByName(name);
    }
}
