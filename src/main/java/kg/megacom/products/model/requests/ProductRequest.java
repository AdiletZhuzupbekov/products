package kg.megacom.products.model.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    private Long categoryId;
    private String title;
    private double price;
    private int percent;
    private int discountDuration;
}
