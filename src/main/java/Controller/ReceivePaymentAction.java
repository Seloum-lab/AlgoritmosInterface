/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Payment;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class ReceivePaymentAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("appointmentId");
        String method = req.getParameter("method");
        boolean success;
        
        try {
            success = Service.validatePaymentFromWorker(id, Payment.Method.valueOf(method));
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        req.setAttribute("success", success);
    }
    
}
