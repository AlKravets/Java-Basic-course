// public static class Inspector implements MailService

public class Inspector implements MailService{
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail){
        if (mail instanceof MailPackage){
            Package inspectedPackage = ((MailPackage) mail).getContent();

            if (inspectedPackage.getContent().equals(WEAPONS) ||
                        inspectedPackage.getContent().equals(BANNED_SUBSTANCE)){
                
                throw new IllegalPackageException(
                    "Find illegal package content: " + inspectedPackage.getContent()
                );
            }

            if (inspectedPackage.getContent().contains("stones")){
                throw new StolenPackageException("Package has been stolen and content : " + inspectedPackage.getContent());
            }
        }

        return mail;
    }

}