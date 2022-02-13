package base;

import static yahoo.andreikuzn.pages.ApiArea.*;

public class ApiEndpoints {

        public static final String userLogin = "/login?user=" + LOGIN
                + "&password=" + PASSWORD;
        public static final String createContractor = "/" + ACCOUNT_ID
                + "/clients?token=";
        public static final String getAccountUsers = "/" + ACCOUNT_ID
                + "/users/" + ACCOUNT_USER_ID + "?token=";
        public static String createDeliveryBill = "/" + ACCOUNT_ID
                + "/" + ACCOUNT_USER_ID + "/sendings?token=";
        public static final String getDeliveryBill = "/" + ACCOUNT_ID
                + "/sendings/";
        public static final String delDeliveryBill = "/" + ACCOUNT_ID
                + "/" +  ACCOUNT_USER_ID + "/sendings/";
        public static final String delFirstContractor = "/" + ACCOUNT_ID
                + "/clients/";
        public static final String delSecondContractor = "/" + ACCOUNT_ID
                + "/clients/";
        public static final String getFirstContractorData = "/" + ACCOUNT_ID
                + "/clients/";
        public static final String getSecondContractorData = "/" + ACCOUNT_ID
                + "/clients/";
        public static final String logOutAccount = "/" + ACCOUNT_ID + "/logout?token=";

        public static final String searchCityByZip = "/search/city?zipCode=";

}

