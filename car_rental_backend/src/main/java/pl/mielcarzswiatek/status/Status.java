package pl.mielcarzswiatek.status;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "status")
@Entity(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_available")
    private Boolean isAvailable;

    public Status(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
