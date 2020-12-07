package ba.sum.fpmoz.pma.model;

public class Student {
     public String name;
     public String surname;
     public String uid;

    public Student(String name, String surname, String uid) {
        this.name = name;
        this.surname = surname;
        this.uid = uid;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
