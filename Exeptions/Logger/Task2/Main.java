import java.util.logging.*;

public class Main{
    public static void main(String [] args) {
        MailMessage mail = new MailMessage("1Austin Powers", "_to", "_message");
        System.out.println(mail.toString());
        
        RealMailService test_service = new RealMailService();

        System.out.println(test_service.processMail(mail).toString());


        MailPackage pack = new MailPackage("_from", "_to", new Package("32banned substance", 12));

        System.out.println(pack.toString());

        System.out.println(test_service.processMail(pack).toString());

        Thief work  = new Thief(13);

        
        Sendable res = work.processMail(pack);
        System.out.println(res.toString());

        Inspector ins = new Inspector();
        System.out.println(ins.processMail(res).toString());

    }   

}