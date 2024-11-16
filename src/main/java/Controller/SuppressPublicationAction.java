/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class SuppressPublicationAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        boolean success = false;
        
        try {
            success = Service.cancelAppointment(id);
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        req.setAttribute("success", success);
    }
    
}
