import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DifferentFileTypesTests {
    private final static ClassLoader classLoader = DifferentFileTypesTests.class.getClassLoader();

    @Test
    void checkZipFilesTest() throws IOException, CsvException {
        try (InputStream inputStream = classLoader.getResourceAsStream("output.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zipInputStream);
                    Assertions.assertTrue(pdf.text.contains("Пример pdf"));
                } else if (zipEntry.getName().contains(".xlsx")) {
                    XLS xls = new XLS(zipInputStream);
                    Assertions.assertEquals(
                            "Тестовый заказ 4",
                            xls.excel
                                    .getSheet("Orders")
                                    .getRow(6)
                                    .getCell(0).getStringCellValue());
                } else if (zipEntry.getName().contains(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zipInputStream));
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertEquals(1, content.size());
                    final String[] firstRow = content.get(0);
                    Assertions.assertArrayEquals(new String[]{"Newline", " newline2"}, firstRow);
                }

            }
        }
    }
}