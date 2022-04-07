package abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class getInfoExcelFile implements Ability
{
    private String      filePath; /** Ruta del archivo .xls */
    private String      sheetName; /** El nombre del hoja */
    private static XSSFSheet   sxssfSheet;

    /** Constructor */
    public getInfoExcelFile(String filePath, String sheetName)
    {
        this.filePath       = filePath;
        this.sheetName      = sheetName;

        setFile(filePath, sheetName);
    }

    /** Es el equivalente al @Perform de una Task */
    public static getInfoExcelFile as(Actor actor)
    {
        return actor.abilityTo(getInfoExcelFile.class);
    }

    /** El método que me va a permitir desde el StepDefinition
     * instanciar la clase para invocar el llamado del archivo de Excel */
    public static getInfoExcelFile by(String filePath, String sheetName)
    {
        return new getInfoExcelFile(filePath, sheetName);
    }

    /** El método que actualiza/cree una variable de un documento en la
     * Cual le voy a pasar la ruta del documento y el nombre del archivo */
    public void setFile(String filePath, String sheetName)
    {
        try
        {
            FileInputStream FIS          = new FileInputStream(filePath);
            XSSFWorkbook    xssfWorkbook = new XSSFWorkbook(FIS);
                            sxssfSheet   = xssfWorkbook.getSheet(sheetName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** El método que lee y obtiene el contenido del archivo de Excel que se utilizará para el Test */
    public static String getCellData(int rowNumber, int columnNumber)
    {
        XSSFRow xssfRow = sxssfSheet.getRow(rowNumber);
        XSSFCell xssfCell = xssfRow.getCell(columnNumber);

        return xssfCell.getStringCellValue();
    }
}
