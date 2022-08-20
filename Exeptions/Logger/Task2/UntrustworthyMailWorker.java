// public static class UntrustworthyMailWorker

public class UntrustworthyMailWorker implements MailService{
    private final MailService [] chainOfThirdPersons;
    private final RealMailService internalRealMailService = new RealMailService(); 

    public UntrustworthyMailWorker (MailService [] chainOfThirdPersons){
        this.chainOfThirdPersons = chainOfThirdPersons;
    }
    public RealMailService getRealMailService(){
        return internalRealMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService chainEl: chainOfThirdPersons){
            mail = chainEl.processMail(mail);
        }
        return internalRealMailService.processMail(mail);
    }

}