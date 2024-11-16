/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class AddNoteAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long Appointmentid = (Long) session.getAttribute("appointmentId");
        Integer note = Integer.parseInt(req.getParameter("note"));
        boolean success = false;
        
        try {
            Long id = Service.getAppointmentById(Appointmentid).getPublication().getId();
            success = Service.addNote(id, note);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
            success = false;
        } 
        
        req.setAttribute("success", success);
    }
    
}
