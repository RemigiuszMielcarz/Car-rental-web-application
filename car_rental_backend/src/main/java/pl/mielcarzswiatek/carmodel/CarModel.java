package pl.mielcarzswiatek.carmodel;

import lombok.*;
import pl.mielcarzswiatek.carbrand.CarBrand;
import pl.mielcarzswiatek.description.Description;
import pl.mielcarzswiatek.parameters.Parameters;
import pl.mielcarzswiatek.pricelist.PriceList;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "car_models")
@Entity(name = "CarModel")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_body")
    private String carBody;

    @Column(name = "model_name")
    private String modelName;

    @OneToOne
    @JoinColumn(name = "price_list_id")
    private PriceList priceList;

    @OneToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @ManyToOne()
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    public CarModel(String carBody, String modelName, CarBrand carBrand, PriceList priceList, Description description) {
        this.carBody = carBody;
        this.modelName = modelName;
        this.carBrand = carBrand;
        this.priceList = priceList;
        this.description = description;
    }
}
