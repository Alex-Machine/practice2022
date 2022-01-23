package drivers.database;

import drivers.entities.Driver;
import drivers.entities.TS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DbHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:mysql://localhost:3306/up";
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connection, "root", "1234");
        return dbConnection;
    }

    /**
     * получение данных о водителях
     * @return водителя
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ObservableList<Driver> getDriver() throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM drivers");
        ResultSet result = statement.executeQuery();
        ObservableList<Driver> drivers = FXCollections.observableArrayList();
        while (result.next()) {
            Driver driver = new Driver();
            driver.setId(result.getInt("id"));
            driver.setName(result.getString("name"));
            driver.setMiddlename(result.getString("middlename"));
            driver.setPassport_serial(result.getString("passport_serial"));
            driver.setPassport_number(result.getString("passport_number"));
            driver.setPostcode(result.getInt("postcode"));
            driver.setAddress(result.getString("address"));
            driver.setAddress_life(result.getString("address_life"));
            driver.setCompany(result.getString("company"));
            driver.setJobname(result.getString("jobname"));
            driver.setPhone(result.getString("phone"));
            driver.setEmail(result.getString("email"));
            driver.setPhoto(result.getString("photo"));
            driver.setDescription(result.getString("description"));
            drivers.add(driver);
        }
        return drivers;
    }

    /**
     * получение данных о ТС
     * @return ТС
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ObservableList<TS> getTS() throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ts");
        ResultSet result = statement.executeQuery();
        ObservableList<TS> drivers = FXCollections.observableArrayList();
        while (result.next()) {
            TS ts = new TS();
            ts.setVin(result.getInt("vin"));
            ts.setMarka(result.getString("marka"));
            ts.setModel(result.getString("model"));
            ts.setType(result.getString("type"));
            ts.setCategory(result.getString("category"));
            ts.setNumberDvigatel(result.getString("number_dvigatel"));
            ts.setModelDvigatel(result.getString("model_dvigatel"));
            ts.setYesrDvigatel(result.getString("year_dvigatel"));
            ts.setColorNumber(result.getString("color_dvigatel"));
            ts.setPowerDvigatel(result.getDouble("power_dvigatel"));
            ts.setPowerDvigatelHorse(result.getDouble("power_dvigatel_horse"));
            ts.setMaxPressure(result.getDouble("max_pressure"));
            ts.setWeight(result.getDouble("weight"));
            ts.setTypeDvigatel(result.getString("type_dvigatel"));
            ts.setWeightKG(result.getDouble("weight_KG"));
            ts.setTypePrivoda(result.getString("type_privoda"));
            ts.setNotes(result.getString("notes"));
            ts.setOwner(result.getString("owner"));
            drivers.add(ts);
        }
        return drivers;
    }

    /**
     * Создание ТС
     * @param ts тс
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createTS(TS ts) throws SQLException, ClassNotFoundException {
        PreparedStatement inserts = getDbConnection().prepareStatement(" insert into ts " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        inserts.setInt(1, ts.getVin());
        inserts.setString(2, ts.getMarka());
        inserts.setString(3, ts.getModel());
        inserts.setString(4, ts.getType());
        inserts.setString(5, ts.getCategory());
        inserts.setString(6, ts.getNumberDvigatel());
        inserts.setString(7, ts.getModelDvigatel());
        inserts.setString(8, ts.getYesrDvigatel());
        inserts.setString(9, ts.getColorNumber());
        inserts.setDouble(10, ts.getPowerDvigatel());
        inserts.setDouble(11, ts.getPowerDvigatelHorse());
        inserts.setDouble(12, ts.getMaxPressure());
        inserts.setDouble(13, ts.getWeight());
        inserts.setString(14, ts.getTypeDvigatel());
        inserts.setDouble(15, ts.getWeightKG());
        inserts.setString(16, ts.getTypePrivoda());
        inserts.setString(17, ts.getNotes());
        inserts.setString(18, ts.getOwner());
        inserts.executeUpdate();
    }

    /**
     * Обновление данных воддителя
     * @param id идентификатор
     * @param driver данные водителя
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateDriver(int id, Driver driver) throws SQLException, ClassNotFoundException {
        PreparedStatement inserts = getDbConnection().prepareStatement(" UPDATE drivers set id = ? , " +
                "name = ? , middlename = ? , passport_serial = ? , passport_number = ? , postcode = ?" +
                "address = ? , address_life = ? , company = ? , jobname = ? , phone = ?" +
                "email = ? , photo = ? , description = ? " +
                " where id_info = ?;");
        inserts.setInt(1, driver.getId());
        inserts.setString(2, driver.getName());
        inserts.setString(3, driver.getMiddlename());
        inserts.setString(4, driver.getPassport_serial());
        inserts.setString(5, driver.getPassport_number());
        inserts.setInt(6, driver.getPostcode());
        inserts.setString(7, driver.getAddress());
        inserts.setString(8, driver.getAddress_life());
        inserts.setString(9, driver.getCompany());
        inserts.setString(10, driver.getJobname());
        inserts.setString(11, driver.getPhone());
        inserts.setString(12, driver.getEmail());
        inserts.setString(13, driver.getPhoto());
        inserts.setString(14, driver.getDescription());
        inserts.setInt(15, id);
        inserts.executeUpdate();
    }

    /**
     * создание водителя
     * @param driver водитель
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createDriver(Driver driver) throws SQLException, ClassNotFoundException {
        PreparedStatement inserts = getDbConnection().prepareStatement(" insert into drivers " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        inserts.setInt(1, driver.getId());
        inserts.setString(2, driver.getName());
        inserts.setString(3, driver.getMiddlename());
        inserts.setString(4, driver.getPassport_serial());
        inserts.setString(5, driver.getPassport_number());
        inserts.setInt(6, driver.getPostcode());
        inserts.setString(7, driver.getAddress());
        inserts.setString(8, driver.getAddress_life());
        inserts.setString(9, driver.getCompany());
        inserts.setString(10, driver.getJobname());
        inserts.setString(11, driver.getPhone());
        inserts.setString(12, driver.getEmail());
        inserts.setString(13, driver.getPhoto());
        inserts.setString(14, driver.getDescription());
        inserts.executeUpdate();
    }
}