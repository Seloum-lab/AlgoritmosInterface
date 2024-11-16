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
public class GetToPayAppointmentAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("Id");
        List<Appointment> result = null;
        boolean success= false;
        
        try {
            result = Service.getToPayAppointment(id);
            success = true;
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        req.setAttribute("success", success);
        req.setAttribute("listAppointment", result);
    }
    
}
