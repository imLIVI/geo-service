import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.junit.jupiter.params.ParameterizedTest;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Locale;

public class LocalizationServiceImplTest {

    @Test
    public void test_locale_russia() {
        // Arrange
        String expected = "Добро пожаловать";
        LocalizationService localizationService = new LocalizationServiceImpl();
        // Act + Assert
        Assertions.assertEquals(expected, localizationService.locale(Country.RUSSIA));
    }

    @Test
    public void test_locale_usa() {
        // Arrange
        String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        // Act + Assert
        Assertions.assertEquals(expected, localizationService.locale(Country.USA));
    }
}
