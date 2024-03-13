package ch.noseryoung.domain.user;

import ch.noseryoung.domain.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {
  @Column(name = "user_id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int userId;

  @Column(name = "name")
  @NotNull
  private String name;

  @Column(name = "password")
  @NotNull
  private String password;

  @ManyToOne
  @JoinColumn(name = "id_role", referencedColumnName = "role_id")
  private Role role;
}
