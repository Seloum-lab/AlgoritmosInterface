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
        HttpSession session = req.getSession(true);
        Client client = null;
        String mail = (String) req.getAttribute("mail");
        String rawPassword = (String) req.getAttribute("rawPassword");
        
        
        try {
            client = Service.authenticate(mail, rawPassword);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("client", client);
    }
    
}
