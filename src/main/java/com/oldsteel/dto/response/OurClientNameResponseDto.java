package com.oldsteel.dto.response;


import com.oldsteel.entity.OurClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OurClientNameResponseDto {

    private String ourClientName;

    public static OurClientNameResponseDto dataFrom(OurClient ourClient){
        var clientResponse = new OurClientNameResponseDto();
        clientResponse.setOurClientName(ourClient.getOurClientName());
        return clientResponse;
    }
}
