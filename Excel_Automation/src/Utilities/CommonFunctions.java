package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {

  public String[] getWindowsList(WebDriver driver) {
    Set<String> windowLists = driver.getWindowHandles();
    return windowLists.toArray(new String[windowLists.size()]);
  }

  public List<List<String>> excelReader(String fileName) {
    List<List<String>> excelData = new ArrayList<List<String>>();
    
    try {
      InputStream file = this.getClass().getClassLoader().getResourceAsStream(fileName);
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheetAt(0);
      Iterator<Row> rowIterator = sheet.iterator();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        ArrayList<String> temp = new ArrayList<String>();
        
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
          case Cell.CELL_TYPE_NUMERIC:
            temp.add(Integer.toString((int) cell.getNumericCellValue()));
            break;
          case Cell.CELL_TYPE_STRING:
            temp.add(cell.getStringCellValue());
            break;
          default :
            break;
          }
        }
        excelData.add(temp);
      }
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return excelData;
  }
}
