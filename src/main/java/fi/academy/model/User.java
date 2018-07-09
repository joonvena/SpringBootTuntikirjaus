package fi.academy.model;

import javax.persistence.*;


@Entity
@Table(name = "kayttajat")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "etunimi")
    private String etunimi;

    @Column(name = "sukunimi")
    private String sukunimi;

    @Column(name = "osastoid")
    private Integer osastoid;

    @Column(name = "tehtavanimikeid")
    private Integer tehtavanimikeid;

    public User(Integer id, String etunimi, String sukunimi, Integer osastoid, Integer tehtavanimikeid) {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.osastoid = osastoid;
        this.tehtavanimikeid = tehtavanimikeid;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public Integer getOsastoid() {
        return osastoid;
    }

    public void setOsastoid(Integer osastoid) {
        this.osastoid = osastoid;
    }

    public Integer getTehtavanimikeid() {
        return tehtavanimikeid;
    }

    public void setTehtavanimikeid(Integer tehtavanimikeid) {
        this.tehtavanimikeid = tehtavanimikeid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", etunimi='").append(etunimi).append('\'');
        sb.append(", sukunimi='").append(sukunimi).append('\'');
        sb.append(", osastoid=").append(osastoid);
        sb.append(", tehtavanimikeid=").append(tehtavanimikeid);
        sb.append('}');
        return sb.toString();
    }
}
