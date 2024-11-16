/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serialization;

import Metier.Modele.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class ClientListSerialization extends Serialization {

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        
        boolean success = (boolean) req.getAttribute("success");
        
        if (success) {
            
            JsonArray clientListJson = new JsonArray();
            List<Client> clientList = (List<Client>) req.getAttribute("clientList");

            for (Client client : clientList) {
                JsonObject clientJson = new JsonObject();
                clientJson.addProperty("mail", client.getMail());
                clientJson.addProperty("id", client.getId());
                clientJson.addProperty("firstName", client.getFirstName());
                clientJson.addProperty("lastName", client.getLastName());

                clientListJson.add(clientJson);
            }

            container.add("clientList", clientListJson);
        }
        container.addProperty("success", success);
        
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();
    }
    
}
