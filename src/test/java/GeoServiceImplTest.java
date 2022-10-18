import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"172.10.32.11", "172.123.12.19"})
    public void by_russia_ip_test(String ip) {
        // Arrange
        GeoService geo = new GeoServiceImpl();
        Country expected = Country.RUSSIA;
        // Act + Assert
        Assertions.assertEquals(expected, geo.byIp(ip).getCountry());
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.34.183.149", "96.123.12.19"})
    public void byUsaIpTest(String ip) {
        // Arrange
        GeoService geo = new GeoServiceImpl();
        Country expected = Country.USA;
        // Act + Assert
        Assertions.assertEquals(expected, geo.byIp(ip).getCountry());
    }
}
