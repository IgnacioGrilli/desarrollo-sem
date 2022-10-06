package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.TransaccionesCC;
import com.desarrollo.sem.model.UsuarioConductor;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.desarrollo.sem.service.TransaccionesCCServive;
import com.desarrollo.sem.service.UsuarioConductorService;

@RestController
@RequestMapping("conductor")
public class UsuarioConductorServlet {

    @Autowired
    private UsuarioConductorService service;

    @Autowired
    private TransaccionesCCServive serviceTransaccion;

    @GetMapping("/all")
    public List<UsuarioConductor> findAll() {
        return service.findAll();
    }

    @GetMapping("/mail/{mail}/")
    public UsuarioConductor findMail(@PathVariable String mail) {
        return service.findByMail(mail);
    }

    /*
     * @GetMapping("/calculoSaldoMail/{val}")
     * public List<Double> findSaldoUsua(@PathVariable String val) {
     * long idCuenta = service.findByMail(val).getCuenta().getId();
     * System.out.println("////////////////////////" + idCuenta);
     * return service.findBySaldo(idCuenta);
     * }
     */

    @GetMapping("/calculoSaldoMail/{mail}/{fecha}")
    public String findSaldoUsua(@PathVariable String mail, @PathVariable String fecha) {
        long idCuenta = service.findByMail(mail).getId();

        // pasa el String a un Calendar
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String data;

        try {

            Calendar cal = Calendar.getInstance();
            Date date;
            date = df.parse(fecha);
            cal.setTime(date);

            data = "El saldo de " + mail + " a la fecha " + fecha + " es de: " + String.valueOf(service.findBySaldo(idCuenta, cal));
        } catch (ParseException p) {
            return ResponseMessage
                    .message(502, "No se pudo dar formato a la fecha", p.getMessage());
        }

        return ResponseMessage.message(
            200,
            "Saldo calculado con éxito",
            data);

    }

    /*
     * @PutMapping("/newMovimiento/{val}")
     * public UsuarioConductor newMovimiento(@RequestBody UsuarioConductor
     * conductor, @PathVariable Double val) {
     * 
     * TransaccionesCC trasacAux = null;
     * CuentaCorriente cuenta =null;
     * UsuarioConductor conductoraux = findMail(conductor.getMail());
     * 
     * //si el conductor existe (corrobora con el mail)
     * if (null != service.findByMail(conductor.getMail())) {
     * System.out.println("/ooooooooooooooo"+
     * findMail(conductor.getMail()).getCuenta());
     * cuenta = conductoraux.getCuenta();
     * trasacAux = serviceTransaccion.save(new TransaccionesCC(val, null,
     * null,cuenta));
     * cuenta.getTransaccion().add(trasacAux);
     * return service.save(conductoraux);
     * }
     * //else
     * System.out.println("nuloooooooooooo");
     * return null;
     * }
     */

    @PutMapping("/newMovimiento/{val}")
    public String newMovimiento(@RequestBody UsuarioConductor conductor, @PathVariable Double val) {

        UsuarioConductor conductoraux = findMail(conductor.getMail());

        // si el conductor existe (corrobora con el mail)
        if (null != service.findByMail(conductor.getMail())) {
            // guarda la nueva transaccion

            serviceTransaccion.save(new TransaccionesCC(val, Calendar.getInstance(), null, conductoraux));

            // actualiza el saldo del usuario
            // -----------------------------------------------------------
            // conductoraux.setSaldo(findSaldoUsua(conductor.getMail()).get(0));
            // System.out.println(findSaldoUsua(conductor.getMail()).get(0));

            // retorna usuarioConductor con todas las transacciones
            service.save(conductoraux);
            return "nuevo movimiento registrado";
        }
        // else
        return "ERROR (usuario no registrado)";
    }

}
