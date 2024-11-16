/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Admin;

import Controller.Action;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class AddAdminAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        boolean success;
        
        try {
            success = Service.addAdmin(mail, password);
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        req.setAttribute("success", success);
    }
    
}
