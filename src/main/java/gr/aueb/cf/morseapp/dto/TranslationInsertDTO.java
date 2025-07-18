package gr.aueb.cf.morseapp.dto;

import gr.aueb.cf.morseapp.core.enums.TranslationDirection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationInsertDTO {

    @NotBlank(message = "Το inputText είναι υποχρεωτικό")
    private String inputText;

    @NotNull(message = "Η κατεύθυνση είναι υποχρεωτική")
    private TranslationDirection direction;
}