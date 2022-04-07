package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.iniciarSesionYRegistrarUsuarioPageUI.BOTON_CREATE_ACCOUNT;
import static userInterfaces.iniciarSesionYRegistrarUsuarioPageUI.INPUT_EMAIL_CREAR_USUARIO;
import static userInterfaces.paginaPrincipalPageUI.LNK_SIGN_IN;

public class solicitarRegistroDeUsuarioTask implements Task
{
    private String email;

    public solicitarRegistroDeUsuarioTask(String email)
    {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(
                Click.on(LNK_SIGN_IN),
                Enter.theValue(email).into(INPUT_EMAIL_CREAR_USUARIO),
                Click.on(BOTON_CREATE_ACCOUNT)
        );
    }

    public static solicitarRegistroDeUsuarioTask conCorreoElectronico(String email)
    {
        return instrumented(solicitarRegistroDeUsuarioTask.class, email);
    }
}
