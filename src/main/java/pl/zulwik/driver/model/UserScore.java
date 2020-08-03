package pl.zulwik.driver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode(of = "id")

@Entity
@Table(name="users_scores")
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "int default 0")
    private Integer score;

    @OneToOne
    private UserEntity userEntity;
}
