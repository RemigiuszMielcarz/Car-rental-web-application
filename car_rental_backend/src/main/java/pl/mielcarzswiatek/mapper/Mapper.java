package pl.mielcarzswiatek.mapper;

import org.springframework.stereotype.Service;
import pl.mielcarzswiatek.item.Item;
import pl.mielcarzswiatek.item.ItemResponse;
import pl.mielcarzswiatek.carbrand.CarBrand;
import pl.mielcarzswiatek.carmodel.CarModel;
import pl.mielcarzswiatek.parameters.Parameters;
import pl.mielcarzswiatek.pricelist.PriceList;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    public List<ItemResponse> createItemResponses(List<Item> adverts) {
        List<ItemResponse> responses = new ArrayList<>();

        for(Item advert : adverts) {
            ItemResponse response = createItemResponse(advert);
            responses.add(response);
        }

        return responses;
    }

    public ItemResponse createItemResponse(Item advert) {
        Parameters parameters = advert.getCar().getParameters();
        CarModel carModel = advert.getCar().getCarModel();
        CarBrand carBrand = carModel.getCarBrand();
        PriceList priceList = carModel.getPriceList();

        return new ItemResponse(
                advert.getTitle(),
                advert.getPicture(),
                carModel.getDescription().getSpecification(),
                carBrand.getBrandName(),
                carModel.getModelName(),
                carModel.getCarBody(),
                carBrand.getCountry(),
                parameters.getVintage(),
                parameters.getPower(),
                parameters.getMileage(),
                parameters.getColor(),
                priceList.getDay(),
                priceList.getWeekend(),
                priceList.getWeek(),
                priceList.getMonth()
        );
    }
}
