package pl.mielcarzswiatek.car;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mielcarzswiatek.item.ItemRequest;
import pl.mielcarzswiatek.carmodel.CarModel;
import pl.mielcarzswiatek.carmodel.CarModelRepository;
import pl.mielcarzswiatek.parameters.Parameters;
import pl.mielcarzswiatek.parameters.ParametersRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarModelRepository carModelRepository;
    private final ParametersRepository parametersRepository;

    @Transactional
    public Car saveCar(ItemRequest request) {
        Parameters parameters = new Parameters(
                request.getColor(),
                request.getVintage(),
                request.getMileage(),
                request.getPower()
        );
        parametersRepository.save(parameters);

        CarModel carModel = carModelRepository.
                findByModelName(request.getModelName()).get();

        Car car = new Car(parameters, carModel);
        return carRepository.save(car);
    }
}
