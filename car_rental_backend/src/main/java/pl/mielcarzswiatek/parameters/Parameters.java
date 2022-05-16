package pl.mielcarzswiatek.parameters;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "parameters")
@Entity(name = "Parameters")
public class Parameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color")
    private String color;

    @Column(name = "vintage")
    private Integer vintage;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "power")
    private Integer power;

    public Parameters(String color,
                      Integer vintage,
                      Integer mileage,
                      Integer power
    ) {
        this.color = color;
        this.vintage = vintage;
        this.mileage = mileage;
        this.power = power;
    }
}
