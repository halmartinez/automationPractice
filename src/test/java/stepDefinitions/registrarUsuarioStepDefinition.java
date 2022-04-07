package stepDefinitions;

import abilities.getInfoExcelFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import tasks.diligenciarFormularioDeRegistroExcelFileTask;
import tasks.diligenciarFormularioDeRegistroTask;
import tasks.solicitarRegistroDeUsuarioTask;
import userInterfaces.paginaPrincipalPageUI;

import static abilities.getInfoExcelFile.getCellData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static questions.verificarUsuarioQuestion.usuarioLogueado;

public class registrarUsuarioStepDefinition
{
    @Managed(driver = "chrome")
    private WebDriver navegadorWeb;

    Actor HugoAlberto = new Actor("Hugo Alberto");

    paginaPrincipalPageUI páginaPrincipal = new paginaPrincipalPageUI();

    @Before
    public void configurarNavegador()
    {
        HugoAlberto.can(
                BrowseTheWeb.with(navegadorWeb)
        );
    }

    @Given("El usuario ingresa a la página para registrarse")
    public void elUsuarioIngresaALaPáginaParaRegistrarse() {
        /** El actor fue capaz de abrir el navegador en la página principal*/
        HugoAlberto.wasAbleTo(
                Open.browserOn(páginaPrincipal)
        );
    }

    @When("el usuario digita su correo electrónico {string} y hace clic en crear cuenta")
    public void elUsuarioDigitaSuCorreoElectrónicoYHaceClicEnCrearCuenta(String email)
    {
        HugoAlberto.wasAbleTo(
                solicitarRegistroDeUsuarioTask.conCorreoElectronico(email)
        );

    }

    @Then("Diligencia el formulario de registro y hace clic en el botón registrarse")
    public void diligenciaElFormularioDeRegistroYHaceClicEnElBotónRegistrarse(DataTable datosDelUsuario){
        HugoAlberto.wasAbleTo(
                solicitarRegistroDeUsuarioTask
                        .conCorreoElectronico(
                                datosDelUsuario.asList().get(2)
                        ),
                diligenciarFormularioDeRegistroTask
                        .conLosSiguientesDatos(datosDelUsuario.asList())
        );
    }

    @And("Se visualiza el nombre de usuario exitosamente {string}")
    public void SeVisualizaElNombreDeUsuarioExitosamente(String usuarioLogueado)
    {
        HugoAlberto.should(
                seeThat(
                        usuarioLogueado(usuarioLogueado), IsEqual.equalTo(usuarioLogueado)
                )
        );
    }

    /** ------------------------------------------------------------------------------------------------------------- */
    /** Pasos para leer archivo de Excel +When+ y +Then+ */
    /** ------------------------------------------------------------------------------------------------------------- */
    @When("el usuario ingresa los datos de registro desde Excel")
    public void elUsuarioIngresaLosDatosDeRegistroDesdeExcel()
    {
        HugoAlberto.can(getInfoExcelFile.by("src/test/resources/data/data.xlsx", "data"));

        HugoAlberto.wasAbleTo(
                solicitarRegistroDeUsuarioTask
                        .conCorreoElectronico(
                                getCellData(1,3)
                        ),
                diligenciarFormularioDeRegistroExcelFileTask
                        .conLosSiguientesDatos(
                                getCellData(1,0),
                                getCellData(1,1),
                                getCellData(1,2),
                                getCellData(1,3),
                                getCellData(1,4),
                                getCellData(1,5),
                                getCellData(1,6),
                                getCellData(1,7),
                                getCellData(1,8),
                                getCellData(1,9),
                                getCellData(1,10)
                        )
        );
    }

    @Then("Se visualiza el nombre de usuario exitosamente")
    public void seVisualizaElNombreDeUsuarioExitosamente()
    {
        HugoAlberto.should(
                seeThat(
                        usuarioLogueado(getCellData(1,10))
                        , IsEqual.equalTo(getCellData(1,10))
                )
        );
    }

}
