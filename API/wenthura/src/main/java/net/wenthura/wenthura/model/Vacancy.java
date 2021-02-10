package net.wenthura.wenthura.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "vacancy")

public class Vacancy {
    private long id;
    private String Vname;
    private String Vdesc;
    private String Vplace;
    private Date Edate;
    private Date Sdate;
    private String Worktime;


    public Vacancy() {}

    public Vacancy(long id, String vname, String vdesc, String vplace, Date edate,Date sdate, String worktime) {
        this.id = id;
        Vname = vname;
        Vdesc = vdesc;
        Vplace = vplace;
        Edate = edate;
        Sdate = sdate;
        Worktime = worktime;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "vacancy_name", nullable = false)
    public String getVname() {
        return Vname;
    }

    public void setVname(String vname) {
        Vname = vname;
    }

    @Column(name = "v_description", nullable = false)
    public String getVdesc() {
        return Vdesc;
    }

    public void setVdesc(String vdesc) {
        Vdesc = vdesc;
    }
    @Column(name = "v_place", nullable = false)
    public String getVplace() {
        return Vplace;
    }


    public void setVplace(String vplace) {
        Vplace = vplace;
    }

    @Column(name = "v_edate", nullable = false)
    public Date getEdate() {
        return Edate;
    }


    public void setEdate(Date edate) {
        Edate = edate;
    }

    @Column(name = "v_sdate", nullable = false)
    public Date getSdate() {
        return Sdate;
    }

    public void setSdate(Date sdate) {
        Sdate = sdate;
    }

    @Column(name = "v_worktime", nullable = false)
    public String getWorktime() {
        return Worktime;
    }

    public void setWorktime(String worktime) {
        Worktime = worktime;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", Vname='" + Vname + '\'' +
                ", Vdesc='" + Vdesc + '\'' +
                ", Vplace='" + Vplace + '\'' +
                ", Edate='" + Edate + '\'' +
                ", Sdate='" + Sdate + '\'' +
                ", Worktime='" + Worktime + '\'' +
                '}';
    }

}








































