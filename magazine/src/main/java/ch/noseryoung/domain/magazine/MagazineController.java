package ch.noseryoung.domain.magazine;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MagazineController {

  @Autowired private MagazineService magazineService;

  @PostMapping("/magazines")
  @PreAuthorize("hasAnyAuthority('')")
  public ResponseEntity<Magazine> createMagazine(@RequestBody Magazine magazine) {
    return ResponseEntity.status(201).body(magazineService.createMagazine(magazine));
  }

  @GetMapping("/magazines/{magazineId}")
  public ResponseEntity<Magazine> getMagazineById(@PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.getMagazineById(magazineId));
  }

  @GetMapping("/magazines")
  public ResponseEntity<Iterable<Magazine>> getAllMagazines() {
    return ResponseEntity.ok().body(magazineService.getAllMagazines());
  }

  @PutMapping("/magazines/{magazineId}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Magazine> updateMagazine(
      @RequestBody Magazine magazine, @PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.updateMagazine(magazine, magazineId));
  }

  @DeleteMapping("/magazines/{magazineId}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Magazine> deleteMagazine(@PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.deleteMagazine(magazineId));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }
}
