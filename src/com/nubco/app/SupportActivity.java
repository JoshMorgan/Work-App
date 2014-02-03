package com.nubco.app;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_layout);

        Button login = (Button) findViewById(R.id.mBtnSubmit);
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("NubcoAppNoReply@gmail.com", "NubcoApp9192");
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("NubcoAppNoReply@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jm109876543210@gmail.com"));
                    message.setSubject("Enquiry");
                    message.setContent("General Enquiry from Josh Morgan", "text/html; charset=utf-8");

                    Transport.send(message);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}