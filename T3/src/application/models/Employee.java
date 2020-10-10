package application.models;

import javafx.beans.property.SimpleStringProperty;

public class Employee {
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty address;
    private SimpleStringProperty contactNo;
    private SimpleStringProperty irdNo;

    public Employee(String s1, String s2, String s3, String s4, String s5) {
        name = new SimpleStringProperty(s1);
        email = new SimpleStringProperty(s2);
        address = new SimpleStringProperty(s3);
        contactNo = new SimpleStringProperty(s4);
        irdNo = new SimpleStringProperty(s5);
    }

    /**
     * @return SimpleStringProperty return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @param name the name to set
     */
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    /**
     * @return SimpleStringProperty return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    /**
     * @return SimpleStringProperty return the address
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * @param address the address to set
     */
    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    /**
     * @return SimpleStringProperty return the contactNo
     */
    public String getContactNo() {
        return contactNo.get();
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(SimpleStringProperty contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return SimpleStringProperty return the irdNo
     */
    public String getIrdNo() {
        return irdNo.get();
    }

    /**
     * @param irdNo the irdNo to set
     */
    public void setIrdNo(SimpleStringProperty irdNo) {
        this.irdNo = irdNo;
    }

}
