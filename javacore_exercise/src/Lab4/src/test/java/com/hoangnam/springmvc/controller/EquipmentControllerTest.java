package com.hoangnam.springmvc.controller;

import com.hoangnam.springmvc.constant.EquipmentType;
import com.hoangnam.springmvc.dto.EquipmentDTO;
import com.hoangnam.springmvc.model.Equipment;
import com.hoangnam.springmvc.service.EmployeeService;
import com.hoangnam.springmvc.service.EquipmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.mockito.*;

import static org.junit.Assert.*;

public class EquipmentControllerTest {
    @Mock
    private EquipmentService equipmentService;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EquipmentController equipmentController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(equipmentController).build();
    }

    @Test
    public void listEquipments() throws Exception {
        verifyNoInteractions(equipmentService);
        ResultActions resultActions;
        resultActions = mockMvc.perform(get("/equipments/"))
                .andExpect(status().isOk())
                .andExpect(view().name("equipments"));
    }

    @Test
    public void getEquipmentById() throws Exception{
        Integer id = 1;

        when(equipmentService.getEquipmentById(id)).thenReturn(new EquipmentDTO());

        mockMvc.perform(get("/equipment/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("equipment"));
    }

    @Test
    public void newEquipment() throws Exception{
        Integer id = 1;
        verifyNoInteractions(equipmentService);
        mockMvc.perform(get("/equipment/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("equipmentform"));
    }

    @Test
    public void editEquipment() throws Exception{
        Integer id = 1;
        when(equipmentService.getEquipmentById(id)).thenReturn(new EquipmentDTO());
        mockMvc.perform(get("/equipment/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateform"));
    }

    @Test
    public void deleteEquipment() throws Exception {
        Integer id = 1;
        ResultActions resultActions;
        resultActions = mockMvc.perform(get("/equipment/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/equipments"));
    }
}