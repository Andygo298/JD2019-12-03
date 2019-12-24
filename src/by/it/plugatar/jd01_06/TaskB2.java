package by.it.plugatar.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Вывести через \nвсе предложения текста в порядке возрастания количества символов (!) в каждом из них.
// В предложениях нужно сначала заменить все небуквенные символы и их последовательности на один пробели выполнить
// trim() для каждого предложения.
public class TaskB2 {
    public static void main(String[] args) {

        String text=Poem.text;
        text=text.replace("\n"," ");
        text=text.replace(" - "," ");
        text=text.replace(", "," ");
        text=text.replace("..."," ");
        text=text.replace(": "," ");
        text=text.replace("! "," ");
        text=text.replace("!","");


        String[] arrayText= text.split("\\.");
        for (int i = 0; i < arrayText.length; i++) {
            arrayText[i]=arrayText[i].trim();
        }

        sort(arrayText);

        for (int i = 0; i < arrayText.length; i++) {
            System.out.print(arrayText[i]+'\n');
        }


    }

    private static void sort(String[] arrayText) {

        boolean complete;

        do {
            complete=false;
            for (int i = 0; i < arrayText.length-1; i++) {

                if (arrayText[i].length() > arrayText[i + 1].length()) {
                    String buf;
                    buf=arrayText[i];
                    arrayText[i]=arrayText[i+1];
                    arrayText[i+1]=buf;
                    complete=true;
                }
            }

        }while (complete);


    }
}