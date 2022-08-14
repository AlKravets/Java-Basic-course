
/*
 * Вам дан список ролей и сценарий пьесы в виде массива строчек.

Каждая строчка сценария пьесы дана в следующем виде:
Роль: текст

Текст может содержать любые символы.

Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:

Роль:
i) текст
j) текст2
...
==перевод строки==

i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.

Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно, неправильная сборка результирующей строчки может выйти за ограничение по времени.

Обратите внимание еще на несколько нюансов:

имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
будьте внимательны, не добавляйте лишних пробелов в конце строк.
 */

public class PrintTextPerRole{
    public static void main(String [] args) {
        String [] roles= {
            "Городничий","Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"};
        String [] textLines={
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        
        
        String res = printTextPerRole(roles, textLines);

        System.out.println(res);
        
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (String name: roles){
            result.append(name);
            result.append(":\n");
            
            for (int index = 0; index < textLines.length; ++index){
                String text = textLines[index];

                if (text.startsWith(name + ": ")){
                    StringBuilder printingString= new StringBuilder();
                    printingString.append(index+1);
                    printingString.append(") ");
                    printingString.append(text.substring(name.length() + 2));
                    printingString.append('\n');

                    result.append(printingString.toString());
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
    

}


// variant from comments
// Может не самое короткое, но как замечали ниже - зато мы перебираем 50 000 строк пьесы только однажды
// private String printTextPerRole(String[] roles, String[] textLines) {
//     StringBuilder[] rolesWithText = new StringBuilder[roles.length];
//             for (int i = 0; i<roles.length; i++) {
//                 rolesWithText[i] = new StringBuilder(roles[i] + ":\n");
//             }
    
//             for (int i = 0; i<textLines.length; i++) {
//                 for (int j = 0; j<roles.length; j++) {
//                     if (textLines[i].startsWith(roles[j] + ":")) {
//                         rolesWithText[j].append(textLines[i].replaceFirst(roles[j] + ":", (i+1) + ")") + "\n");
//                         break;
//                     }
//                 }
//             }
//             StringBuilder output = new StringBuilder("");
//             for (StringBuilder r: rolesWithText) {
//                 output.append(r+"\n");
//             }
//             return output.toString();
//     }