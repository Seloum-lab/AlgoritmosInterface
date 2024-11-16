/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class ClearSessionAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Enumeration<String> attributeNames = session.getAttributeNames();
        
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            if (!attributeName.equals("Id")) {
                session.removeAttribute(attributeName);
            }
        }
    }
    
}
