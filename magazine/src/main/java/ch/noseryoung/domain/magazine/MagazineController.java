package ch.noseryoung.domain.magazine;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
  public ResponseEntity<Magazine> createMagazine(@Valid @RequestBody Magazine magazine) {
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
      @Valid @RequestBody Magazine magazine, @PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.updateMagazine(magazine, magazineId));
  }

  @DeleteMapping("/magazines/{magazineId}")
  @PreAuthorize("hasAuthority('DELETE_MAGAZINE')")
  @Operation(summary = "Delete a magazine", description = "Delete a magazine by id")
  public ResponseEntity<Magazine> deleteMagazine(@PathVariable Integer magazineId) {
    return ResponseEntity.ok().body(magazineService.deleteMagazine(magazineId));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    return ResponseEntity.badRequest()
        .body(
            e.getBindingResult().getFieldError().getField()
                + " is invalid: "
                + e.getBindingResult().getFieldError().getDefaultMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(e.getCause().getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleRuntimeException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred!");
  }
}
