package pl.mielcarzswiatek.carbrand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;

    public void saveCarBrand(CarBrand carBrand) {
        Optional<CarBrand> carBrandFromDb = carBrandRepository
                .findByBrandName(carBrand.getBrandName());

        if(carBrandFromDb.isEmpty()) {
            carBrandRepository.save(carBrand);
        }
    }
}
