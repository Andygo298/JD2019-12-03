package by.it.lozouski.calc;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public abstract class Report {
    void startReport(LocalDateTime localDateTimeStart) {
    }

    void reportWriteOperation(String logOperation) {
    }

    void reportWriteErrors(String logError) {
    }

    void finishReport(LocalDateTime localDateTimeFinish) {
    }
}

class LongReport extends Report {
    @Override
    void startReport(LocalDateTime localDateTimeStart) {
        System.out.println("---------LONG report start--------- "
                + localDateTimeStart.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }

    @Override
    void reportWriteOperation(String logOperation) {
        System.out.println("---------LONG list of operations(25 last lines):");
        try {
            Files.lines(Paths.get(logOperation)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Empty file.");
        }
    }

    @Override
    void reportWriteErrors(String logError) {
        System.out.println("---------LONG list of errors(25 last lines):");
        try {
            Files.lines(Paths.get(logError)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Empty file.");
        }
    }

    @Override
    void finishReport(LocalDateTime localDateTimeFinish) {
        System.out.println("---------LONG report finish---------- " + localDateTimeFinish.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }
}

class ShortReport extends Report {
    @Override
    void startReport(LocalDateTime localDateTimeStart) {
        System.out.println("---------SHORT report start--------- " + localDateTimeStart.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }

    @Override
    void reportWriteOperation(String logOperation) {
        System.out.println("---------SHORT list of operations(25 last lines):");
        try {
            Files.lines(Paths.get(logOperation)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Empty file.");
        }
    }

    @Override
    void reportWriteErrors(String logError) {
        System.out.println("---------SHORT list of errors(25 last lines):");
        try {
            Files.lines(Paths.get(logError)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Empty file.");
        }
    }

    @Override
    void finishReport(LocalDateTime localDateTimeFinish) {
        System.out.println("---------SHORT report finish---------- " + localDateTimeFinish.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }
}
