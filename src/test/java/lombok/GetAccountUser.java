package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountUser {

    private int idCity;
    private String title;
    private String fulltitle;
    private String phone;
    private String email;

}
