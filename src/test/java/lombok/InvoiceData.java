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
    private int serviceFrom;
    private int weight;
    private int volume;
    private String packaging;
    private String cargoname;
    private int cargotype;
    private int isDelivery;
    private int isZayavka;
    private int requestDate;
    private int idTripType;
    private int place;
    private int isSpCityFrom;
    private int isSpCityTo;
    private int isSpFreight;
    private int isSpServiceFrom;
    private String addressRequest;
    private  String addressDelivery;
    private int declaredCargoPrice;

}

