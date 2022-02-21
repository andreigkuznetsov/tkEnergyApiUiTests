package tests.api;

import static tests.api.ApiSteps.*;

public class ApiEndpoints {
    public static final String userLogin = "/login?user=" + LOGIN + "&password=" + PASSWORD,
            createContractor = "/" + ACCOUNT_ID + "/clients?token=",
            getAccountUsers = "/" + ACCOUNT_ID + "/users/" + ACCOUNT_USER_ID + "?token=",
            createDeliveryBill = "/" + ACCOUNT_ID + "/" + ACCOUNT_USER_ID + "/sendings?token=",
            getDeliveryBill = "/" + ACCOUNT_ID + "/sendings/",
            delDeliveryBill = "/" + ACCOUNT_ID + "/" + ACCOUNT_USER_ID + "/sendings/",
            delFirstContractor = "/" + ACCOUNT_ID + "/clients/",
            delSecondContractor = "/" + ACCOUNT_ID + "/clients/",
            getFirstContractorData = "/" + ACCOUNT_ID + "/clients/",
            getSecondContractorData = "/" + ACCOUNT_ID + "/clients/",
            logOutAccount = "/" + ACCOUNT_ID + "/logout?token=",
            searchCityByZip = "/search/city?zipCode=";
}
