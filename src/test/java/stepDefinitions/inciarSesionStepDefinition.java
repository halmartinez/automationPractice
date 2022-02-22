package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import tasks.iniciarSesionTask;
import userInterfaces.paginaPrincipalPageUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static questions.verificarUsuarioQuestion.usuarioLogueado;

public class inciarSesionStepDefinition
{
    @Managed(driver = "edge")
    private WebDriver navegadorWeb;

    //Actor actor = new Actor("Hugo Alberto");

    paginaPrincipalPageUI paginaPrincipalPageUI = new paginaPrincipalPageUI();

    //Preparamos el Stage, del escenario para el usuario
    @Before
    public void setStage()
    {
        setTheStage(new OnlineCast());
    }

    @Dado("^El usuario (.*) desea iniciar sesion en la aplicacion$")
    public void elUsuarioDeseaIniciarSesionEnLaAplicacion(String nombre)
    {
        /*actor.can(BrowseTheWeb.with(navegadorWeb));
        actor.wasAbleTo(
                Open.browserOn(paginaPrincipal)
        );*/

        theActorCalled(nombre)
                .can(BrowseTheWeb.with(navegadorWeb));

        theActorInTheSpotlight()
                .wasAbleTo(Open.browserOn(paginaPrincipalPageUI));
    }

    @Cuando("Ingresa el usuario {string} y contrasena {string}")
    public void ingresaElUsuarioYContrasena(String usuario, String contrasena)
    {
        theActorInTheSpotlight().wasAbleTo(
                iniciarSesionTask.credencialesDeAcceso(usuario, contrasena)
        );
    }

    @Entonces("^Ingresa a pagina principal y valida el usuario (.*)$")
    public void ingresaAPaginaPrincipalYValidaElUsuario(String usuarioLogueado)
    {
        System.out.println("usuarioLogueado: " + usuarioLogueado);
        System.out.println("usuarioLogueado(): " + usuarioLogueado());

        theActorInTheSpotlight().should(
                seeThat(
                        usuarioLogueado(), IsEqual.equalTo(usuarioLogueado)
                )
        );
    }
}
