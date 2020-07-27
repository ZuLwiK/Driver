package pl.zulwik.driver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "advices")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "varchar(10000)")
    private String content;

    @OneToMany
    private List<Question> questions;

    @ManyToMany
    List<Tag> tags;

    @Column
    @DateTimeFormat(pattern = "yyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime created = LocalDateTime.now();

    @Column
    @DateTimeFormat(pattern = "yyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime updated = LocalDateTime.now();

}
