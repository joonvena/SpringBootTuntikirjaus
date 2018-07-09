package fi.academy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class HoursForm {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @NotNull
        private Integer kayttajaid;

        private boolean laskutettava;

        @NotNull
        private Integer minuutit;

        @NotNull
        private Date paivamaara;

        @NotNull
        private String tehtavakuvaus;

        public HoursForm() {}

        public HoursForm(Integer kayttajaid, boolean laskutettava, Integer minuutit, Date paivamaara, String tehtavakuvaus) {
            this.kayttajaid = kayttajaid;
            this.laskutettava = laskutettava;
            this.minuutit = minuutit;
            this.paivamaara = paivamaara;
            this.tehtavakuvaus = tehtavakuvaus;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getKayttajaid() {
            return kayttajaid;
        }

        public void setKayttajaid(Integer kayttajaid) {
            this.kayttajaid = kayttajaid;
        }

        public boolean isLaskutettava() {
            return laskutettava;
        }

        public void setLaskutettava(boolean laskutettava) {
            this.laskutettava = laskutettava;
        }

        public Integer getMinuutit() {
            return minuutit;
        }

        public void setMinuutit(Integer minuutit) {
            this.minuutit = minuutit;
        }

        public Date getPaivamaara() {
            return paivamaara;
        }

        public void setPaivamaara(Date paivamaara) {
            this.paivamaara = paivamaara;
        }

        public String getTehtavakuvaus() {
            return tehtavakuvaus;
        }

        public void setTehtavakuvaus(String tehtavakuvaus) {
            this.tehtavakuvaus = tehtavakuvaus;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Hours{");
            sb.append("id=").append(id);
            sb.append(", kayttajaid=").append(kayttajaid);
            sb.append(", laskutettava=").append(laskutettava);
            sb.append(", minuutit=").append(minuutit);
            sb.append(", paivamaara=").append(paivamaara);
            sb.append(", tehtavakuvaus='").append(tehtavakuvaus).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


