package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class registrarUsuarioStepDefinition
{
    @Managed(driver = "edge")
    private WebDriver navegadorWeb;

    Actor HugoAlberto = new Actor("Hugo Alberto");

    @Before
    public void configurarNavegador()
    {
        HugoAlberto.can(
                BrowseTheWeb.with(navegadorWeb)
        );
    }

    @Given("El usuario ingresa a la página para registrarse")
    public void elUsuarioIngresaALaPáginaParaRegistrarse(io.cucumber.datatable.DataTable dataTable)
    {
        //miNavegador.manage().window().maximize();
    }

    @When("el usuario intruce los datos requeridos y hace clic en registrarse")
    public void elUsuarioIntruceLosDatosRequeridosYHaceClicEnRegistrarse()
    {

    }

    @Then("Aparece mensaje de registroso")
    public void apareceMensajeDeRegistroso()
    {

    }
}
