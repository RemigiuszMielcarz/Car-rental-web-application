package pl.mielcarzswiatek.item;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
@CrossOrigin("http://localhost:8081")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<?> postAdvert(@RequestBody ItemRequest request) {
        return itemService.saveAdvert(request);
    }

    @GetMapping
    public ResponseEntity<?> findByFilters(
            @RequestParam(name = "power_min", defaultValue = "0") Integer powerMin,
            @RequestParam(name = "power_max", defaultValue = "5000") Integer powerMax,
            @RequestParam(name = "vintage_min", defaultValue = "0") Integer vintageMin,
            @RequestParam(name = "vintage_max", defaultValue = "2050") Integer vintageMax,
            @RequestParam(name = "mileage_min", defaultValue = "0") Integer mileageMin,
            @RequestParam(name = "mileage_max", defaultValue = "2000000000") Integer mileageMax,
            @RequestParam(name = "model", defaultValue = "%") String modelName,
            @RequestParam(name = "day_min", defaultValue = "0") Integer dayMin,
            @RequestParam(name = "day_max", defaultValue = "2000000000") Integer dayMax,
            @RequestParam(name = "weekend_min", defaultValue = "0") Integer weekendMin,
            @RequestParam(name = "weekend_max", defaultValue = "2000000000") Integer weekendMax,
            @RequestParam(name = "week_min", defaultValue = "0") Integer weekMin,
            @RequestParam(name = "week_max", defaultValue = "2000000000") Integer weekMax,
            @RequestParam(name = "month_min", defaultValue = "0") Integer monthMin,
            @RequestParam(name = "month_max", defaultValue = "2000000000") Integer monthMax
            )
       {

        return itemService.findByFilters(
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
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAdvertById(@PathVariable("id") Long id) {
        return itemService.deleteAdvertById(id);
    }
}
