package ensa.pay.service;

import ensa.pay.Repository.AgencyRepository;
import ensa.pay.Repository.AgentRepository;
import ensa.pay.models.Agency;
import ensa.pay.models.Agent;
import ensa.pay.models.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private AgentRepository agentRepository;

    public Agency saveOrUpdate(Agency agency){

        return this.agencyRepository.save(agency);
    }

    public List<Agency> getAll(){
        return this.agencyRepository.findAll();
    }

    public Agency findById(String id){
        return this.agencyRepository.findById(id).orElse(new Agency());
    }

    public void delete(String id){
        this.agencyRepository.deleteById(id);
    }

    public Agency findByPhoneNumber(String phoneNumber){
        Agent agent =  this.agentRepository.findByPhoneNumber(phoneNumber);
        return agencyRepository.findById(agent.getId_agence()).orElse(null);

    }

}
