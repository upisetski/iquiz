package by.pisetskiy.iquiz.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VariantRequest extends BaseRequest {

    private String value;
    private Boolean isTrue;
}
