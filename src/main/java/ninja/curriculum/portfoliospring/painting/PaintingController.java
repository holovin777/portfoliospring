package ninja.curriculum.portfoliospring.painting;

import ninja.curriculum.portfoliospring.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
    @RequestMapping("/api/v1/painting")
    public class PaintingController {
        private final PaintingService paintingService;

        @Autowired
        public PaintingController(PaintingService paintingService) {
            this.paintingService = paintingService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<Painting>> getAllPaintings() {
            List<Painting> paintings = paintingService.getAllPaintings();
            return ResponseEntity.ok(paintings);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Painting> getPaintingById(@PathVariable Long id) {
            Optional<Painting> painting = paintingService.getPaintingById(id);
            return painting.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/all/artist/{artistId}")
        public ResponseEntity<List<Painting>> getArtistPaintings(@PathVariable UUID artistId) {
            List<Painting> artistPaintings = paintingService.getArtistPaintings(artistId);
            return ResponseEntity.ok(artistPaintings);
        }

        @PostMapping
        public ResponseEntity<Void> addPainting(@RequestBody Painting painting) {
            paintingService.addPainting(painting);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> updatePainting(@PathVariable Long id,
                                                   @RequestParam(required = false) Customer artist,
                                                   @RequestParam(required = false) String title,
                                                   @RequestParam(required = false) LocalDate date,
                                                   @RequestParam(required = false) String imageURL) {
            paintingService.updatePainting(id, artist, title, date, imageURL);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePainting(@PathVariable Long id) {
            paintingService.deletePainting(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{paintingId}/medium/{mediumId}")
        public ResponseEntity<Void> addMedium(@PathVariable Long paintingId, @PathVariable Long mediumId) {
            paintingService.addMedium(paintingId, mediumId);
            return ResponseEntity.noContent().build();
        }
}
