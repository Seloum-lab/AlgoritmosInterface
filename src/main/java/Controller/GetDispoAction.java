/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetDispoAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("Id");
        boolean[][] dispo = null;
        
        try {
            dispo = Service.getClientById(id).getClientDisponibilities();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("dispo", dispo);
        
        
    }
    
}
