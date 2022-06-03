package pl.mielcarzswiatek.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT a " +
            "FROM Item a " +
            "WHERE a.car.parameters.power BETWEEN ?1 AND ?2 " +
            "AND a.car.parameters.vintage BETWEEN ?3 AND ?4 " +
            "AND a.car.parameters.mileage BETWEEN ?5 AND ?6 " +
            "AND a.car.carModel.priceList.day BETWEEN ?7 AND ?8 " +
            "AND a.car.carModel.priceList.weekend BETWEEN ?9 AND ?10 " +
            "AND a.car.carModel.priceList.week BETWEEN ?11 AND ?12 " +
            "AND a.car.carModel.priceList.month BETWEEN ?13 AND ?14 " +
            "AND a.car.carModel.modelName LIKE ?15 " +
            "AND a.car.carModel.carBrand.country LIKE ?16"



    )
    List<Item> findByFilters(
            Integer powerMin,
            Integer powerMax,
            Integer vintageMin,
            Integer vintageMax,
            Integer mileageMin,
            Integer mileageMax,
            Integer dayMin,
            Integer dayMax,
            Integer weekendMin,
            Integer weekendMax,
            Integer weekMin,
            Integer weekMax,
            Integer monthMin,
            Integer monthMax,
            String modelName,
            String country,
            String carBody
    );

    Optional<Item>findByCar_CarModel_ModelName(String modelName);
}
