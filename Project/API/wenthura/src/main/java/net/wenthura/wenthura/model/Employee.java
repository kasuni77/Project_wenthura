package net.wenthura.wenthura.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name ="employee")

public class Employee {
    private long id;
    private String Ename;
    private String Eemail;
    private String Enic;
    private String Ephone;
    private String Edesig;
    private String Epassword;

    public Employee(long id, String ename, String eemail, String enic, String ephone, String edesig, String epassword) {
        this.id = id;
        Ename = ename;
        Eemail = eemail;
        Enic = enic;
        Ephone = ephone;
        Edesig = edesig;
        Epassword = epassword;
    }

    public Employee() {

    }


    @Id
    @Column(name = "e_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "e_name", nullable = false)
    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    @Column(name = "e_desig", nullable = false)
    public String getEdesig() {
        return Edesig;
    }

    public void setEdesig(String edesig) {
        Edesig = edesig;
    }
    @Column(name = "e_password", nullable = false)
    public String getEpassword() {
        return Epassword;
    }

    public void setEpassword(String epassword) {
        Epassword = epassword;
    }
    @Column(name = "e_email", nullable = false)
    public String getEemail() {
        return Eemail;
    }

    public void setEemail(String eemail) {
        Eemail = eemail;
    }
    @Column(name = "e_nic", nullable = false)
    public String getEnic() {
        return Enic;
    }

    public void setEnic(String enic) {
        Enic = enic;
    }
    @Column(name = "e_phone", nullable = false)
    public String getEphone() {
        return Ephone;
    }

    public void setEphone(String ephone) {
        Ephone = ephone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Ename='" + Ename + '\'' +
                ", Eemail='" + Eemail + '\'' +
                ", Enic='" + Enic + '\'' +
                ", Ephone='" + Ephone + '\'' +
                ", Edesig='" + Edesig + '\'' +
                ", Epassword='" + Epassword + '\'' +
                '}';
    }
}











































