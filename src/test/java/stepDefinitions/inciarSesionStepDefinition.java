package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
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
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static questions.verificarUsuarioQuestion.usuarioLogueado;
import static userInterfaces.bandejaDeUsuarioPageUI.TEXT_NOMBRE_USUARIO_LOGUEADO;

public class inciarSesionStepDefinition
{
    @Managed(driver = "edge")
    private WebDriver navegadorWeb;

    Actor HugoAlberto = new Actor("Hugo Alberto");

    paginaPrincipalPageUI paginaPrincipal = new paginaPrincipalPageUI();

    //Preparamos el Stage, del escenario para el usuario
    /*@Before
    public void setStage()
    {
        setTheStage(new OnlineCast());
    }*/
    @Before
    public void configurarNavegador()
    {
        HugoAlberto.can(BrowseTheWeb.with(navegadorWeb));
    }

    @Dado("^El usuario (.*) desea iniciar sesion en la aplicacion$")
    public void elUsuarioDeseaIniciarSesionEnLaAplicacion(String nombre)
    {
        HugoAlberto.wasAbleTo(
                Open.browserOn(paginaPrincipal)
        );

        /*theActorCalled(nombre)
                .can(BrowseTheWeb.with(navegadorWeb));

        theActorInTheSpotlight()
                .wasAbleTo(Open.browserOn(paginaPrincipalPageUI));*/
    }

    @Cuando("Ingresa el usuario {string} y contrasena {string}")
    public void ingresaElUsuarioYContrasena(String usuario, String contrasena)
    {
        /*theActorInTheSpotlight().wasAbleTo(
                iniciarSesionTask.credencialesDeAcceso(usuario, contrasena)
        );*/
        HugoAlberto.wasAbleTo(
                iniciarSesionTask.credencialesDeAcceso(usuario, contrasena)
        );
    }

    @Entonces("^Ingresa a pagina principal y valida el usuario (.*)$")
    public void ingresaAPaginaPrincipalYValidaElUsuario(String usuarioLogueado)
    {
        //System.out.println("usuarioLogueado: " + usuarioLogueado);
        //System.out.println("usuarioLogueado(): " + usuarioLogueado());
        //System.out.println("usuarioLogueado(): " + TEXT_NOMBRE_USUARIO_LOGUEADO.resolveFor(theActorInTheSpotlight()).getText());

        /*theActorInTheSpotlight().should(
                seeThat(
                        usuarioLogueado(), IsEqual.equalTo(usuarioLogueado)
                )
        );*/
        HugoAlberto.should(seeThat(usuarioLogueado(), IsEqual.equalTo(usuarioLogueado)));
    }
}
