package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameJob;

    @NotNull(message = "A salary needs informed!")
    @DecimalMin(value = "5000.00", message = "A salary needs to be than greater or equal 5000.00")
    @DecimalMax(value = "35000.00", message = "A salary needs to be than lesser or equal35000.00")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal salaryJob;

}
