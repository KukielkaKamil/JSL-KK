package LAB03.ZAD1;


import java.time.LocalDate;


public class Person {
    private String name;
    private String email;
    private int number;
    private String adress;
    private LocalDate dateofbirth;

    public Person(String name, String email, int number, String adress, LocalDate dateofbirth) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.adress = adress;
        this.dateofbirth = dateofbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

}
