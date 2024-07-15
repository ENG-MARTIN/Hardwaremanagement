/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexatek;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * 
 * @author chipcodedev
 */
public class email {
    
   public static void main(String[] args) {
      
        String to = "martinsseba3@gmail.com";
        String from = "martinsseba3@gmail.com";
        final String username = "martinsseba3@gmail.com"; // Your email
        final String password = "kilyxoranmdpunza"; // Your email password

        String host = "smtp.gmail.com"; // or your SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // or 465 for SSL
        props.put("mail.smtp.ssl.protocols", "TLSv1 TLSv1.1 TLSv1.2 TLSv1.3"); // Enable all TLS versions
        props.put("mail.debug", "true");
        
        // Get the Session object
         Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Test Email");

            // Now set the actual message
            message.setText("Hello, this is a test email!");

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
