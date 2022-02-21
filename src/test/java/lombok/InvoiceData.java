package lombok;

@Data
public class InvoiceData {
    private String clientFromAgent;
    private Long idClientFrom;
    private Long idClientTo;
    private int idCityFrom;
    private int idCityTo;
    private int idWareFrom;
    private int idWareTo;
    private String description;
    private String packaging;
    private String cargoname;
    private String addressRequest;
    private String addressDelivery;
}

