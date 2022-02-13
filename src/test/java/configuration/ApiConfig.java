package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/secret.properties"
})
public interface ApiConfig extends Config {

    @Key("webUrl")
    @DefaultValue("https://nrg-tk.ru/")
    String getWebUrl();

    @Key("baseUrl")
    @DefaultValue("https://mainapi.nrg-tk.ru/v3")
    String getBaseUrl();

    @Key("searchUrl")
    @DefaultValue("https://nrg-tk.ru/search/")
    String getSearchUrl();

    @Key("nrgApiDevToken")
    String nrgApiDevToken();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("accountId")
    String accountId();

    @Key("accountUserId")
    String accountUserId();

    @Key("accountUserPhone")
    String accountUserPhone();

}