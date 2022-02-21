package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteConfirmAction {
    @JsonProperty("code")
    private String NotFoundCode;
    @JsonProperty("message")
    private String NotFoundMessage;
}
