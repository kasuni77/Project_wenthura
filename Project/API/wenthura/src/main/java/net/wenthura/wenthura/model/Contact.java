package net.wenthura.wenthura.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "Contact")

public class Contact {
    private long id;
    private String Cname;
    private String Clname;
    private String Cemail;
    private String Csubject;
    private String Cproblem;
    private boolean Cexp;

    public Contact() {}

    public Contact(long id, String cname, String clname, String cemail, String csubject, String cproblem, boolean cexp) {
        this.id = id;
        Cname = cname;
        Clname = clname;
        Cemail = cemail;
        Csubject = csubject;
        Cproblem = cproblem;
        Cexp = cexp;
    }






    @Id
    @Column(name = "c_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "c_name", nullable = false)
    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }
    @Column(name = "c_lname", nullable = false)
    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }
    @Column(name = "c_email", nullable = false)
    public String getCemail() {
        return Cemail;
    }

    public void setCemail(String cemail) {
        Cemail = cemail;
    }
    @Column(name = "c_subject", nullable = false)
    public String getCsubject() {
        return Csubject;
    }

    public void setCsubject(String csubject) {
        Csubject = csubject;
    }
    @Column(name = "c_problem", nullable = false)
    public String getCproblem() {
        return Cproblem;
    }

    public void setCproblem(String cproblem) {
        Cproblem = cproblem;
    }

    @Column(name = "c_exp", nullable = false)
    public boolean isCexp() {
        return Cexp;
    }

    public void setCexp(boolean cexp) {
        Cexp = cexp;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", Cname='" + Cname + '\'' +
                ", Clname='" + Clname + '\'' +
                ", Cemail='" + Cemail + '\'' +
                ", Csubject='" + Csubject + '\'' +
                ", Cproblem='" + Cproblem + '\'' +
                ", Cexp=" + Cexp +
                '}';
    }
}










































