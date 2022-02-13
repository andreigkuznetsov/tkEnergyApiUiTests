package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateFirstContractor {

    private Long id;
    private String url;

}
