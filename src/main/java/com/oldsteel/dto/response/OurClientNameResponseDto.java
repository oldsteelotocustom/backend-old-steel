package com.oldsteel.dto.response;


import com.oldsteel.entity.OurClient;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class OurClientNameResponseDto {

    private String ourClientName;

    public static OurClientNameResponseDto dataFrom(OurClient ourClient){
        var clientResponse = new OurClientNameResponseDto();
        clientResponse.setOurClientName(ourClient.getOurClientName());
        return clientResponse;
    }
}
