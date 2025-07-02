package ar.steps;

import api.config.EntityConfiguration;

import api.model.TimeTrakerMod.TimeTrakerModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import com.google.api.client.repackaged.com.google.common.base.Splitter;

import static services.BaseService.*;

import org.testng.Assert;
import utils.FechaConversion;

public class TimeTrakerSteps extends PageSteps {
    @Given("El apiKey es igual (.*)$")
    public void elApiKeyEsIgualApiKey(String apiKey) {
        API_KEY.set(apiKey);
    }

    @And("workspaces asignado igual a {string}")
    public void workspacesAsignadoIgualA(String workspacesId) {
        WORKSPACE_ID.set(workspacesId);
    }

    @And("user asignado igual a {string}")
    public void userAsignadoIgualA(String userId) {
        ID_CLIENTE.set(userId);
    }

    @When("'(.*)' a la API clockify, para entidad '(.*)', la uri '(.*)' y parametros '(.*)'")
    public void doRequest(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);

        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }
    }

    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }

    @And("se muestra lista de horas registradas")
    public void seMuestraListaDeHorasRegistradas() {

        TimeTrakerModel[] response = (TimeTrakerModel[]) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(response.length > 0, "[WARNING] La lista esta vacia");

        for (TimeTrakerModel e : response) {
            System.out.println("ID: " + e.getId());
            System.out.println("Description: " + e.getDescription());
            System.out.println("timeInterval:");
            System.out.println("\tstart: " + e.getTimeInterval().getStart());
            System.out.println("\tend: " + e.getTimeInterval().getEnd());
            System.out.println("\tduration: " + e.getTimeInterval().getDuration());
            System.out.println("");
        }
    }

    @Given("apiKey asignado igual a {string}")
    public void apikeyAsignadoIgualA(String apiKey) {
        API_KEY.set(apiKey);
    }

    @Given("registro hora inicio {string}, fin {string} y una descripcion {string}")
    public void registroHoraInicioFinYUnaDescripcion(String start, String end, String description) {
        TIME_START.set(start);
        TIME_END.set(end);
        TIME_DESCRIPTION.set(description);
    }

    @And("se registra la hora con inicio {string}, fin {string} , {string} y duracion {string}")
    public void seRegistraLaHoraConInicioFinYDuracion(String start, String end, String description, String duration) throws ParseException {
        TimeTrakerModel response = (TimeTrakerModel) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response, "[WARNING] El respose esta vacio");
        Assert.assertTrue(response.getDescription().equalsIgnoreCase(description), "[WARNING] La descripcion no coincide");
        Assert.assertTrue(response.getTimeInterval().getDuration().equalsIgnoreCase(duration), "[WARNING] La descripcion no coincide");

        String auxStart = FechaConversion.format(response.getTimeInterval().getStart().toString());
        String auxEnd = FechaConversion.format(response.getTimeInterval().getEnd().toString());

        Assert.assertTrue(auxStart.equalsIgnoreCase(start), "[WARNING] Start no coincide");
        Assert.assertTrue(auxEnd.equalsIgnoreCase(end), "[WARNING] End no coincide");


    }

    @And("se registra la hora cargada")
    public void seRegistraLaHoraCargada() {
        TimeTrakerModel response = (TimeTrakerModel) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response, "[WARNING] El respose esta vacio");
        ID_TIME_ENTRIES.set(response.getId());
    }
}
