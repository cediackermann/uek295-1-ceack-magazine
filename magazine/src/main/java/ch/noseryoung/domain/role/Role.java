package ch.noseryoung.domain.role;

import ch.noseryoung.domain.authority.Authority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

@Entity
@Table(name = "role")
@Getter
public class Role {
  @Column(name = "role_id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int roleId;

  @Column(name = "name")
  @NotNull
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_authority",
      joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
      inverseJoinColumns =
          @JoinColumn(name = "id_authority", referencedColumnName = "authority_id"))
  private Set<Authority> authorities = new HashSet<>();
}
