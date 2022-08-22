/*
 Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример

InputStream последовательно возвращает четыре байта: 48 49 50 51.

Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
*/

import java.io.*;
import java.nio.charset.Charset;

public class Main{
    public static void main(String [] args) throws IOException {
        ByteArrayInputStream test  = new ByteArrayInputStream(new byte[] {48 ,49 ,50 ,51});
        System.out.println(readAsString(test,  java.nio.charset.StandardCharsets.UTF_8));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        
        StringWriter writer = new StringWriter();

        int readInt;
        while ((readInt = reader.read()) >0){
            writer.write(readInt);
        }
        return writer.toString();
    }

}

// У класса String есть конструктор от массива байтов и кодировки.
// public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//     int block;
//     while ((block = inputStream.read()) != -1) {
//         outputStream.write(block);
//     }
//     return new String(outputStream.toByteArray(), charset);
// }