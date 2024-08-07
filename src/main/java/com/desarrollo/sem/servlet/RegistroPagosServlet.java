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
import com.desarrollo.sem.model.TransaccionesCC;
import com.desarrollo.sem.model.UsuarioConductor;
import com.desarrollo.sem.service.PatenteService;
import com.desarrollo.sem.service.RegistroPagosService;
import com.desarrollo.sem.service.TransaccionesCCServive;
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

    @Autowired
    private PatenteService patService;

    @Autowired
    private TransaccionesCCServive serviceTransaccion;
   
    /* public RegistroPagosServlet(RegistroPagosService service) {
        this.service = service;
    } */
    

    /* hace un insert en transaccion lo que descuenta el saldo del 
     * conductor con el trigger de la bd
     */
    public void descSaldo(int val, UsuarioConductor cond) {
        serviceTransaccion.save(
                    new TransaccionesCC(val, Calendar.getInstance(), Calendar.getInstance().getTime(), cond));
    }


    @PostMapping("/new")
    public RegistroPagosDiarios create(@RequestBody RegistroPagosDiarios registroPago ){
        if (!patService.findByNombre(registroPago.getPatente().getNumero()).isEmpty()){
            registroPago.setPatente(patService.findByNombre(registroPago.getPatente().getNumero()).get(0));
        }
        Calendar cal = registroPago.getFecha();
        if (registroPago.getHoraInicio().getHours()<valService.valorActual().getHsFinM())
            cal.set(Calendar.HOUR, valService.valorActual().getHsFinM()+3);
        else 
            cal.set(Calendar.HOUR, valService.valorActual().getHsFinT()+3);

        cal.set(Calendar.MINUTE, 0);
        registroPago.setHoraFin(cal.getTime());
        registroPago.setValor(0);
      return  service.save(registroPago);
      }

    @GetMapping("/all")
    public List<RegistroPagosDiarios> findAll(){
        return service.findAll();
    }

    @PutMapping("/update/{id}")
    public RegistroPagosDiarios update (@PathVariable String id, @RequestBody RegistroPagosDiarios registro) throws Exception{
   

        RegistroPagosDiarios reg = service.findOneByUuid(UUID.fromString(id));/* .orElseThrow(); */
        System.out.println("1+" + reg.getFecha().getTime());
        
       /*  if (registro.getHoraFin().getTime() < reg.getHoraInicio().getTime())
            return throw new Exception("La hora de fin no puede ser menor a la hora de inicio");
         */
        reg.setHoraFin(registro.getHoraFin());
        System.out.println("2+" + reg.getHoraFin());
        //---- valida que la hora de finalizacion este en el horario vigente
        /* System.out.println(reg.getHoraInicio().getTime()/3600000);
        System.out.println(registro.getHoraFin().getTime()-10800000); */ 
        //System.out.println(reg.getFecha().toString());
        Calendar cal = reg.getFecha();
        System.out.println("asdada+" + reg.getFecha().getTime());
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, 10);
        cal.set(Calendar.DATE, 10);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println("aca+" + reg.getFecha().getTime());
        cal.setTime(registro.getHoraFin());
        System.out.println("HORA FIINNNN" + cal.getTime());
        System.out.println("3+" + reg.getFecha().getTime());
/*      
        Calendar cal2 = reg.getFecha();
        cal2.set(Calendar.YEAR, 2022);
        cal2.set(Calendar.MONTH, 10);
        cal2.set(Calendar.DATE, 10);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        System.out.println(cal.getTime().toString());
        System.out.println(cal2.getTime().toString()); */

        
        //si el estacionamiento se finaliza luego del horario de la mañana
         if (((registro.getHoraFin().getTime()-10800000)/3600000>=valService.valorActual().getHsFinM())
         && ((reg.getHoraInicio().getTime()-10800000)/3600000<=valService.valorActual().getHsInicioT())) {
            System.out.println("ENTRO 1");
            cal.set(Calendar.HOUR_OF_DAY, valService.valorActual().getHsFinM());
            cal.set(Calendar.MINUTE, 00);
            reg.setHoraFin(cal.getTime());
        }
            
        System.out.println("4+" + reg.getFecha().getTime());
        //si el estacionamiento se finaliza luego del horario de la tarde
        if ((registro.getHoraFin().getTime()-10800000)/3600000>=valService.valorActual().getHsFinT()
        && ((reg.getHoraInicio().getTime()-10800000)/3600000>=valService.valorActual().getHsInicioT())) {
            System.out.println("ENTRO 2");
            cal.set(Calendar.HOUR_OF_DAY, valService.valorActual().getHsFinT());
            cal.set(Calendar.MINUTE, 00);
            reg.setHoraFin(cal.getTime());
        } 
             
        
        /* System.out.println(registro.getHoraFin().getTime()/3600000);
        System.out.println(valService.valorActual().getHsFinM());
        registro.setHoraFin(cal.getTime()); */
        /* getHoraFin().setTime(cal.getTimeInMillis()); */
        //System.out.println(registro.getHoraFin().toString());
        
       //System.out.println(reg.getHoraFin().get);
       System.out.println("5+" + reg.getFecha().getTime());
        int min = ((reg.getHoraFin().getHours()*60+reg.getHoraFin().getMinutes()) - (reg.getHoraInicio().getHours()*60+reg.getHoraInicio().getMinutes()));
        //Long min = (reg.getHoraInicio().getTime() - reg.getHoraFin().getTime()) / 60000;
        System.out.println(min);
        int val = (int) Math.round(min * valService.valorActual().getValor());
        reg.setValor(val);
        descSaldo(-val, reg.getConductor());
        reg.setFecha(registro.getFecha());
        System.out.println("final" + reg.getHoraFin());
        return service.save(reg);
    }


    //deprecated por ahora
    @GetMapping("/minTotales/{id}") 
    public int minutos(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();

        Long min = (reg.getHoraInicio().getTime() - reg.getHoraFin().getTime()) / 60000;

        return min.intValue();
    }   

    //deprecated por ahora
    @PutMapping("/valor/{id}")
    public long valor(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();
    
        reg.setValor((int) Math.round(minutos(id) * valService.valorActual().getValor())); 
        service.save(reg);
        
        return reg.getValor();
    }  
}

    
