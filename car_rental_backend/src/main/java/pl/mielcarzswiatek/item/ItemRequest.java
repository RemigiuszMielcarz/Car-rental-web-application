package pl.mielcarzswiatek.item;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ItemRequest {
    // parameters
    private String color;
    private Integer vintage;
    private Integer mileage;
    private Integer power;

    // model
    private String modelName;

    // item
    private String title;
    private String picture;
}
