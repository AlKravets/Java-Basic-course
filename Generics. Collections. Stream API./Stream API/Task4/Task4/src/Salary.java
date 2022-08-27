public class Salary extends AbstractSendable<Integer> {
    private final Integer value;
    public Salary(String from, String to, Integer value){
        super(from, to);
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }

    @Override
    public Integer get(){
        return value;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Salary){
            Salary other = (Salary) obj;
            return to.equals(other.to) && from.equals(other.from) && value.equals(other.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return super.hashCode() + value.hashCode();
    }

    @Override
    public String toString(){
        return "(Salary" + super.toString() + " content: "+ value + " )";
    }

}
