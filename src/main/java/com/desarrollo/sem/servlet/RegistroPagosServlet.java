package com.desarrollo.sem.servlet;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.sem.model.RegistroPagosDiarios;
import com.desarrollo.sem.service.RegistroPagosService;
import com.desarrollo.sem.service.ValorMinutoService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("registroPagos")
@RestController
public class RegistroPagosServlet {
    
    @Autowired
    private RegistroPagosService service;

    @Autowired
    private ValorMinutoService valService;

   
    /* public RegistroPagosServlet(RegistroPagosService service) {
        this.service = service;
    } */
    
    @PostMapping("/new")
    public RegistroPagosDiarios create(@RequestBody RegistroPagosDiarios registroPago ){
      return  service.save(registroPago);
      }

    @GetMapping("/all")
    public List<RegistroPagosDiarios> findAll(){
        return service.findAll();
    }

    @PutMapping("/update/{id}")
    public RegistroPagosDiarios update (@PathVariable String id, @RequestBody RegistroPagosDiarios registro) throws Exception{
   

        RegistroPagosDiarios reg = service.findOneByUuid(UUID.fromString(id));/* .orElseThrow(); */
        
       /*  if (registro.getHoraFin().getTime() < reg.getHoraInicio().getTime())
            return throw new Exception("La hora de fin no puede ser menor a la hora de inicio");
         */
        reg.setHoraFin(registro.getHoraFin());
 
        //---- valida que la hora de finalizacion este en el horario vigente
        System.out.println(reg.getHoraInicio().getTime()/3600000);
        System.out.println(registro.getHoraFin().getTime()-10800000); 
        Calendar cal = reg.getFecha();
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        //si el estacionamiento se finaliza luego del horario de la mañana
         if (((registro.getHoraFin().getTime()-10800000)/3600000>=valService.valorActual().getHsFinM())
         && ((reg.getHoraInicio().getTime()-10800000)/3600000<=valService.valorActual().getHsInicioT())) {
            cal.set(Calendar.HOUR_OF_DAY, valService.valorActual().getHsFinM());
            reg.setHoraFin(cal.getTime());
        }
            
         
        //si el estacionamiento se finaliza luego del horario de la tarde
        if ((registro.getHoraFin().getTime()-10800000)/3600000>=valService.valorActual().getHsFinT()
        && ((reg.getHoraInicio().getTime()-10800000)/3600000>=valService.valorActual().getHsInicioT())) {
            cal.set(Calendar.HOUR_OF_DAY, valService.valorActual().getHsFinT());
            reg.setHoraFin(cal.getTime());
        } 
             
        
        /* System.out.println(registro.getHoraFin().getTime()/3600000);
        System.out.println(valService.valorActual().getHsFinM());
        registro.setHoraFin(cal.getTime()); */
        /* getHoraFin().setTime(cal.getTimeInMillis()); */
        //System.out.println(registro.getHoraFin().toString());
        


        Long min = (reg.getHoraInicio().getTime() - reg.getHoraFin().getTime()) / 60000;

        reg.setValor(min.intValue() * valService.valorActual().getValor());
        
        return service.save(reg);
    }

    @GetMapping("/minTotales/{id}") 
    public int minutos(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();

        Long min = (reg.getHoraInicio().getTime() - reg.getHoraFin().getTime()) / 60000;

        return min.intValue();
    }   

    @PutMapping("/valor/{id}")
    public long valor(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();
    
        reg.setValor(minutos(id) * valService.valorActual().getValor()); 
        service.save(reg);
        
        return reg.getValor();
    }     
}

    
