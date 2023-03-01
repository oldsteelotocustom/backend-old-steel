package com.oldsteel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ImageResponseDto {

    private byte[] imageData;

    private String imageName;

    private String contentType;
}
