import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadSpreadSheet {

    private String fileLocation;
    private static FileInputStream files;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

   public void setFileLocation(String fileLocation) throws IOException {
       this.fileLocation = fileLocation;
       files = new FileInputStream(new File(fileLocation));
       workbook = new XSSFWorkbook(files);
   }

   public String getFileLocation() {
       return fileLocation;
   }

   public void setSheet(int sheetNumber) {
       XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
   }

   public String getCellData(int row, int cell) {
       String result = sheet.getRow(row).getCell(cell).getStringCellValue();
       return result;
   }

   public String getUserID()  {
       String userId = getCellData(1,1);
       return "Welcome " + userId;
   }

}