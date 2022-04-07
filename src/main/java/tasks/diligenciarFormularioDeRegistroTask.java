package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.formularioDeRegistroPageUI.*;

public class diligenciarFormularioDeRegistroTask implements Task
{
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final String address;
    private final String zipcode;
    private final String country;
    private final String state;
    private final String city;
    private final String mobile;

    public diligenciarFormularioDeRegistroTask(List<String> datosParaRegistro)
    {
        this.firstname  = datosParaRegistro.get(0);
        this.lastname   = datosParaRegistro.get(1);
        this.email      = datosParaRegistro.get(2);
        this.password   = datosParaRegistro.get(3);
        this.address    = datosParaRegistro.get(4);
        this.zipcode    = datosParaRegistro.get(5);
        this.country    = datosParaRegistro.get(6);
        this.state      = datosParaRegistro.get(7);
        this.city       = datosParaRegistro.get(8);
        this.mobile     = datosParaRegistro.get(9);
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo
                (
                        Enter.theValue(firstname).into(TEXT_NOMBRE),
                        Enter.theValue(lastname).into(TEXT_APELLIDOS),
                        Enter.theValue(password).into(TEXT_CONTRASENA),
                        Enter.theValue(firstname).into(TEXT_NOMBRE_2),
                        Enter.theValue(lastname).into(TEXT_APELLIDOS_2),
                        Enter.theValue(address).into(TEXT_DIRECCION),
                        Enter.theValue(city).into(TEXT_CIUDAD),
                        //Enter.theValue(state).into(LISTBOX_ESTADO_O_REGION),
                        SelectFromOptions.byVisibleText(state).from(LISTBOX_ESTADO_O_REGION),
                        Enter.theValue(zipcode).into(TEXT_CODIGO_POSTAL),
                        //Enter.theValue(country).into(TEXT_NOMBRE),
                        Enter.theValue(mobile).into(TEXT_CELULAR),
                        Click.on(BTN_REGISTRAR_USUARIO)
                );
    }

    public static diligenciarFormularioDeRegistroTask conLosSiguientesDatos(List<String> datosParaRegistro)
    {
        return instrumented(diligenciarFormularioDeRegistroTask.class, datosParaRegistro);
    }
}
