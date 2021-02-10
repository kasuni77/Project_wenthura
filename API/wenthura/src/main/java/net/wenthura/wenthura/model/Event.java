package net.wenthura.wenthura.model;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Date;

@Entity
@Table(name = "event")

public class Event {
    private long id;
    private String eName;
    private String eDesc;
    private String eCname;
    private String eAny;
    private String ePlace;
    private String eServices;
    private Date eDate;
    private boolean eMeet;
    private String eStatus;

    public Event() {}
    public Event(long id, String eName, String eDesc, String eCname, String eAny, String ePlace, String eServices, Date eDate, boolean eMeet, String eStatus) {
        this.id = id;
        this.eName = eName;
        this.eDesc = eDesc;
        this.eCname = eCname;
        this.eAny = eAny;
        this.ePlace = ePlace;
        this.eServices = eServices;
        this.eDate = eDate;
        this.eMeet = eMeet;
        this.eStatus = eStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "e_name", nullable = false)
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
    @Column(name = "e_desc", nullable = false)
    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }
    @Column(name = "e_place", nullable = false)
    public String getePlace() {
        return ePlace;
    }

    public void setePlace(String ePlace) {
        this.ePlace = ePlace;
    }
    @Column(name = "e_date", nullable = false)
    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }
    @Column(name = "e_meet", nullable = false)
    public boolean iseMeet() {
        return eMeet;
    }

    public void seteMeet(boolean eMeet) {
        this.eMeet = eMeet;
    }
    @Column(name = "e_status", nullable = false)
    public String geteStatus() {
        return eStatus;
    }

    public void seteStatus(String eStatus) {
        this.eStatus = eStatus;
    }

    @Column(name = "e_any", nullable = true)
    public String geteAny() {
        return eAny;
    }

    public void seteAny(String eAny) {
        this.eAny = eAny;
    }

    @Column(name = "e_services", nullable = false)
    public String geteServices() {
        return eServices;
    }

    public void seteServices(String eServices) {
        this.eServices = eServices;
    }

    @Column(name = "e_customer", nullable = false)
    public String geteCname() {
        return eCname;
    }

    public void seteCname(String eCname) {
        this.eCname = eCname;
    }

}








































