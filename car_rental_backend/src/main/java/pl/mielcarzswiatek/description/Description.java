package pl.mielcarzswiatek.description;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "descriptions")
@Entity(name = "Description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "specification")
    private String specification;

    public Description(String specification) {
        this.specification = specification;
    }
}