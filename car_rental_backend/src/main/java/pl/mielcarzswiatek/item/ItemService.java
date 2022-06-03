package pl.mielcarzswiatek.item;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.mielcarzswiatek.car.Car;
import pl.mielcarzswiatek.car.CarService;
import pl.mielcarzswiatek.mapper.Mapper;
import pl.mielcarzswiatek.status.Status;
import pl.mielcarzswiatek.status.StatusRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final StatusRepository statusRepository;
    private final CarService carService;
    private final Mapper mapper;

    public ResponseEntity<?> findByFilters(
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
                                           String carBody,
                                           String brandName) {

        List<Item> adverts = itemRepository.findByFilters(
                powerMin,
                powerMax,
                vintageMin,
                vintageMax,
                mileageMin,
                mileageMax,
                dayMin,
                dayMax,
                weekendMin,
                weekendMax,
                weekMin,
                weekMax,
                monthMin,
                monthMax,
                modelName,
                country,
                carBody,
                brandName
        );

        List<ItemResponse> responses = mapper.createItemResponses(adverts);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responses);
    }

    public ResponseEntity<?> deleteAdvertById(Long id) {
        itemRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Item deleted");
    }
    @Transactional
    public ResponseEntity<?> rentCar(String modelName) {
        Item item = itemRepository.findByCar_CarModel_ModelName(modelName).get();
        Optional <Status> status = statusRepository.findById(1L);
        item.setStatus(status.get());
        itemRepository.save(item);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Car rented");
    }

}
