import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileLocation = "data.xlsx";
        ReadWriteExcel excel = new ReadWriteExcel();
        excel.readExcel(fileLocation);
    }
}
