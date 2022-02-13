package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private Long id;
    private String name;
    private Long parentId;
    private String description;
    private int type;
    private int defaultIdWare;

}
