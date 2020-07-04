/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.config;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    DoctorantService doctorantService;
   @Autowired 
    EmailConfig emailCfg;
 
     public void sendEmailToDoctorant(Doctorant doctorant) throws MessagingException{
      String txt = "Merci pour votre inscription, vous pouvez désormais s'authentifier a votre compte du CED-FSTG"
              + "<br/>"+ "Il vous reste seulement l'étape de confirmation en cliquant sur le lien suivant :  "
              + "<br/><a href='http://localhost:4200/confirmation/"+doctorant.getCin()+"'>Lien</a>" ;
        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable","true");
        
         MimeMessage message = mailSender.createMimeMessage();

        // Set From: header field of the header.
        message.setFrom("chimox751@gmail.com");

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(doctorant.getUser().getEmail()));

        // Set Subject: header field
        message.setSubject("Confirmation d'inscription pour "+ doctorant.getNom() + doctorant.getPrenom());

        // Now set the actual message
        message.setText(txt, "UTF-8", "html");

//        // Create an email instance
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("chimox751@gmail.com");
//        mailMessage.setTo(doctorant.getUser().getEmail());
//        mailMessage.setSubject("Confirmation d'inscription pour"+ doctorant.getNom() + doctorant.getPrenom());
//        mailMessage.setText(txt);

        // Send mail
        mailSender.send(message);
    }
}