package by.it.lozouski.calc;

import java.time.LocalDateTime;

class ReportCreator {
    private Report newReport;
    void chooseReportType(String repType){
        if (repType.equals("long")){
            newReport = new LongReport();
        }else if (repType.equals("short")){
            newReport = new ShortReport();
        }
    }
    void createReport(LocalDateTime localDateTimeStart,LocalDateTime localDateTimeFinish,
                      String operationMessage, String errorMessage){
        newReport.startReport(localDateTimeStart);
        newReport.reportWriteOperation(operationMessage);
        newReport.reportWriteErrors(errorMessage);
        newReport.finishReport(localDateTimeFinish);
    }
}
