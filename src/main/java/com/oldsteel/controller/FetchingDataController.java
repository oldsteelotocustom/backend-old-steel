package com.oldsteel.controller;

import com.oldsteel.dto.request.ImageRequest;
import com.oldsteel.dto.response.ImageResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@RestController
@RequestMapping("/api/v1/fetch")
@RequiredArgsConstructor
@Slf4j
public class FetchingDataController {

    private final RestTemplate restTemplate;


    @SneakyThrows
    @PostMapping(value = "/upload-data")
    @ResponseBody
    public void addImage(@RequestPart MultipartFile doc){
        String uri = "http://localhost:2020/api/v1/image/upload?file="+doc;
        var request = new ImageRequest();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(doc.getOriginalFilename()));
        request.setFileName(fileName);
        request.setDoc(doc);
        request.setContentType(doc.getContentType());
        log.info("The name is: {}", request.getFileName());
        HttpEntity<ImageRequest> httpEntity = new HttpEntity<>(new ImageRequest());
        ResponseEntity <ImageRequest> imageRequest = restTemplate.postForEntity(uri,
                httpEntity, ImageRequest.class);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<?> fetchImageById(@PathVariable("id") Long id){
       ResponseEntity <ImageResponseDto> imageResponseDto = restTemplate
                .getForEntity("http://localhost:2020/api/v1/image/get/"+id, ImageResponseDto.class);
        if(imageResponseDto.getStatusCode().is5xxServerError() && imageResponseDto.getStatusCode().isError()){
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(imageResponseDto, HttpStatus.OK);
    }

    @GetMapping("/all-images")
    public ResponseEntity<?> getAllImages(){
        ImageResponseDto[]  imagesResponse = restTemplate
                .getForObject("http://localhost:2020/api/v1/image/get-images", ImageResponseDto[].class);
        return new ResponseEntity<>(imagesResponse, HttpStatus.OK);
    }

}

