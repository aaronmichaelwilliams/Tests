import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ReadSpreadSheetTest {
    @Mock
    ReadSpreadSheet rss;

    @Before
    public void setup() throws IOException {
        rss = Mockito.mock(ReadSpreadSheet.class);
        when(rss.getCellData(1, 1)).thenReturn("465456446");
        when(rss.getUserID()).thenCallRealMethod();
    }

    @Test
    public void testResults() {
        System.out.println(rss.getUserID());
    }

}