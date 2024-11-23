/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serialization;

import Metier.Modele.Appointment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class AppointmentSerialization extends Serialization {

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject appointmentJson = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("d 'of' MMMM, yyyy 'at' HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d 'of' MMMM yyyy", Locale.ENGLISH);
        boolean success = true;
        Appointment appointment = (Appointment) req.getAttribute("appointment");
        
        JsonArray dateJson = new JsonArray();
        int year = appointment.getDateAppointment().getFirst();
        int weekOfYear = appointment.getDateAppointment().getSecond();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        for (Map.Entry<Integer, Set<Integer>> entry : appointment.getDuration().entrySet()) {
            Integer day = entry.getKey();
            ++day;
            Set<Integer> hourSet = entry.getValue();
            for (Integer hour : hourSet) {
                JsonObject pairJson = new JsonObject();
                pairJson.addProperty("day", LocalDate.ofYearDay(year, 1).with(weekFields.weekOfYear(), weekOfYear).with(weekFields.dayOfWeek(), day).format(formatter));
                pairJson.addProperty("hour", hour);
                dateJson.add(pairJson);
            }
        }

        appointmentJson.addProperty("id", appointment.getId());
        appointmentJson.addProperty("date", sdf.format(appointment.getDate()));
        appointmentJson.addProperty("emmitted", appointment.getPayment().isEmmited());
        appointmentJson.addProperty("received", appointment.getPayment().isReceived());
        appointmentJson.add("duration", dateJson);
        appointmentJson.addProperty("workerFirstName", appointment.getPublication().getClient().getFirstName());
        appointmentJson.addProperty("workerLastName", appointment.getPublication().getClient().getLastName());
        appointmentJson.addProperty("clientFirstName", appointment.getClient().getFirstName());
        appointmentJson.addProperty("clientLastName", appointment.getClient().getLastName());
        appointmentJson.addProperty("averagePublication", appointment.getPublication().getAverage());                             
        appointmentJson.addProperty("clientAddress", appointment.getClient().getAddress());
        appointmentJson.addProperty("price", appointment.getPrice());
        appointmentJson.addProperty("method", ((appointment.getPayment().getPaymentMethod() == null) ? null : appointment.getPayment().getPaymentMethod().toString()));
        
        appointmentJson.addProperty("success", success);
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(appointmentJson));
        out.close();
        
        
        
        
        
    }
    
}
