/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.WorkType;
import Metier.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class GetWorkTypeAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        List<WorkType> result = null;
        
        try {
            result = Service.getWorkTypeList();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("workTypeList", result);
    }
    
}
