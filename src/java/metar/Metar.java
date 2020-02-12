/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metar;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Morgan
 */
@WebService(serviceName = "Metar")
public class Metar {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    //NB HEURES AVANT
    //https://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml&stationString=KDEN%20KSEA%20PHNL&hoursBeforeNow=2

    //TIMERANGE
    //https://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml&startTime=2020-02-12T05:13:17+0700&endTime=2020-02-12T07:13:17+0700&stationString=PHTO

    // parametres possibles stationString AVEC startTime et endTime OU AVEC hoursBeforeNow

}
