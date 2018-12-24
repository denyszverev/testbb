package com.ak_tech.bb.helper;



import javax.mail.*;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Mail {

    private String activationLink = null;  // Ссылка на активацию нового юзера

    public String ReceiveLastEmail() throws Exception {
        Properties properties = new Properties();
        String target = System.getProperty("target", "configMailSecure");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));

        Session session = Session.getInstance(properties, new MailAuth(properties.getProperty("email"),properties.getProperty("passwordForEmail")));
        Store store = session.getStore(properties.getProperty("provider"));
        store.connect(properties.getProperty("host_email"), null, null);

        Folder inbox = store.getFolder("INBOX");

        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1);
        }

        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages(); //Получение всех сообщений в папке "Входящие"

        for (int i = 0; i < messages.length; i++) {
            String subject = messages[i].getSubject().toString().toLowerCase().trim(); //Получение темы письма

            System.out.println("subject: "+ subject);

            String letterConfirmationSubject = "hey , here’s your borderbuddy quote " ; //Тема письма которое содержит активационную ссылку
            System.out.println(letterConfirmationSubject);

            if(subject.equals(letterConfirmationSubject)){

            }

            //Выбор нужного письма
            if (!subject.equals(letterConfirmationSubject)) {
                System.err.println("Сообщение пропущено, т.к. не является активационным письмом.......");
                continue;
            }

            System.out.println("Сообщение принято к обработке");

            Object contentMessage = messages[i].getContent();
            String content = contentMessage.toString();

            System.out.println("contentMessage"+contentMessage);
            System.out.println("content"+content);

//            //Проверка наличия активационной ссылки в теле письма
//            CharSequence searchPhrase = "http://www.someSite.ua/user/confirm/";
//            if (content.contains(searchPhrase)) {
//                System.out.println("ОК.Письмо содержит активационную ссылку.");
//            } else {
//                System.err.println("!!!===SHIT!Письмо не содержит активационную ссылку===!!!");
//                continue;
//            }
//
//            int indexOf = content.lastIndexOf("http://www.someSite.ua/user/confirm/");
//            int lastIndexOf = content.lastIndexOf("--");
//
//            Получение из тела письма активационной ссылки
//            this.activationLink = content.substring(indexOf, lastIndexOf).trim();

        }
        inbox.close(false);
        store.close();
        return activationLink;
    }


    /*-------------------------------------------------------------------------------------------------------*/
    class MailAuth extends Authenticator {

        private String email; //Инициализируем поле в котором хранится значение емейла
        private String password; // Инициализируем поле в котором хранится значение пароля

        MailAuth(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(email, password);
        }
    }
}