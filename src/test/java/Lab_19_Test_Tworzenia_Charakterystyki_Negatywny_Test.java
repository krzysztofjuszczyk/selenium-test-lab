import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Lab_19_Test_Tworzenia_Charakterystyki_Negatywny_Test extends SeleniumBaseTest{
    @Test
    public void addCharacteristicNegative(){
        String characteristicName = UUID.randomUUID().toString().substring(0,10);
        String lsl = "3";
        String usl = "4";
        String errorMessage = "The value 'Select process' is not valid for ProjectId.";

        new LoginPage(driver)
                .typeEmail(config.getUsername())
                .typePassword(config.getPassword())
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                    .typeName(characteristicName)
                    .typeLsl(lsl)
                    .typeUsl(usl)
                .submitCreateWithFailure()
                .assertProcessError(errorMessage)
                .backToList()
                .assertCharacteristicIsNotShown(characteristicName);
//                .addNewCharacteristic("",characteristicName,lsl,usl,"")

    }
}
