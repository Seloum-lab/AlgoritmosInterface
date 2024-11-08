/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Service.Service;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class PublishAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean result = false;
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("Id");
        Date date = new Date();
        Double distanceMax = Double.parseDouble(req.getParameter("distanceMax"));
        String workType = req.getParameter("workType");
        int price = Integer.parseInt(req.getParameter("price"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        
        try {
            result = Service.publish(id, date, workType, price, title, description, distanceMax);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        req.setAttribute("success", result);
    }
    
}
