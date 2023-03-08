package com.oldsteel.entity;

import com.oldsteel.dto.request.OurClientRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class OurClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ourClientName;

    public static OurClient saveFrom(OurClientRequestDto clientRequestDto){
        var ourclient = new OurClient();
        ourclient.setOurClientName(clientRequestDto.getOurClientName());
        return ourclient;
    }
}
