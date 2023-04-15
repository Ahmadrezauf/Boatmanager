import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/{id}")
    public ResponseEntity<Boat> getBoatById(@PathVariable("id") Long id) {
        Optional<Boat> boat = boatService.getBoatById(id);
        return boat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<Boat>> getAllBoats() {
        List<Boat> boats = boatService.getAllBoats();
        return new ResponseEntity<List<Boat>>(boats, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Boat> createBoat(@RequestBody Boat boat) {
        Boat createdBoat = boatService.createBoat(boat);
        return new ResponseEntity<Boat>(createdBoat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boat> updateBoat(@PathVariable("id") Long id, @RequestBody Boat boat) {
        Boat updatedBoat = boatService.updateBoat(id, boat);
        return new ResponseEntity<Boat>(updatedBoat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable("id") Long id) {
        boatService.deleteBoat(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
