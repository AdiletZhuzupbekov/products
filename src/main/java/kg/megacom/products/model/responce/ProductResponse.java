package kg.megacom.products.model.responce;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    private Long productId;
    private Long categoryId;
    private String title;
    private double price;
    private int percent;
    private String discountEndDate;
}
