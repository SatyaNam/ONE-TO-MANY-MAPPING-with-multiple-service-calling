package com.quest.springboot.student.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Student")
public class StudentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUD_ID")
    private Integer studId;

    @Column(name = "STUD_NAME")
    private String studName;

    @Column(name = "STUD_CLASS")
    private  Integer studClass;

//    @Column(name = "STUD_ADD")
//    private String studAdd;

    @Column(name = "STUD_EMAIL")
    private String studEmail;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sa_fk", referencedColumnName ="STUD_ID" )
    private List<AddressDetailsEntity> addressEntity;
    
}


