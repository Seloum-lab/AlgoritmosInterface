/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Publication;
import Metier.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class GetListPublicationAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean success = false;
        List<Publication> result = null;
        double distance = Double.parseDouble(req.getParameter("distance"));
        
        try {
            result = Service.getListPublicationDistance(distance);
            success = true;
        } catch (Exception ex) {
            success = false;            
        }
        
        req.setAttribute("success", success);
        req.setAttribute("publicationList", result);
    }
    
}
