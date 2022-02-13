package yahoo.andreikuzn.tests;

import com.github.javafaker.Faker;
import java.util.Locale;



public class TestData {

    public static Faker faker = new Faker(new Locale("en"));

   public static String name = faker.name().nameWithMiddle(),
            lastName = faker.name().lastName(),
            address = faker.address().streetAddress(),
            phone = faker.numerify("7#########"),
            email = faker.internet().emailAddress("tkenergy_client"),
            newemail = faker.internet().emailAddress("energy_client"),
            kpp = faker.numerify("#########"),
            inn = faker.numerify("##########"),
            juraddress = faker.address().streetAddress(),
            namem = faker.name().nameWithMiddle(),
            lastnamem = faker.name().lastName(),
            addressm = faker.address().streetAddress(),
            phonem = faker.numerify("7#########"),
            emailm = faker.internet().emailAddress("energy_client"),
            kppm = faker.numerify("#########"),
            innm = faker.numerify("##########"),
            juraddressm = faker.address().streetAddress();

    public static String city = "Новороссийск",
            region = "Краснодарский край",
            cityzip = "101000",
            searchText = "Задержки",
            cityFrom = "Калуга",
            cityTo = "Москва",
            weight = "0.1",
            cargoVolume = "0.001",
            cost = "300,00",
            billNumber = "7804-1422301",
            currentStatus = "Выдана: 14.01.2022, на складе \"Калуга П\"",
            clientFromAgent = "Рубов",
            cityFromTitle = "НОВОСИБИРСК",
            cityToTitle = "МОСКВА",
            cityToTitleS = "Москва",
            description = "Запчасти",
            packaging = "Коробка",
            cargoname = "Груз",
            addressname = "Ленина, 12",
            accountUser = "Петр Петров",
            cityName = "13 км осн. трассы",
            cityDescription = "Магаданская область",
            code = "Ok",
            message = "Sucess",
            NotFoundCode = "NotFound",
            NotFoundMessage = "Resource not found",
            notAuthCode = "SessionNotFound",
            notAuthMessage = "Session: not found. You are not logged in";

    public static int type = 1,
            idWareFrom = 20461,
            idWareTo = 20524,
            idCityFrom = 383,
            idCityTo = 495,
            priceFreight = 300,
            cityType = 3,
            cityDefaultIdWare = 0;

    public static Long cityId = 41322021L,
            cityParentId = 41322L;

    public static String firstContractorData = "{\"title\":\"" + TestData.lastName + "\",\n" +
            "    \"fullTitle\": \"" + TestData.name + "\",\n" +
            "    \"idCity\": \""+ idCityFrom + "\",\n" +
            "    \"address\": \""+ TestData.address + "\",\n" +
            "    \"phone\": \"+7" + TestData.phone + "\",\n" +
            "    \"email\": \""+ TestData.phone + "\",\n" +
            "    \"inn\": \"" + TestData.inn + "\",\n" +
            "    \"kpp\": \""+ TestData.kpp + "\",\n" +
            "    \"jurAddress\": \""+ TestData.juraddress + "\",\n" +
            "    \"createDate\": 0,\n" +
            "    \"modifyDate\": 0}";

    public static String secondContractorData = "{\"title\":\"" + TestData.lastnamem + "\",\n" +
            "    \"fullTitle\": \"" + TestData.namem + "\",\n" +
            "    \"idCity\": \"" + idCityTo + "\",\n" +
            "    \"address\": \""+ TestData.addressm + "\",\n" +
            "    \"phone\": \"+7" + TestData.phonem + "\",\n" +
            "    \"email\": \""+ TestData.emailm + "\",\n" +
            "    \"inn\": \"" + TestData.innm + "\",\n" +
            "    \"kpp\": \""+ TestData.kppm + "\",\n" +
            "    \"jurAddress\": \""+ TestData.juraddressm + "\",\n" +
            "    \"createDate\": 0,\n" +
            "    \"modifyDate\": 0}";

    public static String getDelliveryBillData(Long firstContractorId, Long secondContractorId) {
        return "{\n" +
            "  \"clientFromAgent\":\"" + clientFromAgent + "\",\n" +
            "  \"idClientFrom\":" + firstContractorId + ",\n" +
            "  \"idClientTo\":" + secondContractorId + ",\n" +
            "  \"idCityFrom\":" + idCityFrom + ",\n" +
            "  \"idCityTo\":" + idCityTo + ",\n" +
            "  \"idWareFrom\": 0,\n" +
            "  \"idWareTo\": 0,\n" +
            "  \"description\":\"" + description + "\",\n" +
            "  \"serviceFrom\": 0,\n" +
            "  \"weight\": 0,\n" +
            "  \"volume\": 0,\n" +
            "  \"packaging\":\"" + packaging + "\",\n" +
            "  \"cargoname\":\"" + cargoname + "\",\n" +
            "  \"cargotype\": 0,\n" +
            "  \"isDelivery\": 0,\n" +
            "  \"isZayavka\": 0,\n" +
            "  \"requestDate\": 0,\n" +
            "  \"idTripType\": 0,\n" +
            "  \"place\": 0,\n" +
            "  \"isSpCityFrom\": 0,\n" +
            "  \"isSpCityTo\": 0,\n" +
            "  \"isSpFreight\": 0,\n" +
            "  \"isSpServiceFrom\": 0,\n" +
            "  \"isSpFee\": 0,\n" +
            "  \"addressRequest\":\"" + addressname + "\",\n" +
            "  \"addressDelivery\":\"" + addressname + "\",\n" +
            "  \"declaredCargoPrice\": 0\n" +
            "}";
    }

}

