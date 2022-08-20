
// public static class Thief implements MailService

public class Thief implements MailService{
    private final int minPackageCost;
    private int stolenSum = 0;

    public Thief(int minPackageCost){
        this.minPackageCost = minPackageCost;
    }

    public int getStolenValue(){
        return stolenSum;
    }

    @Override
    public Sendable processMail(Sendable mail){
        if (mail instanceof MailPackage){
            Package stolenPackage = ((MailPackage) mail).getContent();
            if ( stolenPackage.getPrice() >= minPackageCost){
                stolenSum += stolenPackage.getPrice();
                Package emptyPackage = new Package("stones instead of " + stolenPackage.getContent(),0);
                mail = new MailPackage(mail.getFrom(), mail.getTo(), emptyPackage);
            }
        }

        return mail;
    }



}