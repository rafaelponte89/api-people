package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobType {
    DESENVOLVEDOR ("Desenvolvedor"),
    GERENTE ("Gerente"),
    ENGENHEIRO ("Engenheiro"),
    SOFTWARETESTER ("Software Tester");

    private final String descritption;
}
