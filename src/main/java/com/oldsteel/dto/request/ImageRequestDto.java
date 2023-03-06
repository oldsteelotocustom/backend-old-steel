package com.oldsteel.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ImageRequestDto {

    private byte[] imageData;

    private String imageName;

    private String contentType;
}
