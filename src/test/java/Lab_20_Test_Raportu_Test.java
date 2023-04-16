import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_20_Test_Raportu_Test extends SeleniumBaseTest  {
    @Test
    public void reportTest(){
        String processName = "DEMO PROJECT";
//        String characteristicName = UUID.randomUUID().toString().substring(0,10);
        String characteristicName = "abcde";
        String lsl = "9";
        String expLsl = "9.0000";
        String usl = "1";
        String expUsl = "1.0000";
        String sampleName = "Test sample";
        String results = "8.0;9.0";
        String expMean = "8.5000";

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
                .clickResultsPage(characteristicName)
                .clickAddResults()
                .typeSampleTxt(sampleName)
                .typeResults(results)
                .submitCreate()
                .backToCharacteristics()
                .clickReportPage(characteristicName)
                .assertMean(expMean)
                .assertLsl(expLsl)
                .assertUsl(expUsl)
        ;

    }
}
