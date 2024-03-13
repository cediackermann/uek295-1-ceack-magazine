package ch.noseryoung.domain.magazine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "magazine")
@Getter
@Setter
public class Magazine {
  @Column(name = "magazine_id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int magazineId;

  @Column(name = "name")
  @NotNull
  @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
  private String name;

  @Column(name = "number_of_volumes")
  @NotNull
  private int numberOfVolumes;

  @Column(name = "publisher")
  @NotNull
  @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
  private String publisher;
}
