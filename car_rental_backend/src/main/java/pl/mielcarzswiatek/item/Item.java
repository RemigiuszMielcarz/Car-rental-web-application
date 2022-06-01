package pl.mielcarzswiatek.item;

import lombok.*;
import pl.mielcarzswiatek.car.Car;
import pl.mielcarzswiatek.status.Status;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "item")
@Entity(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "picture")
    private String picture;

    @Column(name = "type")
    private String type;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Item(String title,
                Status status,
                String picture,
                String type,
                Car car) {
        this.title = title;
        this.picture = picture;
        this.type = type;
        this.status = status;
        this.car = car;
    }
}
