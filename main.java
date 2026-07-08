public class Main {

    public static void main(String[] args) {

        LogAnalyzer analyzer = new LogAnalyzer();

        analyzer.readLogs("server.log");

        analyzer.generateReport();
    }
}
