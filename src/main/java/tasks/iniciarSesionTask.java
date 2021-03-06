package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.iniciarSesionYRegistrarUsuarioPageUI.BOTON_SIGN_IN;
import static userInterfaces.iniciarSesionYRegistrarUsuarioPageUI.INPUT_CONTRASENA;
import static userInterfaces.iniciarSesionYRegistrarUsuarioPageUI.INPUT_EMAIL;
import static userInterfaces.paginaPrincipalPageUI.LNK_SIGN_IN;

public class iniciarSesionTask implements Task
{
    private String usuario, contrasena;

    public iniciarSesionTask(String usuario, String contrasena)
    {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(
                Click.on(LNK_SIGN_IN),
                Enter.theValue(usuario).into(INPUT_EMAIL),
                Enter.theValue(contrasena).into(INPUT_CONTRASENA),
                Click.on(BOTON_SIGN_IN)
        );
    }

    public static iniciarSesionTask conCredencialesDeAcceso(String usuario, String password)
    {
        return instrumented(iniciarSesionTask.class, usuario, password);
    }
}
