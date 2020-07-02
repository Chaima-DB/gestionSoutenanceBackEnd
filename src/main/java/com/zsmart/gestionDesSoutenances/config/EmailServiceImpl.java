/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.config;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
 
   @Autowired 
    EmailConfig emailCfg;
 
     public void sendEmailToDoctorant(Doctorant doctorant){
      String txt = "Merci pour votre inscription, vous pouvez désormais s'authentifier a votre compte du CED-FSTG" ;
        // Create a mail sender
         JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable","true");

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("chimox751@gmail.com");
        mailMessage.setTo(doctorant.getUser().getEmail());
        mailMessage.setSubject("Confirmation d'inscription pour"+ doctorant.getNom() + doctorant.getPrenom());
        mailMessage.setText(txt);

        // Send mail
        mailSender.send(mailMessage);
    }
}