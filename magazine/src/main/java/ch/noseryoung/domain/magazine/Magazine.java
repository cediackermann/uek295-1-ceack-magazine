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

@Entity
@Table(name = "magazine")
public class Magazine {
  @Column(name = "magazine_id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int magazineId;

  @Column(name = "name")
  @NotNull
  @Size(min = 1, max = 255)
  private String name;

  @Column(name = "numberOfVolumes")
  @Min(1)
  private int numberOfVolumes;

  @Column(name = "publisher")
  @NotNull
  @Size(min = 1, max = 255)
  private String publisher;
}
