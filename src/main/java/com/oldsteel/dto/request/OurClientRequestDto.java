package com.oldsteel.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OurClientRequestDto {

    @NotBlank(message = "Client name cannot be blank")
    private String ourClientName;
}
