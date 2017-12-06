package edu.dongguk.moodlight.service;

import edu.dongguk.moodlight.domain.Diffuser;
import edu.dongguk.moodlight.mapper.DiffuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiffuserService {

    private DiffuserMapper diffuserMapper;

    @Autowired
    DiffuserService(DiffuserMapper diffuserMapper){
        this.diffuserMapper = diffuserMapper;
    }

    public void addDiffuser(Diffuser diffuser){
        diffuserMapper.insertDiffuser(diffuser);
    }

    public void addDiffusers(String token, Diffuser[] diffusers){
        if(diffusers.length == 0){
            return;
        }

        for(Diffuser diffuser : diffusers) {
            diffuser.setToken(token);
            addDiffuser(diffuser);
        }
    }

    public void modifyDiffuser(Diffuser diffuser){
        diffuserMapper.updateDiffuser(diffuser);
    }
}
