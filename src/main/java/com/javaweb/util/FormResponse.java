package com.javaweb.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class FormResponse {
    public static ResponseEntity<String> contentOk(String title, String content){
        String result = "{\"title\":\""+title+"\"," +
                        "\"message\":\""+content+"\" }";
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
    public static ResponseEntity<String> contentNotOk(String title, String content){
        String result = "{\"title\":\""+title+"\"," +
                "\"message\":\""+content+"\" }";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

}
