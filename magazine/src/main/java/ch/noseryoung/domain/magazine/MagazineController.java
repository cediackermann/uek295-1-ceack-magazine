package ch.noseryoung.domain.magazine;

import io.swagger.v3.oas.annotations.Operation;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.TransactionSystemException;
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
  @PreAuthorize("hasAuthority('CREATE_MAGAZINE')")
  @Operation(
      summary = "Create a new magazine",
      description = "Create a new magazine with the given data")
  public ResponseEntity<Magazine> createMagazine(@RequestBody Magazine magazine) {
    return ResponseEntity.status(201).body(magazineService.createMagazine(magazine));
  }

  @GetMapping("/magazines/{magazineId}")
  @PreAuthorize("hasAuthority('READ_MAGAZINE')")
  @Operation(summary = "Get a magazine by id", description = "Get a magazine by id")
  public ResponseEntity<Magazine> getMagazineById(@PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.getMagazineById(magazineId));
  }

  @GetMapping("/magazines")
  @PreAuthorize("hasAuthority('READ_MAGAZINE')")
  @Operation(summary = "Get all magazines", description = "Get all magazines")
  public ResponseEntity<Iterable<Magazine>> getAllMagazines() {
    return ResponseEntity.ok().body(magazineService.getAllMagazines());
  }

  @PutMapping("/magazines/{magazineId}")
  @PreAuthorize("hasAuthority('UPDATE_MAGAZINE')")
  @Operation(summary = "Update a magazine", description = "Update a magazine with the given data")
  public ResponseEntity<Magazine> updateMagazine(
      @RequestBody Magazine magazine, @PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.updateMagazine(magazine, magazineId));
  }

  @DeleteMapping("/magazines/{magazineId}")
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Delete a magazine", description = "Delete a magazine by id")
  public ResponseEntity<Magazine> deleteMagazine(@PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.deleteMagazine(magazineId));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchElementException() {
    return ResponseEntity.status(404).body("Resource not found!");
  }

  @ExceptionHandler({TransactionSystemException.class})
  public ResponseEntity<String> handleTransactionSystemException(TransactionSystemException e) {
    return ResponseEntity.status(500).body("Content is not valid!" + e.getMessage());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    return ResponseEntity.status(400).body("Content is not valid!" + e.getMessage());
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<String> handleAccessDeniedException() {
    return ResponseEntity.status(403).body("Access denied!");
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException() {
    return ResponseEntity.status(500).body("An error occurred!");
  }
}
