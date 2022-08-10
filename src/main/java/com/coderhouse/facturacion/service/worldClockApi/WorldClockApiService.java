package com.coderhouse.facturacion.service.worldClockApi;

import com.coderhouse.facturacion.model.WorldClockDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WorldClockApiService extends WorldClockApiBase {

    public LocalDateTime getDate(){
        LocalDateTime dateGeneration;
        try{
            ResponseEntity<WorldClockDTO> response = restTemplate.getForEntity(url, WorldClockDTO.class);
            dateGeneration = LocalDateTime.parse(response.getBody().getCurrentDateTime().replaceAll("Z$", ""));
        } catch (Exception ex){
            System.out.println("Hubo un problema al conectarse con World Clock Api");
            dateGeneration = LocalDateTime.now();
        }
        return dateGeneration;
    }

}
