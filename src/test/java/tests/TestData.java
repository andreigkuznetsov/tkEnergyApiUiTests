package tests;

import com.github.javafaker.Faker;
import lombok.FirstContractorData;

import java.util.Locale;


public class TestData {

    public static Faker faker = new Faker(new Locale("en"));

    public static String firstContractorName = faker.name().nameWithMiddle(),
            firstContractorLastName = faker.name().lastName(),
            firstContractorAddress = faker.address().streetAddress(),
            firstContractorPhone = faker.numerify("7#########"),
            firstContractorEmail = faker.internet().emailAddress("tkenergy_client"),
            firstContractorNewEmail = faker.internet().emailAddress("energy_client"),
            firstContractorKpp = faker.numerify("#########"),
            firstContractorInn = faker.numerify("##########"),
            firstContractorJurAddress = faker.address().streetAddress(),
            secondContractorName = faker.name().nameWithMiddle(),
            secondContractorLastName = faker.name().lastName(),
            secondContractorAddress = faker.address().streetAddress(),
            secondContractorPhone = faker.numerify("7#########"),
            secondContractorEmail = faker.internet().emailAddress("energy_client"),
            secondContractorKpp = faker.numerify("#########"),
            secondContractorInn = faker.numerify("##########"),
            secondContractorJurAddress = faker.address().streetAddress();

    public static String city = "Новороссийск",
            region = "Краснодарский край",
            cityzip = "101000",
            searchText = "Задержки",
            cityFrom = "Калуга",
            cityTo = "Москва",
            weight = "0.1",
            cargoVolume = "0.001",
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
}
