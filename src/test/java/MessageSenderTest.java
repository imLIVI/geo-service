import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.entity.Location.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderTest {
    @Test
    public void test_send_to_russia() {
        // Arrange
        String expected = "Добро пожаловать";

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();

        // Act - rule
        Mockito.when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).
                thenReturn("Добро пожаловать");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        // Assert
        Assertions.assertEquals(expected, messageSender.send(headers));
    }

    @Test
    public void test_send_to_usa() {
        // Arrange
        String expected = "Welcome";

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();

        // Act - rule
        Mockito.when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA)).
                thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.45.183.149");

        // Assert
        Assertions.assertEquals(expected, messageSender.send(headers));
    }
}
