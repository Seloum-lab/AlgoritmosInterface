/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Admin;

import Controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class VerifyConnexionAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean result;
        HttpSession session = req.getSession(false);
        result = !(session == null || session.getAttribute("adminId") == null);
        
        req.setAttribute("success", result);
    }
    
}
