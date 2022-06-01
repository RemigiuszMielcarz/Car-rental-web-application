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

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final StatusRepository statusRepository;
    private final CarService carService;
    private final Mapper mapper;

    @Transactional
    public ResponseEntity<?> saveAdvert(ItemRequest request) {
        Car car = carService.saveCar(request);
        Status status = statusRepository.save(new Status(true));
        String picture = "";
        String type = "";

        Item advert = new Item(
                request.getTitle(),
                status,
                request.getPicture(),
                request.getType(),
                car
        );
        itemRepository.save(advert);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Item added");
    }

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
                                           String modelName) {

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
                modelName
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
}
