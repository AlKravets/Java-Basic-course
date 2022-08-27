import java.util.*;
import java.util.function.*;

public class MailMessage extends AbstractSendable<String>{

    private final String content;

    public MailMessage(String from, String to, String content){
        super(from, to);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String get(){
        return content;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof MailMessage){
            MailMessage other = (MailMessage) obj;
            return to.equals(other.to) && from.equals(other.from) && content.equals(other.content);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return super.hashCode() + content.hashCode();
    }

    @Override
    public String toString(){
        return "(MailMessage" + super.toString() + " content: "+ content + " )";
    }
}

