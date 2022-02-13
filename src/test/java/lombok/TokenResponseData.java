package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponseData {

    private String token;
    private int type;
    private Long accountId;

}
