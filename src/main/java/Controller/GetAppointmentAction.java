/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Appointment;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetAppointmentAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("appointmentId");
        Appointment appointment = null;
        
        try {
            appointment = Service.getAppointmentById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("appointment", appointment);
    }
    
}
