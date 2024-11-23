/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Admin.AddAdminAction;
import Controller.Admin.AuthenticateAction;
import Controller.Admin.ConnectAsClientAction;
import Controller.Admin.DisconnectFromClientAction;
import Controller.Admin.GetListClient;
import DAO.JpaUtil;
import Metier.Service.Service;
import Serialization.ActualDispoSerialization;
import Serialization.DispoSerialization;
import Serialization.AppointmentListSerialization;
import Serialization.AppointmentSerialization;
import Serialization.ClientListSerialization;
import Serialization.PriceSerialization;
import Serialization.PublicationListSerialization;
import Serialization.SignInSerialization;
import Serialization.SuccessSerialization;
import Serialization.WorkTypeListSerialization;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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

    private ScheduledExecutorService scheduler;
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
                    
                    
                case "receivePayment" :
                    System.out.println("--------------------------validatePayment");
                    ReceivePaymentAction receivePaymentAction = new ReceivePaymentAction();
                    receivePaymentAction.execute(request);
                    SuccessSerialization successSerialization10 = new SuccessSerialization();
                    successSerialization10.serialize(request, response);
                    break;
                    
                case "emmitPayment" :
                    System.out.println("--------------------------emmitPayment");
                    EmmitPaymentAction emmitPaymentAction = new EmmitPaymentAction();
                    emmitPaymentAction.execute(request);
                    SuccessSerialization successSerialization14 = new SuccessSerialization();
                    successSerialization14.serialize(request, response);
                    break;
                    
                    
                    
                case "suppressPublication" :
                    System.out.println("--------------------------suppressPublication");
                    SuppressPublicationAction suppressPublicationAction = new SuppressPublicationAction();
                    suppressPublicationAction.execute(request);
                    SuccessSerialization successSerialization11 = new SuccessSerialization();
                    successSerialization11.serialize(request, response);
                    break;
                    
                case "cancelAppointment" :
                    System.out.println("--------------------------cancelAppointment");
                    CancelAppointmentAction cancelAppointmentAction = new CancelAppointmentAction();
                    cancelAppointmentAction.execute(request);
                    SuccessSerialization successSerialization12 = new SuccessSerialization();
                    successSerialization12.serialize(request, response);
                    break;
                    
                    
                case "getNextAppointments" :
                    System.out.println("--------------------------getNextAppointmens");
                    GetNextsAppointmentsAction getNextsAppointmentsAction = new GetNextsAppointmentsAction();
                    getNextsAppointmentsAction.execute(request);
                    AppointmentListSerialization nextAppointmentListSerialization = new AppointmentListSerialization();
                    nextAppointmentListSerialization.serialize(request, response);
                    break;
                    
                    
                case "addNote" :
                    System.out.println("--------------------------addNote");
                    AddNoteAction addNoteAction = new AddNoteAction();
                    addNoteAction.execute(request);
                    SuccessSerialization successSerialization13 = new SuccessSerialization();
                    successSerialization13.serialize(request, response);
                    break;
                    
                case "clearSession" :
                    System.out.println("--------------------------clearSession");
                    ClearSessionAction clearSessionAction = new ClearSessionAction();
                    clearSessionAction.execute(request);
                    break;
                    
                case "getPassedAppointments" :
                    System.out.println("--------------------------getPassedAppointments");
                    GetPassedAppointmentAction getPassedAppointmentAction = new GetPassedAppointmentAction();
                    getPassedAppointmentAction.execute(request);
                    AppointmentListSerialization passedAppointmentListSerialization = new AppointmentListSerialization();
                    passedAppointmentListSerialization.serialize(request, response);
                    break;
                    
                    
                case "setAppointmentSession" :
                    System.out.println("--------------------------setAppointmentSession");
                    SetAppointmentSessionAction setAppointmentSessionAction = new SetAppointmentSessionAction();
                    setAppointmentSessionAction.execute(request);
                    break;
                    
                case "verifyAppointment" :
                    System.out.println("--------------------------verifyAppointment");
                    VerifyAppointmentAction verifyAppointmentAction = new VerifyAppointmentAction();
                    verifyAppointmentAction.execute(request);
                    SuccessSerialization successSerialization15 = new SuccessSerialization();
                    successSerialization15.serialize(request, response);
                    break;
                    
                    
                case "getPriceAppointment" : 
                    System.out.println("--------------------------getPriceAppointment");
                    GetAppointmentPriceAction getAppointmentPriceAction = new GetAppointmentPriceAction();
                    getAppointmentPriceAction.execute(request);
                    PriceSerialization priceSerialization = new PriceSerialization();
                    priceSerialization.serialize(request, response);
                    break;
                    
                    
                case "appointment" :
                    System.out.println("--------------------------appointment");
                    GetAppointmentAction getAppointmentAction = new GetAppointmentAction();
                    getAppointmentAction.execute(request);
                    AppointmentSerialization appointmentSerialization = new AppointmentSerialization();
                    appointmentSerialization.serialize(request, response);
                    break;
                    
                case "authenticateAdmin" :
                    System.out.println("--------------------------authenticateAdmin");
                    AuthenticateAction authenticateAction = new AuthenticateAction();
                    authenticateAction.execute(request);
                    SuccessSerialization successSerialization16 = new SuccessSerialization();
                    successSerialization16.serialize(request, response);
                    break;
                    
                case "adminVerifyConnection" :
                    System.out.println("--------------------------adminVerifyConnection");
                    Controller.Admin.VerifyConnexionAction verifyConnexionActionAdmin = new Controller.Admin.VerifyConnexionAction();
                    verifyConnexionActionAdmin.execute(request);
                    SuccessSerialization successSerialization17 = new SuccessSerialization();
                    successSerialization17.serialize(request, response);
                    break;
                    
                case "addAdmin" :
                    System.out.println("--------------------------addAdmin");
                    AddAdminAction addAdminAction = new AddAdminAction();
                    addAdminAction.execute(request);
                    SuccessSerialization successSerialization18 = new SuccessSerialization();
                    successSerialization18.serialize(request, response);
                    break;
                    
                    
                case "getListClient" :
                    System.out.println("--------------------------getListClient");
                    GetListClient getListClient = new GetListClient();
                    getListClient.execute(request);
                    ClientListSerialization clientListSerialization = new ClientListSerialization();
                    clientListSerialization.serialize(request, response);
                    break;
                    
                    
                case "connectAsClient" :
                    System.out.println("--------------------------connectAsClient");
                    ConnectAsClientAction connectAsClientAction = new ConnectAsClientAction();
                    connectAsClientAction.execute(request);
                    SuccessSerialization successSerialization19 = new SuccessSerialization();
                    successSerialization19.serialize(request, response);
                    break;
                    
                case "getCanceledAppointments" :
                    System.out.println("--------------------------getCanceledAppointments");
                    GetCanceledAppointmentsAction getCanceledAppointmentsAction = new GetCanceledAppointmentsAction();
                    getCanceledAppointmentsAction.execute(request);
                    AppointmentListSerialization canceledAppointmentListSerialization = new AppointmentListSerialization();
                    canceledAppointmentListSerialization.serialize(request, response);
                    break;
                    
                    
                case "disconnectClient" :
                    System.out.println("--------------------------disconnectClient");
                    DisconnectFromClientAction disconnectFromClientAction = new DisconnectFromClientAction();
                    disconnectFromClientAction.execute(request);

            }
           
            
            
            
            System.out.println(" [TEST] Appel de l’ActionServlet : todo = " + todo);
          }
    
    
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.creerFabriquePersistance();
        Service.updatePassedAppointments();
        LocalDateTime now = LocalDateTime.now();

        // Calculez le temps jusqu'à la prochaine heure ronde
        LocalDateTime nextHour = now.truncatedTo(ChronoUnit.HOURS).plusHours(1);
        long initialDelay = ChronoUnit.SECONDS.between(now, nextHour) + 61;

        
        scheduler = Executors.newScheduledThreadPool(1);
        Runnable hourlyTask = new Runnable() {
            @Override
            public void run() {
                try {
                    Service.updatePassedAppointments();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        
        scheduler.scheduleAtFixedRate(hourlyTask, initialDelay, 1, TimeUnit.DAYS);
    }

    @Override
    public void destroy() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
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