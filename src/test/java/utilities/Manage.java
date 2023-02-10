package utilities;

public class Manage {

    private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
    private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";

    private String languagesQuery= "Select language From heallife_hospitaltraining.languages Where short_code = 'yi'";

    private String appointmentLiveConsult = "select live_consult from heallife_hospitaltraining.appointment where patient_id = 20";

    private String paymentTypeOffline = "SELECT id FROM heallife_hospitaltraining.appointment_payment WHERE payment_type='Offline'";


    public String getQuerySabah() {
        return querySabah;
    }

    public String getQueryAksam() {
        return queryAksam;
    }

    public String getLanguagesQuery() {
        return languagesQuery;
    }

    public String getAppointmentLiveConsult() {
        return appointmentLiveConsult;
    }

    public String getPaymentTypeOffline() {
        return paymentTypeOffline;
    }
}
