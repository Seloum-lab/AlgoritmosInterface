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
public class SignUpAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        boolean success;
        String firstName = (String) req.getAttribute("firstName");
        String lastNam = (String) req.getAttribute("lastName");
        String mail = (String) req.getAttribute("mail");
        String rawPassword = (String) req.getAttribute("rawPassword");
        String phoneNumber = (String) req.getAttribute("phoneNumber");
        String address = (String) req.getAttribute("address");
        
        
        try {
            success = Service.signUp(firstName, lastNam, mail, rawPassword, phoneNumber, address);
        } catch (Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        req.setAttribute("success", success);
        
    }
    
}
