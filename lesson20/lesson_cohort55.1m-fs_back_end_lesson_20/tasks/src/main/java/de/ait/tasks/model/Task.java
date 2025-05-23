package de.ait.tasks.model;

// Task {id, description (описание), priority (приоритет)}

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="description")
    private String description;
    @Column(name="priority`")
    private Priority priority;
    @ManyToOne
    @JoinColumn(name="programmer_id")
    private Programmer programmer;

}
