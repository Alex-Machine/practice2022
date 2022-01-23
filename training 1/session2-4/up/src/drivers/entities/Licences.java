package drivers.entities;

public class Licences {
    private int id_driver;
    private String licence_date;
    private String expire_date;
    private String categories;
    private String licence_series;
    private int licence_number;

    public Licences() {
    }

    public Licences(int id_driver, String licence_date, String expire_date, String categories, String licence_series, int licence_number) {
        this.id_driver = id_driver;
        this.licence_date = licence_date;
        this.expire_date = expire_date;
        this.categories = categories;
        this.licence_series = licence_series;
        this.licence_number = licence_number;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public String getLicence_date() {
        return licence_date;
    }

    public void setLicence_date(String licence_date) {
        this.licence_date = licence_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLicence_series() {
        return licence_series;
    }

    public void setLicence_series(String licence_series) {
        this.licence_series = licence_series;
    }

    public int getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(int licence_number) {
        this.licence_number = licence_number;
    }
}

