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
public class AddWorkTypeAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean success = false;
        String workTypeName = req.getParameter("workTypeName");
        
        try {
            success = Service.addWorkType(workTypeName);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        req.setAttribute("success", success);
        
    }
    
}
