
//class Pair
public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;
    
    private Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public static <T1,T2> Pair<T1, T2>  of(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    public T1 getFirst(){
        if (first == null){
            throw new java.util.NoSuchElementException("No first value present");
        }
        return first;
    }

    public T2 getSecond(){
        if (second == null){
            throw new java.util.NoSuchElementException("No second value present");
        }
        return second;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Pair){
            Pair<?,?> other = (Pair<?,?>) obj;
            return java.util.Objects.equals(first, other.first) && java.util.Objects.equals(second, other.second);
        }

        return false;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hashCode(first) + java.util.Objects.hashCode(second);
    }


}
