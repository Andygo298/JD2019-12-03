package by.it.shulga.jd01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class   TaskA1 {
        public static void main(String[] args) {
            StringBuilder sbr = new StringBuilder(Poem.text);
            Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}+");
            Matcher matcher = pattern.matcher(Poem.text);
            while  (matcher.find()) {
                int start = matcher.start();
                sbr.setCharAt(start + 3, '#');
                if  (matcher.group().length() >= 7) {
                    sbr.setCharAt(start + 6, '#');
                }
            }
              System.out.println(sbr);
        }
    }


