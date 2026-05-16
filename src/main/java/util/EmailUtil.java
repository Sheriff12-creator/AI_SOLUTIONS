package util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailUtil {

    private static final String EMAIL =
            "ofentsesherifflebani@gmail.com";

    private static final String PASSWORD =
            "dmxu hwyh gdon tgpc";

    public static void sendToken(String recipient,
                                 String token) {

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        Session session =
                Session.getInstance(props,
                        new Authenticator() {

                            protected PasswordAuthentication
                            getPasswordAuthentication() {

                                return new PasswordAuthentication(
                                        EMAIL,
                                        PASSWORD
                                );
                            }
                        });

        try {

            Message message =
                    new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(EMAIL)
            );

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );

            message.setSubject(
                    "AI-Solutions Secure Authentication Token"
            );

            message.setText(
                    "Your secure login token is:\n\n"
                            + token +
                            "\n\nThis token expires in 2 minutes."
            );

            Transport.send(message);

            System.out.println(
                    "Authentication token email sent."
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}