package pl.mielcarzswiatek.carbrand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.mielcarzswiatek.carmodel.CarModel;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "car_brands")
@Entity(name = "CarBrand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "carBrand")
    @JsonIgnore
    private List<CarModel> carModels;

    public CarBrand(String country, String brandName) {
        this.country = country;
        this.brandName = brandName;
    }
}
