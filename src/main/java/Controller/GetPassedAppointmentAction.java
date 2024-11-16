/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Appointment;
import Metier.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetPassedAppointmentAction extends Action{
    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("Id");
        List<Appointment> listAppointmentClient = null;
        List<Appointment> listAppointmentWorker = null;
        boolean success;
        
        try {
            listAppointmentClient = Service.getPassedAppointmentAsClient(id);
            listAppointmentWorker = Service.getPassedAppointmentAsWorker(id);
            req.setAttribute("listAppointmentClient", listAppointmentClient);
            req.setAttribute("listAppointmentWorker", listAppointmentWorker);
            success = true;
        } catch (Exception ex) {
            success = false;
            System.out.println(ex);
        }
        
        req.setAttribute("success", success);
    }
    
}
