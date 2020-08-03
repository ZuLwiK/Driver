package pl.zulwik.driver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private UserScore userScore;


    /**
     * @param username
     * @param password
     */
    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }


/*    public UserEntity(String username, String password, Set<Role> roles) {
        this.username=username;
        this.password=password;
        this.roles=roles;
    }*/
}
