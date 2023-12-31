import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CampoTreinamentoTest {

    CampoTreinamentoPage ct;

    @BeforeEach
    public void before() {
        ct = new CampoTreinamentoPage();
    }

    @AfterEach
    public void after() {
        ct.closeBrowser();
    }

    @Test
    public void deveInteragirComTextbox() {
        By by = By.id("elementosForm:nome");
        ct.insertText(by, "Olá, Mundo");
        assertEquals("Olá, Mundo", ct.getElementValue(by));
    }

    @Test
    public void deveInteragirComTextArea() {
        By by = By.id("elementosForm:sugestoes");
        ct.insertText(by, "Texto no text area");
        assertEquals("Texto no text area", ct.getElementValue(by));
    }

    @Test
    public void deveInteragirComRadioButton() {
        By by = By.id("elementosForm:sexo:0");
        ct.clickOnElement(by);
        assertTrue(ct.isElementSelected(by));
    }

    @Test
    public void deveInteragirComCheckbox() {
        By by = By.id("elementosForm:comidaFavorita:0");
        ct.clickOnElement(by);
        assertTrue(ct.isElementSelected(by));
    }

    @Test
    public void deveInteragirComCombobox() {
        By by = By.id("elementosForm:escolaridade");
        ct.selectValueOnCombobox(by, "Superior");

        String scholarship = ct.getSelectedValueOnCombobox(by);
        assertEquals("Superior", scholarship);
    }

    @Test
    public void deveInteragirComComboMultiplo() {
        By by = By.id("elementosForm:esportes");
        String[] texts = {"Natacao", "Corrida", "Karate"};
        ct.selectMultipleValuesOnCombobox(by, texts);

        ArrayList<String> sports = ct.getSelectedValuesOnCombobox(by);
        assertEquals(3, sports.size());
        for (String text :
                texts) {
            assertTrue(sports.contains(text));
        }
    }

    @Test
    public void deveInteragirComBotaoCliqueMe() {
        By by = By.id("buttonSimple");
        ct.clickOnElement(by);

        String buttonValue = ct.getElementValue(by);
        assertEquals("Obrigado!", buttonValue);
    }

    @Test
    public void deveInteragirComLinkVoltar() {
        ct.clickOnLink("Voltar");

        By by = By.id("resultado");
        String resultText = ct.getElementText(by);
        assertEquals("Voltou!", resultText);
    }

    @Test
    public void deveValidarTituloDaPagina() {
        By by = By.tagName("h3");
        String headerText = ct.getPageHeader(by);
        assertEquals("Campo de Treinamento", headerText);
    }

}
