package org.example.springdataex_asterix_api;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {
    private final CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }


    @GetMapping("/characters")
    public List<Character> sayHello() {
        return List.of(
                new Character("1", "Asterix", 35, "Krieger"),
                new Character("2", "Obelix", 35, "Lieferant"),
                new Character("3", "Miraculix", 60, "Druide"),
                new Character("4", "Majestix", 60, "Häuptling"),
                new Character("5", "Troubadix", 25, "Barden"),
                new Character("6", "Gutemine", 35, "Häuptlingsfrau"),
                new Character("7", "Idefix", 5, "Hund"),
                new Character("8", "Geriatrix", 70, "Rentner"),
                new Character("9", "Automatix", 35, "Schmied"),
                new Character("10", "Grockelix", 35, "Fischer")
        );
    }

    @PostMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable int id) {
        // Code zum Löschen eines Elements mit der ID
        return "Item with ID " + id + " removed successfully.";
    }
}
