package com.oldsteel.service;

import com.oldsteel.entity.OurClient;
import com.oldsteel.repository.OurClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OurClientService {

    private final OurClientRepository clientRepository;

    public OurClient saveClient(OurClient client){
        return clientRepository.save(client);
    }

    public List<OurClient> getAllOurClient(){
        return clientRepository.findAll();
    }
}
