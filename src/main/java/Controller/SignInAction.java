/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Client;
import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class SignInAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        boolean result = false;
        Client client = null;
        String mail = (String) req.getParameter("mail");
        String rawPassword = (String) req.getParameter("rawPassword");
        
        
        try {
            client = Service.authenticate(mail, rawPassword);
            if (client != null) {
                HttpSession session = req.getSession(true);
                result = true;
                session.setAttribute("Id", client.getId());
            } else {
                result = false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            result = false;
        }
        req.setAttribute("client", client);
        req.setAttribute("success", result);
    }
    
}
