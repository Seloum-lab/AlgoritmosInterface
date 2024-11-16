/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Admin;

import Controller.Action;
import Metier.Modele.Admin;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class AuthenticateAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean result = false;
        Admin admin = null;
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        
        try {
            admin = Service.authenticateAdmin(mail, password);
            if (admin != null) {
                HttpSession session = req.getSession(true);
                result = true;
                session.setAttribute("adminId", admin.getId());
            } else {
                result = false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            result = false;
        }
        
        req.setAttribute("success", result);
    }
    
}
