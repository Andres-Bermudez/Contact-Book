package org.contact_list_mysql;

public class Contact {
    private int id;
    private String name;
    private String last_name;
    private String cellphone_number;

    public Contact() {
        // Default Constructor
    }

    public Contact(String name, String last_name, String cellphone_number) {
        this.name = name;
        this.last_name = last_name;
        this.cellphone_number = cellphone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }
}
