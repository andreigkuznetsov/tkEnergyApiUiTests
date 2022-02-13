package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceStatus {

    private String clientFromAgent;
    private Long idClientFrom;
    private Long idClientTo;
    private Long idClientPayer;
    private int idCityFrom;
    private int idCityTo;
    private String cityFromTitle;
    private String cityToTitle;
    private int idWareFrom;
    private int idWareTo;
    private String description;
    private int priceFreight;
    private String packaging;
    private String cargoname;


}
