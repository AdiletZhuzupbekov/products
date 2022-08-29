package kg.megacom.products.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.products.model.entity.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {

    private Long id;
    private int percent;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date endDate;
    private ProductDto product;
}
