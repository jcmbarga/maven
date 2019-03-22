package org.autodatacorp.orchestration.models.swagger;

/**
 * Created by nurico on 2016-10-25.
 */
public interface SwaggerDescriptions {

    String VIN = "Identifies a vehicle. This is a required parameter unless year, make, and model are provided as input values.";
    String COUNTRY = "Identifies a country. This country could be different than the country in which the vehicle was manufactured.";
    String USED = "Identifies whether the vehicle is used. If set to true, you can specify install options for the vehicle using other input values.";
    String VEHICLE_YEAR = "Identifies the year in which the vehicle was manufactured. This is an optional parameter unless VIN is not specified.";
    String VEHICLE_MAKE =  "Identifies the vehicle make. This is an optional parameter unless VIN is not specified.";
    String VEHICLE_MODEL =  "Identifies the vehicle model. This is an optional parameter unless VIN is not specified.";
    String VEHICLE_TRIM = "Identifies the vehicle trim. If you submit a VIN that returns multiple style ids, you can specify a trim to focus the response on one style id.";
    String VEHICLE_BODY_STYLE = "Identifies the vehicle body style to install on the vehicle.";
    String VEHICLE_ENGINE = "Identifies the vehicle engine code to install on the vehicle.";
    String VEHICLE_TRANS = "Identifies the vehicle transmission to install on the vehicle.";
    String VEHICLE_EXT_COLOR = "Identifies the vehicle's exterior color to install on the vehicle.";
    String VEHICLE_INT_COLOR = "Identifies the vehicle's interior color to install on the vehicle.";
    String LIST_OPTIONS = "Identifies a list of vehicle options to install on the vehicle.";
    String LIST_UNSTRUCTURED = "Identifies unstructured text that is mapped to the vehicle features you want installed on the vehicle.";

    String INCLUDE_DEBUG_INFO = "Include debug information in the response object";
    String INCLUDE_SUPPORT_INFO = "Include support information in the response object";

    String LANGUAGE = "Language";

    String GET_WS_VERSION = "Get the version of the web service";
    String GET_WS_HEALTH = "Check the health of the services";
    String GET_WS_CONNECTION = "Get the status of micro service connections";

    String WS_RESPONSE_ID = "Displays a unique identifier of the web service response.";
    String WS_DATE_TIME = "Displays the date and time on the server when the request was made.";

    String WS_MESSAGE = "Displays messages from the server.";
    String WS_ERROR =  "Identifies whether an error occurred with the request.";
    String EXECUTION_TIME = "Displays the execution time of the request in milliseconds.";
    String WS_DEBUG_INFO = "Displays debug information.";
    String WS_SUPPORT_INFO = "Displays support information.";
    String WS_RESULT = "Displays the web service results.";
    String WS_EXECUTION_DETAILS = "Displays Akana related billing informations.";
    String WS_COPYRIGHT = "Displays the copywrite message.";

}
