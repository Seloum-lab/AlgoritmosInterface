/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Admin;

import Controller.Action;
import Metier.Modele.Client;
import Metier.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class GetListClient extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        List<Client> clientList = null;
        boolean success;
        
        try {
            clientList = Service.getListClient();
            success = true;
        } catch (Exception ex) {
            success = false;
            System.out.println(ex);
        }
        
        req.setAttribute("success", success);
        req.setAttribute("clientList", clientList);
    }
    
}
