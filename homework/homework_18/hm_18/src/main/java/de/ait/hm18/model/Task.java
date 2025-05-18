package de.ait.hm18.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of="id")
@Setter

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private Priority priority;

@OneToMany(mappedBy = "task")
    private Set<Programmer> programmes = new HashSet<>();


}
