package com.animalshelter.animalshelterbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Getter
@Setter
@Entity
public class AdoptedCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catName;
    private Date adoptionDate;
    private Integer trialPeriod;
    @ManyToOne
    @JoinColumn(name = "cat_user_id")
    private CatUser catUser;
    @OneToMany(mappedBy = "adoptedCat")
    private Collection<CatReport> catReports;

    public AdoptedCat() {
    }

    public AdoptedCat(String catName, Date adoptionDate, Integer trialPeriod){
        this.catName = catName;
        this.adoptionDate = adoptionDate;
        this.trialPeriod = trialPeriod;
    }

    @Override

    public String toString(){
        return "Кошка по кличке:" + catName + "взята из приюта:" + adoptionDate
                + "период адаптации:" + trialPeriod;
    }

}
