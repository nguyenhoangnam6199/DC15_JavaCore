package com.hoangnam.springmvc.controller;

import com.hoangnam.springmvc.dto.EquipmentDTO;
import com.hoangnam.springmvc.model.Equipment;
import com.hoangnam.springmvc.service.EmployeeService;
import com.hoangnam.springmvc.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/equipments", method = RequestMethod.GET)
    public String listEquipments(Model model){
        model.addAttribute("equipments",equipmentService.listAllEquipment());
        return "equipments";
    }

    @RequestMapping(value = "/equipment/{id}")
    public String getEquipmentById(@PathVariable Integer id, Model model){
        model.addAttribute("equipment",equipmentService.getEquipmentById(id));
        return "equipment";
    }

    @RequestMapping(value = "/equipment/create")
    public String newEquipment(Model model){
        model.addAttribute("equipment", new EquipmentDTO());
        model.addAttribute("employees", employeeService.listAllEmployee());
        return "equipmentform";
    }

    @RequestMapping(value = "/equipment",method = RequestMethod.POST)
    public String saveEquipment(EquipmentDTO equipmentDTO){
        EquipmentDTO saveEquipment = equipmentService.createEquipment(equipmentDTO);
        return "redirect:/equipment/"+saveEquipment.getId();
    }

    @RequestMapping(value = "equipment/edit/{id}")
    public String editEquipment(@PathVariable Integer id, Model model){
        model.addAttribute("equipment",equipmentService.getEquipmentById(id));
        model.addAttribute("employees", employeeService.listAllEmployee());
        return "updateform";
    }

    @RequestMapping(value = "/equipment/edit", method = RequestMethod.POST)
    public String editEquipment(EquipmentDTO equipmentDTO){
        EquipmentDTO saveEquipment = equipmentService.updateEquipment(equipmentDTO);
        return "redirect:/equipment/"+saveEquipment.getId();
    }

    @RequestMapping(value = "equipment/delete/{id}")
    public String deleteEquipment(@PathVariable Integer id){
        equipmentService.deleteEquipment(id);
        return "redirect:/equipments";
    }
}
