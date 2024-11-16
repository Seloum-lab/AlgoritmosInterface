/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class VerifyConnexionAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        boolean success = false;
        if (session == null) {
            success = false;
        } else if (session.getAttribute("Id") != null){
            success = true;
        } else {
            success = false;
        }     
        req.setAttribute("success", success);
    }
    
}
