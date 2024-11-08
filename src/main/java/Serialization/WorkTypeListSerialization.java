/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serialization;

import Metier.Modele.WorkType;
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
public class WorkTypeListSerialization extends Serialization{

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        List<WorkType> workTypeList = (List<WorkType>) req.getAttribute("workTypeList");
        
        if (workTypeList == null)  {
            container.addProperty("success", false);
        } else {
            JsonArray workTypeListJson = new JsonArray();
            for (WorkType element : workTypeList) {
                JsonObject workTypeJson = new JsonObject();
                workTypeJson.addProperty("name", element.getWorktype());
                workTypeListJson.add(workTypeJson);
            }
            container.addProperty("success", true);
            container.add("workTypeList", workTypeListJson);
        }
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();
        
    }
    
}
