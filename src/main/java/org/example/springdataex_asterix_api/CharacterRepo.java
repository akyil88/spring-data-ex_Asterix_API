package org.example.springdataex_asterix_api;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepo extends MongoRepository<Character, String> {
    List<Character> findByName(String name);
}
