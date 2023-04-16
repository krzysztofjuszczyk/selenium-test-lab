import config.Config;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Lab_18_Test_Tworzenia_Charakterystyki_Test extends SeleniumBaseTest {
    @Test
    public void addCharacteristic() {
        String processName = "DEMO PROJECT";

        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "1";
        String usl = "1";
        String binCount = "";

        new LoginPage(driver)
                .typeEmail(config.getUsername())
                .typePassword(config.getPassword())
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(processName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreateCharacteristic()
//                .addNewCharacteristic(processName, characteristicName, lsl, usl, binCount)
                .assertCharacteristic(characteristicName, lsl, usl, binCount);


    }
}
