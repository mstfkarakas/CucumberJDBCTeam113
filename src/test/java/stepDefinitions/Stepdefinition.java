package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.JDBCReusableMethods.getStatement;


public class Stepdefinition {

    String query;
    String query1;
    ResultSet resultSet;
    ResultSet resultSet1;
    Statement statement;


    int flag;

    String querySabah = "SELECT COUNT(*) FROM heallife_hospitaltraining.appointment WHERE hour(time) < 12;";
    String queryAksam = "SELECT COUNT(*) FROM heallife_hospitaltraining.appointment WHERE hour(time) > 12;";

    Manage manage = new Manage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.createConnection();
    }

    @Given("Query hazirlanir.")
    public void query_hazirlanir() {
        // Hocadan:  query= "Select charge_id From heallife_hospitaltraining.ambulance_call Where patient_id=1 AND driver='Smith';";
        query = "SELECT COUNT(driver) FROM heallife_hospitaltraining.ambulance_call WHERE patient_id=1 AND driver = 'Smith'";
    }

    @Given("Query calistirilir ve sonuclari alinir.")
    public void query_calistirilir_ve_sonuclari_alinir() throws SQLException {

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {

        int expectedData = 2;

        flag = 0;
        while (resultSet.next()) {
            flag++;
        }
        assertEquals(expectedData, flag);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();
    }

    //--------------------------------------------------------

    @Given("Update Query'si hazirlanir.")
    public void update_query_si_hazirlanir() {
        query1 = "INSERT INTO heallife_hospitaltraining.appointment (priority,specialist,doctor,amount,message,appointment_status,source,is_opd,is_ipd,live_consult) VALUES (1,2,2,0,'helloTeam113','approved','OFFline','no','yes','yes');";

    }

    @Given("Sonuclari alinir ve dogrulanir.")
    public void sonuclari_alinir_ve_dogrulanir() throws SQLException {

        int sonuc = JDBCReusableMethods.getStatement().executeUpdate(query1);

        int verify = 0;
        if (sonuc > 0) {
            verify++;
        }
        assertEquals(verify, 1);
    }

    //-------------------------------JDBC Query 3------------------------------------------------

    @Given("Randevu sayilarini ogrenebilecegimiz sql querysi hazirlanir.")
    public void randevu_sayilarini_ogrenebilecegimiz_sql_querysi_hazirlanir() {


    }

    @Given("Query calistirilir ve sonuclar dogrulanir.")
    public void query_calistirilir_ve_sonuclar_dogrulanir() throws SQLException {

        resultSet = getStatement().executeQuery(manage.getQuerySabah());
        resultSet.next();
        System.out.println(resultSet.getInt(1));
        int sabahRandevulari = resultSet.getInt(1);

        ResultSet rs1 = JDBCReusableMethods.getStatement().executeQuery(manage.getQueryAksam());
        rs1.next();
        System.out.println(rs1.getInt(1));
        int aksamRandevulari = rs1.getInt(1);

        assertTrue(sabahRandevulari < aksamRandevulari);

    }
//------------------------------JDBC Query 4-------------------------------------------------------

    @Given("Languages tablosuna query gönderilir ve sonuclar dogrulanir.")
    public void languages_tablosuna_query_gönderilir_ve_sonuclar_dogrulanir() throws SQLException {

        resultSet = getStatement().executeQuery(manage.getLanguagesQuery());
        resultSet.next();
        String expectedLanguages = "Yiddish";
        String actualLanguages = resultSet.getString(1);

        assertEquals(expectedLanguages, actualLanguages);

    }
    // ____________________ SORU 01 _____________________________________________
    @Given("Sorgulama icin query olusturulur ve sonuc dogrulanir.")
    public void sorgulama_icin_query_olusturulur_ve_sonuc_dogrulanir() throws SQLException {

        statement = JDBCReusableMethods.getStatement();
        resultSet = JDBCReusableMethods.executeQuery(manage.getAppointmentLiveConsult());
        resultSet.next();
        assertEquals("yes", resultSet.getString(1));
    }
    // ____________________ SORU 02 _____________________________________________

    @Given("Appointment payment Query olusturulur ve {int} dogrulanir.")
    public void appointment_payment_query_olusturulur_ve_dogrulanir(int id) throws SQLException {
        statement = JDBCReusableMethods.getStatement();
        resultSet = statement.executeQuery(manage.getPaymentTypeOffline());

        List<Integer> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getInt(1));
        }
        assertTrue(idList.contains(id));
    }

    // ____________________ SORU 03 _____________________________________________

    @Given("Query calistirilir ve sonuclari siralanir.")
    public void query_calistirilir_ve_sonuclari_siralanir() throws SQLException {

        statement = JDBCReusableMethods.getStatement();
        resultSet = JDBCReusableMethods.executeQuery(manage.getAppointmentQueue());

        if (resultSet.next()) {
            String columnValue = resultSet.getString(6);
            System.out.println(columnValue);
        }
    }

    // ____________________ SORU 04 _____________________________________________
    @Then("Bed tablosunda verilen hastanin active olup olmadigi dogrulanir.")
    public void bed_tablosunda_verilen_hastanin_active_olup_olmadigi_dogrulanir() throws SQLException {

        resultSet = getStatement().executeQuery(manage.getIsBedActive());
        resultSet.next();

        String expected = "yes";
        assertEquals(expected, resultSet.getString(1));

    }
}