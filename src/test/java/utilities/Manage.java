package utilities;

public class Manage {

    private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
    private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";

    private String languagesQuery = "Select language From heallife_hospitaltraining.languages Where short_code = 'yi'";

    private String appointmentLiveConsult = "select live_consult from heallife_hospitaltraining.appointment where patient_id = 20";

    private String paymentTypeOffline = "SELECT id FROM heallife_hospitaltraining.appointment_payment WHERE payment_type='Offline'";

    private String appointmentQueue = "SELECT * FROM heallife_hospitaltraining.appointment_queue WHERE date = '2023-05-04' ORDER BY appointment_queue";

    private String isBedActive = "SELECT is_active FROM heallife_hospitaltraining.bed WHERE created_at = '2021-10-25 03:34:25'";

    public String bedTable(String columnName, int group_id) {

        String query = "SELECT " +columnName+ " FROM heallife_hospitaltraining.bed WHERE is_active='no' AND bed_group_id="+group_id + " ";

        return query;
    }


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

    public String getAppointmentQueue() {
        return appointmentQueue;
    }

    public String getIsBedActive() {
        return isBedActive;
    }





}
