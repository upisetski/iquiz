package by.pisetskiy.iquiz.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerDto extends BaseDto {

    private Long question;
    private List<Long> variants;
    private Boolean isTrue;

}
