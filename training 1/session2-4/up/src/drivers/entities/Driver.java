package drivers.entities;

public class Driver {
    private Integer id;
    private String name;
    private String middlename;
    private String passport_serial;
    private String passport_number;
    private Integer postcode;
    private String address;
    private String address_life;
    private String company;
    private String jobname;
    private String phone;
    private String email;
    private String photo;
    private String description;

    public Driver(Integer id, String name, String middlename, String passport_serial, String passport_number, Integer postcode, String address, String address_life, String company, String jobname, String phone, String email, String photo, String description) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.passport_serial = passport_serial;
        this.passport_number = passport_number;
        this.postcode = postcode;
        this.address = address;
        this.address_life = address_life;
        this.company = company;
        this.jobname = jobname;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.description = description;
    }

    public Driver(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPassport_serial() {
        return passport_serial;
    }

    public void setPassport_serial(String passport_serial) {
        this.passport_serial = passport_serial;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_life() {
        return address_life;
    }

    public void setAddress_life(String address_life) {
        this.address_life = address_life;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}