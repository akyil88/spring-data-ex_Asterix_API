package org.example.springdataex_asterix_api;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String randomId(){
        return UUID.randomUUID().toString();
    }
}
