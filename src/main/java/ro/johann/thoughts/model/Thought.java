package ro.johann.thoughts.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Getter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "thought")
public class Thought {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    @Column(length = 5000, nullable = false)
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne
    private Language language;
}