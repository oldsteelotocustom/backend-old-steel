package com.oldsteel.controller;

import com.oldsteel.dto.request.OurClientRequestDto;
import com.oldsteel.dto.response.OurClientNameResponseDto;
import com.oldsteel.entity.OurClient;
import com.oldsteel.helper.ErrorMessages;
import com.oldsteel.service.OurClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/our-client")
@RequiredArgsConstructor
@Slf4j
public class OurClientController {

    private final OurClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?> saveOurClientName(@RequestBody @Valid OurClientRequestDto clientRequestDto, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(ErrorMessages.throwError(errors), HttpStatus.BAD_REQUEST);
        }
        var client = clientService.saveClient(OurClient.saveFrom(clientRequestDto));
        return new ResponseEntity<>("Our client name saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientName(){
        var clients = clientService.getAllOurClient();
        if(clients.isEmpty()){
            return new ResponseEntity<>("Client is not found...", HttpStatus.NOT_FOUND);
        }
        List<OurClientNameResponseDto> clientResponses = new ArrayList<>();
        for (OurClient ourClient: clients) {
            clientResponses.add(OurClientNameResponseDto.dataFrom(ourClient));
        }
        return new ResponseEntity<>(clientResponses, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateClientName(@RequestBody @Valid OurClientRequestDto ourClientRequestDto,
                                              @RequestParam(required = true) Long clientId,
                                              Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(ErrorMessages.throwError(errors), HttpStatus.BAD_REQUEST);
        }
        var clientName = clientService.editName(ourClientRequestDto.getOurClientName(), clientId);
        log.info("Clien name is: {}", clientName.getOurClientName());
        return new ResponseEntity<>("Edit name done successfully to: " + clientName.getOurClientName(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable("id") long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Delete our client name successfully", HttpStatus.OK);
    }
}
