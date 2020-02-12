/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author Morgan
 */
public class MetarRequestUtil {

    
    
    public static metar.Metar getMetarByTimeRange(String stationName, Date debut, Date fin) throws JAXBException {
        //date doit etre sous forme : YYYY-02-11T22:53:00Z
        DateFormat datef = new SimpleDateFormat("yyyy-mm-ddThh:mm:ss");
        String debutStr = datef.format(debut);
        String finStr = datef.format(fin);
        
        InputStream result = GetXmlFromWS("https://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml&startTime="+debutStr+"&endTime="+finStr+"&stationString="+stationName);
        
        JAXBContext jc = JAXBContext.newInstance("generated");
        Unmarshaller u = jc.createUnmarshaller();
        metar.Metar met = (metar.Metar) u.unmarshal(result);
        
        return met;
    }

    private static InputStream GetXmlFromWS(String lien) {
        try {

            URL url = new URL(lien);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            return conn.getInputStream();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return null;
    }

}
