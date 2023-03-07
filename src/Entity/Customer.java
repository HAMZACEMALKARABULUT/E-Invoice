package entity;

public class Customer {

    private int id;
    private String name;
    private String surname;

    private String identifier;
    private String telNo;
    private String mail;

    private String taxAdministration;
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTaxAdministration() {
        return taxAdministration;
    }

    public void setTaxAdministration(String taxAdministration) {
        this.taxAdministration = taxAdministration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {


        return " Kullanıcı bilgileri : \n" +"Id : "+this.getId()+
                "\nTc veya Vergi No : " + this.getIdentifier() + "\nİsim : "
                + this.getName() + "\nSoyisim : " + this.getSurname() + "\nUnvan : " + this.getTitle() + "\nTelefon Numarası : " +
                this.getTelNo() + "\nMail Adresi : " + this.getMail() + "\nVergi Dairesi : " + this.getTaxAdministration()+"\n";


    }


}

