package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogOutAccountCheck {

    @JsonProperty("code")
    private String notAuthCode;
    @JsonProperty("message")
    private String notAuthMessage;
}
