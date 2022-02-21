package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${environment}.properties"})
public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("91.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteBrowserUrl")
    String remoteBrowserUrl();
}
