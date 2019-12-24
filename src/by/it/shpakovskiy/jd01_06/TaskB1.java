package by.it.shpakovskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] vowels = {'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю', 'ё'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (matcher.group().length() > 1) {
                if (checkWords(matcher.group().toLowerCase())) {
                    System.out.println(matcher.group());
                }
            }
        }
    }

    private static boolean checkWords(String word) {
        boolean flagFirst = true;
        boolean flagLast = false;
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        for (char ch : vowels) {
            if (firstLetter == ch) {
                flagFirst = false;
                break;
            }
        }
        for (char ch : vowels) {
            if (lastLetter == ch) {
                flagLast = true;
                break;
            }
        }
        return flagFirst && flagLast;
    }

}
