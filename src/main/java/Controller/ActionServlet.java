/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.JpaUtil;
import Serialization.ActualDispoSerialization;
import Serialization.DispoSerialization;
import Serialization.PublicationListSerialization;
import Serialization.SignInSerialization;
import Serialization.SuccessSerialization;
import Serialization.WorkTypeListSerialization;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sbenbouzid
 */




@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
   
            /* TODO output your page here. You may use following sample code. */
            String todo = request.getParameter("todo");
            System.out.println("-------------------------------- todo = " + todo);
            
            
            switch(todo) {
                case "signUp":
                    System.out.println("--------------------------SignUp");
                    SignUpAction signUpAction = new SignUpAction();
                    signUpAction.execute(request);
                    SuccessSerialization successSerialization = new SuccessSerialization();
                    successSerialization.serialize(request, response);
                    break;
                    
                case "verifyConnexion":
                    System.out.println("--------------------------verifyConnexion");
                    VerifyConnexionAction verifyConnexionAction = new VerifyConnexionAction();
                    verifyConnexionAction.execute(request);
                    SuccessSerialization successSerialization1 = new SuccessSerialization();
                    successSerialization1.serialize(request, response);
                    break;
                    
                case "signIn":
                    System.out.println("--------------------------signIn");
                    SignInAction signInAction = new SignInAction();
                    signInAction.execute(request);
                    SignInSerialization signInSerialization = new SignInSerialization();
                    signInSerialization.serialize(request, response);
                    break;
                    
                case "disconnect" :
                    System.out.println("--------------------------disconnect");
                    DisconnectAction disconnectAction = new DisconnectAction();
                    disconnectAction.execute(request);
                    SuccessSerialization successSerialization2 = new SuccessSerialization();
                    successSerialization2.serialize(request, response);
                    break;
                    
                case "getWorkType" :
                    System.out.println("--------------------------getWorkType");
                    GetWorkTypeAction getWorkTypeAction = new GetWorkTypeAction();
                    getWorkTypeAction.execute(request);
                    WorkTypeListSerialization workTypeListSerialization = new WorkTypeListSerialization();
                    workTypeListSerialization.serialize(request, response);
                    break;
                    
                case "publish" :
                    System.out.println("--------------------------publish");
                    PublishAction publishAction = new PublishAction();
                    publishAction.execute(request);
                    SuccessSerialization successSerialization3 = new SuccessSerialization();
                    successSerialization3.serialize(request, response);
                    break;
                    
                case "getPublicationList" :
                    System.out.println("--------------------------getPublicationList");
                    GetListPublicationAction getListPublicationAction = new GetListPublicationAction();
                    getListPublicationAction.execute(request);
                    PublicationListSerialization publicationListSerialization = new PublicationListSerialization();
                    publicationListSerialization.serialize(request, response);
                    break;
                    
                case "getPublicationToApproveList" :
                    System.out.println("--------------------------getPublicationToApproveList");
                    GetPublicationToApproveAction getPublicationToApproveAction = new GetPublicationToApproveAction();
                    getPublicationToApproveAction.execute(request);
                    PublicationListSerialization publicationListSerialization1 = new PublicationListSerialization();
                    publicationListSerialization1.serialize(request, response);
                    break;
                    
                case "addWorkType" :
                    System.out.println("--------------------------addWorkType");
                    AddWorkTypeAction addWorkTypeAction = new AddWorkTypeAction();
                    addWorkTypeAction.execute(request);
                    SuccessSerialization successSerialization4 = new SuccessSerialization();
                    successSerialization4.serialize(request, response);
                    break;
                    
                case "acceptPublication" :
                    System.out.println("--------------------------acceptPublication");
                    ValidatePublicationAction validatePublicationAction = new ValidatePublicationAction();
                    validatePublicationAction.execute(request);
                    SuccessSerialization successSerialization5 = new SuccessSerialization();
                    successSerialization5.serialize(request, response);
                    break;
                    
                case "rejectPublication" :
                    System.out.println("--------------------------rejectPublication");
                    RejectPublicationAction rejectPublicationAction = new RejectPublicationAction();
                    rejectPublicationAction.execute(request);
                    SuccessSerialization successSerialization6 = new SuccessSerialization();
                    successSerialization6.serialize(request, response);
                    break;
                    
                case "addPostId" :
                    System.out.println("--------------------------addPostId");
                    AddPostIdAction addPostIdAction = new AddPostIdAction();
                    addPostIdAction.execute(request);  
                    break;
                    
                    
                case "getDispo" :
                    System.out.println("--------------------------getDispo");
                    GetDispoAction getDispoAction = new GetDispoAction();
                    getDispoAction.execute(request);
                    DispoSerialization dispoSerialization = new DispoSerialization();
                    dispoSerialization.serialize(request, response);
                    break;
                    
                case "setDispo" :
                    System.out.println("--------------------------setDispo");
                    SetDispoAction setDispoAction = new SetDispoAction();
                    setDispoAction.execute(request);
                    SuccessSerialization successSerialization7 = new SuccessSerialization();
                    successSerialization7.serialize(request, response);
                    break;
                    
                case "verifyPostId" :
                    System.out.println("--------------------------verifyPostId");
                    VerifyPostIdAction verifyPostIdAction = new VerifyPostIdAction();
                    verifyPostIdAction.execute(request);
                    SuccessSerialization successSerialization8 = new SuccessSerialization();
                    successSerialization8.serialize(request, response);
                    break;
                    
                case "getActualDispo" :
                    System.out.println("--------------------------getActualDispo");
                    GetActualDispoAction getActualDispoAction = new GetActualDispoAction();
                    getActualDispoAction.execute(request);
                    if ("true".equals(request.getParameter("hidden"))) {
                        DispoSerialization dispoSerialization1 = new DispoSerialization();
                        dispoSerialization1.serialize(request, response);
                    }                        
                    else {
                        ActualDispoSerialization actualDispoSerialization = new ActualDispoSerialization();
                        actualDispoSerialization.serialize(request, response);
                    }
                    break;
                    
                    
                case "takeAppointment" :
                    System.out.println("--------------------------takeAppointment");
                    TakeAppointmentAction takeAppointmentAction = new TakeAppointmentAction();
                    takeAppointmentAction.execute(request);
                    SuccessSerialization successSerialization9 = new SuccessSerialization();
                    successSerialization9.serialize(request, response);
                    break;
                    
            }
           
            
            
            
            System.out.println(" [TEST] Appel de l’ActionServlet : todo = " + todo);
          }
    
    
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.creerFabriquePersistance();
    }

    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy();
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}