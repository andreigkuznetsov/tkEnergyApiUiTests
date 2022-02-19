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
            cityDefaultIdWare = 0,
            createDate = 0,
            modifyDate = 0,
            serviceFrom = 0,
            invoice_weight = 0,
            volume = 0,
            cargotype = 0,
            isDelivery = 0,
            isZayavka = 0,
            requestDate = 0,
            idTripType = 0,
            place = 0,
            isSpCityFrom = 0,
            isSpCityTo = 0,
            isSpFreight = 0,
            isSpServiceFrom = 0,
            declaredCargoPrice = 0;

    public static Long cityId = 41322021L,
            cityParentId = 41322L;

}

