/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import java.time.LocalDate;
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
        Long idPublication = Long.getLong(req.getParameter("idPublication"));
        int start = Integer.parseInt(req.getParameter("start"));
        int duration = Integer.parseInt(req.getParameter("duration"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        
        try {
            success = Service.takeAppointment(idClient, idPublication, date, duration, start);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
        
    }
    
}
