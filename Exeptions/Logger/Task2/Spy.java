import java.util.logging.*;
// public static class Spy

public class Spy implements MailService{
    private final Logger logger;

    //
    public static final String AUSTIN_POWERS = "Austin Powers";
    //

    public Spy(Logger logger){
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage){
            if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)){
                logger.log(Level.WARNING,"Detected target mail correspondence: from {0} to {1} \"{2}\"",
                    new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else{
                logger.log(Level.INFO,"Usual correspondence: from {0} to {1}",
                    new Object[] {mail.getFrom(), mail.getTo()});
            }
        }
        return mail;
    }

}