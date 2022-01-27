package com.hoangnam.springmvc.dto;

import com.hoangnam.springmvc.constant.EquipmentType;
import com.hoangnam.springmvc.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private Integer id;

    @NotEmpty
    private String name;

    @NotBlank
    private String status;

    @NotEmpty
    private String description;

    @NotNull
    private EquipmentType type;
    private Integer employeeId;

    public EquipmentDTO(Equipment equipment){
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.status= equipment.getStatus();
        this.description = equipment.getDescription();
        this.type = equipment.getType();
        this.employeeId = equipment.getEmployee().getId();
    }

    @Override
    public String toString() {
        return "EquipmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", employeeId=" + employeeId +
                '}';
    }
}
