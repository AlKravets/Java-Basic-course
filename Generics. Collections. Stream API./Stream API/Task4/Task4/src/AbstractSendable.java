import java.util.function.Supplier;

public abstract class AbstractSendable<T> implements Supplier<T> {
    final protected String from;
    final protected String to;

    public AbstractSendable (String from, String to){
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof AbstractSendable<?>){
            AbstractSendable<T> other = (AbstractSendable<T>) obj;
            return to.equals(other.to) && from.equals(other.from);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return to.hashCode()+ from.hashCode();
    }

    @Override
    public String toString(){
        return "(Sendable: " + "from: " + from.toString()
                + " to: " + to.toString() + ")";
    }

    @Override
    public abstract  T get();
}
