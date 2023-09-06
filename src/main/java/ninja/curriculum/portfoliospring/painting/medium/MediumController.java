package ninja.curriculum.portfoliospring.painting.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medium")
public class MediumController {
    private final MediumService mediumService;

    @Autowired
    public MediumController(MediumService mediumService) {
        this.mediumService = mediumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medium>> getAllMediums() {
        List<Medium> mediums = mediumService.getAllMediums();
        return ResponseEntity.ok(mediums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medium> getMediumById(@PathVariable Long id) {
        Optional<Medium> medium = mediumService.getMediumById(id);
        return medium.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> addMedium(@RequestBody Medium medium) {
        mediumService.addMedium(medium);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateMedium(@PathVariable Long id, @RequestBody Medium updatedMedium) {
        mediumService.updateMedium(id, updatedMedium);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedium(@PathVariable Long id) {
        mediumService.deleteMedium(id);
        return ResponseEntity.noContent().build();
    }
}
