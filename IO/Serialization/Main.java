import java.io.*;
import java.lang.IllegalArgumentException;

public class Main{

    public static void main(String [] args) {
        
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        ByteArrayInputStream dataByteStream = new ByteArrayInputStream(data);
        Animal [] animalArray;
        try ( ObjectInputStream ois = new ObjectInputStream(dataByteStream)){
            int size = ois.readInt();
            animalArray = new Animal[size];
            for (int i=0; i < size; ++i){
                animalArray[i] = (Animal) ois.readObject();
            }
        } catch  (IOException |  ClassCastException |
                SecurityException | NullPointerException |
                ClassNotFoundException ex) {
                    throw new IllegalArgumentException(ex);
                }

        return animalArray;
    }   
}



// public static Animal[] deserializeAnimalArray(byte[] data) {
//     try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {

//         Animal[] Animal = new Animal[ois.readInt()];

//         for (int i = 0; i < Animal.length; i++)
//             Animal[i] = (Animal) ois.readObject();


//         return Animal;
//     } catch (Throwable e) {
//         throw new IllegalArgumentException();
//     }
// }