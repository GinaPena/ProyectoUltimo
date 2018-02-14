package com.example.practicaFinal.prcticaFinal.controllers;


import com.example.practicaFinal.prcticaFinal.Service.MedicoService;
import com.example.practicaFinal.prcticaFinal.controller.MedicosController;
import com.example.practicaFinal.prcticaFinal.domain.Medico;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicoControllerTest {
    private MockMvc mockMvc;
    private MedicosController medicosController;

    @Mock
    private MedicoService medicoService;

    public MedicoControllerTest() {
    }

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Medico medico = new Medico();
        medico.setIdMedico(9L);
        medico.setNombre("Montse");
        medico.setEspecial(4L);
        medico.setEstado("HABILITADO");

        Mockito.when(medicoService.findOne(9L)).thenReturn(medico);

        medicosController = new MedicosController(medicoService);

        mockMvc = MockMvcBuilders.standaloneSetup(medicosController).build();


    }

     @Test
   public void testListAllDoctor() throws Exception {
        System.out.println("listAll");
        mockMvc.perform(get("/Medicos"))
        .andExpect(status().isOk());
    }

    @Test
    public void testFindDoctor()throws Exception{
        mockMvc.perform(get("/Medicos/"+9L)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void DeleteMedico()throws Exception{
        mockMvc.perform(delete("/Medicos/"+9L))
                .andExpect(status().isOk());
    }


}
