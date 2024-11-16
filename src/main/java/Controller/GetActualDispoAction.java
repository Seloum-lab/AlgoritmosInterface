/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Metier.Modele.Client;
import Metier.Service.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetActualDispoAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        boolean hidden = Boolean.parseBoolean(req.getParameter("hidden"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("date"), formatter);
        Client.Status[][] dispo = null;
        boolean success = false;
        HttpSession session = req.getSession(false);
        Long id = Long.parseLong(req.getParameter("id"));
        Long publicationId = null;

        
        try {
            if (id == -1) {
                publicationId = (Long) session.getAttribute("publicationId");
                id = Service.getPublicationById(publicationId).getClient().getId();
                dispo = Service.getActualDispo(id, date);
            } else {
                dispo = Service.getActualDispo(id, date);
            }
            success = true;
        } catch(Exception ex) {
            System.out.println(ex);
            success = false;
        }
        
        if (hidden && dispo != null) {
            assert(dispo.length == 7);
            //TODO add the conversion from ClientStatus to bool
            boolean[][] boolDispo = new boolean[7][14];
            for (int day = 0; day < 7; day++) {
                assert(dispo[day].length == 12);
                for (int hour = 0; hour < 12; hour++) {
                    boolDispo[day][hour] = (dispo[day][hour] == Client.Status.FREE);
                }
            req.setAttribute("dispo", boolDispo);
            }
        } else {
            req.setAttribute("dispo", dispo);
        }
        
        req.setAttribute("success", success);
        
    }
    
}
