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
        HttpSession session = req.getSession(true);
        Client client = null;
        String mail = (String) req.getParameter("mail");
        String rawPassword = (String) req.getParameter("rawPassword");
        
        
        try {
            client = Service.authenticate(mail, rawPassword);
            if (client != null) {
                result = true;
                session.setAttribute("Id", client.getId());
                req.setAttribute("client", client);
                System.out.println("On est bon");
            } else {
                result = false;
                System.out.println("On est pas bon");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            result = false;
        }
        
        req.setAttribute("success", result);
    }
    
}
