package ch.noseryoung.domain.authority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "authority")
@Getter
public class Authority {

  @Column(name = "authority_id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int authorityId;

  @Column(name = "name")
  @NotNull
  private String name;
}
