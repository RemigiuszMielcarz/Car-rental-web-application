package pl.mielcarzswiatek.item;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ItemResponse {
    // item description
    private String title;
    private String specification;

    // main data
    private String brandName;
    private String modelName;

    // model
    private String carBody;
    private String country;

    // parameters
    private Integer vintage;
    private Integer power;
    private Integer mileage;
    private String color;

    // price list
    private Integer day;
    private Integer weekend;
    private Integer week;
    private Integer month;
}