package org.example.springdataex_asterix_api;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {
    private final CharacterRepo characterRepo;
    private final IdService idService;

    public AsterixController(CharacterRepo characterRepo, IdService idService) {
        this.characterRepo = characterRepo;
        this.idService = idService;
    }


    @GetMapping("/characters")
    public List<Character> findCharacters(@RequestParam(defaultValue = "1000") int maxAge) {
        return characterRepo.findByAgeLessThanEqual(maxAge);
    }

    @GetMapping("/characters/{id}")
    public Character findCharacterById(@PathVariable String id) {
        return characterRepo.findById(id).orElseThrow();
    }

    @GetMapping("/characters/{id}/delete")
    public String findAndDeleteCharacterById(@PathVariable String id) {
        characterRepo.deleteById(id);
        return "success";
    }

    @PutMapping("/characters/{id}/update")
    public Character updateCharacterById(@PathVariable String id, @RequestBody NewCharacterDto updatedCharacter) {
        return characterRepo.save(new Character(id, updatedCharacter.name(), updatedCharacter.age(), updatedCharacter.profession()));
    }

    @PostMapping("/characters/add")
    public Character addCharacter(@RequestBody NewCharacterDto newCharacter) {
        return characterRepo.save(new Character(idService.randomId(), newCharacter.name(), newCharacter.age(), newCharacter.profession()));
    }

}
