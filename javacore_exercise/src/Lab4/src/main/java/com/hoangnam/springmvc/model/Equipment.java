package com.hoangnam.springmvc.model;

import com.hoangnam.springmvc.constant.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="equipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Integer id;

    @Column(name = "equipment_name")
    private String name;
    private String status;
    private String description;

    @Column(name = "type")
    private EquipmentType type;

    @OneToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

}
