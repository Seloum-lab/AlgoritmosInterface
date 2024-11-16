/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Admin;

import Controller.Action;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class ConnectAsClientAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long adminId = (Long) session.getAttribute("adminId");
        Long clientId = Long.parseLong(req.getParameter("id"));
        boolean success = false;
        
        try {
            success = !(Service.getAdminById(adminId) == null);
            if (success) {
                session.setAttribute("Id", clientId);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
            session.removeAttribute("Id");
        }
        
        req.setAttribute("success", success);
    }
    
}
