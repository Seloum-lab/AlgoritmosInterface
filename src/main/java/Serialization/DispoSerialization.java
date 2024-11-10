/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class DispoSerialization extends Serialization{

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        
        boolean[][] dispo = (boolean[][]) req.getAttribute("dispo");
        String[] daysOfWeek = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        
        if (dispo == null) {
            System.out.println("C'est ici qu'on a un bon problème");
            container.addProperty("success", false);
        } else {
            container.addProperty("success", true);
            for (int day = 0; day < dispo.length; day++) {
                JsonObject dayJson = new JsonObject();
                for (int hour = 0; hour< dispo[0].length; hour++) {
                    dayJson.addProperty(Integer.toString(hour+1), dispo[day][hour]);
                }
                container.add(daysOfWeek[day], dayJson);
            }
        }
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();
        
    }
    
}
