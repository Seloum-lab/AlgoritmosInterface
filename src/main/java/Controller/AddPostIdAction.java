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
public class AddPostIdAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        boolean result = false;
        Long id = (Long) session.getAttribute("Id");
        Long publicationId = Long.parseLong(req.getParameter("id"));
        
        try {
            result = !Service.isClientPublication(id, publicationId);
            if (result) {
                session.setAttribute("publicationId", publicationId);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            result = false;
        }       
        
        req.setAttribute("success", result);
    }
    
}
