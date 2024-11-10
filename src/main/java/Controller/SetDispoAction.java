/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class SetDispoAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("Id");
        String jsonString = req.getParameter("dispo");
        boolean success = false;
        
        //Deserialize the json
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
        boolean[][] dispo = gson.fromJson(jsonArray, boolean[][].class);
        for (boolean[] table : dispo) {
            for (boolean bool : table) {
                System.out.println(bool);
            }
        }
        
        try {
            success = Service.setClientDisponibility(dispo, id);
        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("success", success);
        
                
    }
    
}
