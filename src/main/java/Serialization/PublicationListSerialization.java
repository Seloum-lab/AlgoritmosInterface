/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serialization;

import Metier.Modele.Publication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class PublicationListSerialization extends Serialization {

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("d 'of' MMMM, yyyy");
        
        List<Publication> publicationList = (List<Publication>) req.getAttribute("publicationList");
        
        if (publicationList == null){
            container.addProperty("success", false);            
        } else {
            JsonArray publicationListJson = new JsonArray();
            for (Publication element : publicationList) {
                JsonObject publicationJson = new JsonObject();
                publicationJson.addProperty("workType", element.getWorkType().getWorktype());
                publicationJson.addProperty("id", element.getId());
                publicationJson.addProperty("title", element.getTitle());
                publicationJson.addProperty("description", element.getDescription());
                publicationJson.addProperty("note", element.getAverage());
                publicationJson.addProperty("price", element.getPrice());
                publicationJson.addProperty("numberNotes", element.getNumberNotes());
                publicationJson.addProperty("publisher", element.getClient().getFirstName() + element.getClient().getLastName());
                publicationJson.addProperty("date", sdf.format(element.getDate()));
                publicationListJson.add(publicationJson);
            }
            
            container.addProperty("success", true);
            container.add("publicationList", publicationListJson);
            
            
            
        }
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();
    }
    
}
