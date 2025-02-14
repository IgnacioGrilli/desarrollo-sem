// Source code is decompiled from a .class file using FernFlower decompiler.
package com.desarrollo.sem.servlet;

import com.desarrollo.sem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/email"})
public class EmailController {
   @Autowired
   private EmailService emailService;

   public EmailController() {
   }

   @PostMapping({"/send"})
   public String sendEmail(@RequestBody EmailRequest emailRequest) {
      this.emailService.sendEmail(emailRequest.getRecipients(), emailRequest.getSubject(), emailRequest.getBody());
      return "Correo enviado exitosamente";
   }
}