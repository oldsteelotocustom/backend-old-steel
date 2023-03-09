package com.oldsteel.service;

import com.oldsteel.entity.OurClient;
import com.oldsteel.exception.OurClientNotFountException;
import com.oldsteel.repository.OurClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public OurClient editName(String newName, Long id){
        var client = clientRepository.findById(id);
        client.get().setOurClientName(newName);
        return clientRepository.save(client.get());
    }

    public void deleteClient(Long id) {
        var ourClient = clientRepository.findById(id).orElseThrow
                (() -> new OurClientNotFountException("Client Not Found"));
        if (ourClient != null) {
            clientRepository.deleteById(id);
        }
    }

}
