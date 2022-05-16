package pl.mielcarzswiatek.item.init;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mielcarzswiatek.carbrand.CarBrand;
import pl.mielcarzswiatek.carbrand.CarBrandService;
import pl.mielcarzswiatek.carmodel.CarModel;
import pl.mielcarzswiatek.description.Description;
import pl.mielcarzswiatek.description.DescriptionRepository;
import pl.mielcarzswiatek.pricelist.PriceList;
import pl.mielcarzswiatek.pricelist.PriceListRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class Initializer {

    private final CarBrandService carBrandService;
    private final PriceListRepository priceListRepository;
    private final DescriptionRepository descriptionRepository;

    @Transactional
    @PostConstruct
    public void init() {
        CarBrand carBrand1 = new CarBrand(
                "Niemcy",
                "Audi"
        );

        PriceList priceList1 = new PriceList(
                599,
                1500,
                3000,
                10500
        );

        Description description1 = new Description(
                "Czwarta generacja A3"
        );

        CarModel carModel1 = new CarModel(
                "Sedan",
                "A3",
                carBrand1,
                priceList1,
                description1
        );


        PriceList priceList2 = new PriceList(
                2000,
                7000,
                14000,
                49000
        );

        Description description2 = new Description(
                "Czwarta generacja A6"
        );

        CarModel carModel2 = new CarModel(
                "Sedan",
                "A6",
                carBrand1,
                priceList2,
                description2
        );

        carBrand1.setCarModels(List.of(carModel1, carModel2));
        priceListRepository.save(priceList1);
        priceListRepository.save(priceList2);
        descriptionRepository.save(description1);
        descriptionRepository.save(description2);
        carBrandService.saveCarBrand(carBrand1);

        CarBrand carBrand2 = new CarBrand(
                "Włochy",
                "Lamborghini"
        );

        PriceList priceList21 = new PriceList(
                4000,
                10000,
                20000,
                70000
        );

        Description description21 = new Description(
                "Szybki ekskluzywny samochód"
        );

        CarModel carModel21 = new CarModel(
                "Coupe",
                "Aventador",
                carBrand2,
                priceList21,
                description21
        );

        PriceList priceList22 = new PriceList(
                5000,
                12000,
                24000,
                80000
        );

        Description description22 = new Description(
                "Jeszcze szybszy ekskluzywny samochód"
        );

        CarModel carModel22 = new CarModel(
                "Roadster",
                "Huracan",
                carBrand2,
                priceList22,
                description22
        );

        carBrand2.setCarModels(List.of(carModel21, carModel22));
        priceListRepository.save(priceList21);
        priceListRepository.save(priceList22);
        descriptionRepository.save(description21);
        descriptionRepository.save(description22);
        carBrandService.saveCarBrand(carBrand2);

        CarBrand carBrand3 = new CarBrand(
                "Niemcy",
                "BMW"
        );

        PriceList priceList31 = new PriceList(
                2300,
                5750,
                11500,
                35000
        );

        Description description31 = new Description(
                "Najlepszy supersamochód"
        );

        CarModel carModel31 = new CarModel(
                "Cabrio",
                "E92M3",
                carBrand3,
                priceList31,
                description31
        );

        PriceList priceList32 = new PriceList(
                2000,
                4000,
                8000,
                24000
        );

        Description description32 = new Description(
                "Drugi najlepszy supersamochód"
        );

        CarModel carModel32 = new CarModel(
                "Sedan",
                "M5CS",
                carBrand3,
                priceList32,
                description32
        );

        carBrand3.setCarModels(List.of(carModel31, carModel32));
        priceListRepository.save(priceList31);
        priceListRepository.save(priceList32);
        descriptionRepository.save(description31);
        descriptionRepository.save(description32);
        carBrandService.saveCarBrand(carBrand3);

        CarBrand carBrand4 = new CarBrand(
                "USA",
                "Dodge"
        );

        PriceList priceList41 = new PriceList(
                3000,
                6000,
                12000,
                36000
        );

        Description description41 = new Description(
                "Ciężki supersamochód"
        );

        CarModel carModel41 = new CarModel(
                "Coupe",
                "Challenger",
                carBrand4,
                priceList41,
                description41
        );

        PriceList priceList42 = new PriceList(
                2000,
                4000,
                8000,
                24000
        );

        Description description42 = new Description(
                "Jeszcze cięższy supersamochód"
        );

        CarModel carModel42 = new CarModel(
                "Sedan",
                "Charger",
                carBrand4,
                priceList42,
                description42
        );

        carBrand4.setCarModels(List.of(carModel41, carModel42));
        priceListRepository.save(priceList41);
        priceListRepository.save(priceList42);
        descriptionRepository.save(description41);
        descriptionRepository.save(description42);
        carBrandService.saveCarBrand(carBrand4);

        CarBrand carBrand5 = new CarBrand(
                "Japonia",
                "Nissan"
        );

        PriceList priceList51 = new PriceList(
                2000,
                4000,
                8000,
                24000
        );

        Description description51 = new Description(
                "Trochę lżejszy supersamochód"
        );

        CarModel carModel51 = new CarModel(
                "Coupe",
                "R35",
                carBrand5,
                priceList51,
                description51
        );

        PriceList priceList52 = new PriceList(
                2500,
                5000,
                10000,
                28000
        );

        Description description52 = new Description(
                "Leciutki supersamochód"
        );

        CarModel carModel52 = new CarModel(
                "Coupe",
                "Z",
                carBrand5,
                priceList52,
                description52
        );

        carBrand5.setCarModels(List.of(carModel51, carModel52));
        priceListRepository.save(priceList51);
        priceListRepository.save(priceList52);
        descriptionRepository.save(description51);
        descriptionRepository.save(description52);
        carBrandService.saveCarBrand(carBrand5);
    }
}
