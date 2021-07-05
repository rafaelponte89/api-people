package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Currency;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2,max = 30)
    private String nameJob;

    @DecimalMax(value = "35000.00",message = "Salary needs to be than lesser 35000.00" )
    @DecimalMin(value = "3500.00", message = "Salary needs to be than greater 5000.00")
    @NotNull(message = "A salary needs informed!")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal salaryJob;


}
