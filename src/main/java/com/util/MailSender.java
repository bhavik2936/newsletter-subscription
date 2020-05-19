package com.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

@Service
public class MailSender {
	
	DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
	
	public void sendMail(String receiver, String subject, String message) {
		
		Email from = new Email("bhavik2936@gmail.com", "Bhavik Parmar");
	    Email to = new Email(receiver);
	    Email bcc = new Email("bhavik2936@outlook.com", "Bhavik Parmar");

	    Personalization personalization = new Personalization();
	    personalization.addTo(to);
	    personalization.addBcc(bcc);
	    
	    message = "<div dir='ltr'><br clear='all'><div>" + message + "</div>-- <br><div dir='ltr' class='gmail_signature' data-smartmail='gmail_signature'><div dir='ltr'><div><div dir='ltr'><blockquote style='margin:0px 0px 0px 0.8ex;border-left:1px solid rgb(204,204,204);padding-left:1ex'><font color='#0b5394'><span style='font-size:large'>Bhavik Parmar<br></span></font><a href='http://linkedin.com/in/bhavikpparmar' target='_blank'><img src='http://drive.google.com/uc?id=1ReO19Ken2r1as1RB8D3UgC6mGLOdjQjh' style='color:rgb(11,83,148);font-size:large' height='30px' width='35px'></a><font color='#0b5394'><br></font></blockquote><div><div dir='ltr'><blockquote style='margin:0px 0px 0px 40px;border:none;padding:0px'></blockquote></div></div></div></div></div></div></div>";
	    Content content = new Content("text/html", message);
	    Mail mail = new Mail(from, subject, to, content);
	    mail.addPersonalization(personalization);
	    
	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(df.format(new Date()) + "\t MailSender (" + response.getStatusCode() + "): Sent mail to " + receiver + " with subject of '" + subject + "'");
	      if (response.getStatusCode() >= 400) {
	    	  System.out.println("\t\t\t " + response.getBody());
	      }
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	}
}
