/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class TakeAppointmentAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean success = false;
        HttpSession session = req.getSession(false);
        Long idClient = (Long) session.getAttribute("Id");
        Long idPublication = (Long) session.getAttribute("publicationId");
        String durationString = req.getParameter("duration");
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<Integer, Set<Integer>>>(){}.getType();
        Map<Integer, Set<Integer>> duration = gson.fromJson(durationString, type);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("date"), formatter);
        
        try {
            success = Service.takeAppointment(idClient, idPublication, date, duration);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
        
    }
    
}
