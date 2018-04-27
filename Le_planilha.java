package Serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Windows
 */

public class Le_planilha {
    
    public Horarios pega_planilha() throws IOException{
                Horarios grade = new Horarios();
		InputStream ExcelFileToRead = new FileInputStream("planilha.xls");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();
                int lin = 0;

		while (rows.hasNext()){
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			int cel = 0;
			while (cells.hasNext()){
				cell=(HSSFCell) cells.next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
					//System.out.print(cell.getStringCellValue());
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
					System.out.print(cell.getNumericCellValue()+" e");
				}
                                if (cell.getStringCellValue().contains(",") == true){
                                    Professor fulano = new Professor();
                                    fulano.setNome(cell.getStringCellValue().split(",")[0]); 
                                    fulano.setSenha(cell.getStringCellValue().split(",")[1]);
                                    //System.out.println("dia: " + cel + "   aula: " + lin + "   professor: " + fulano.getNome());
                                    grade.setAula(fulano, cel, lin);
                                }
                                cel++;
			}
                        lin++;
                }
                return grade;
    }
    
    public void pega_professores() throws IOException{
        ArrayList<String> impressos = new ArrayList<>();
        Horarios grade = new Horarios();
        InputStream ExcelFileToRead = new FileInputStream("planilha.xls");
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

        HSSFSheet sheet=wb.getSheetAt(0);
        HSSFRow row; 
        HSSFCell cell;

        Iterator rows = sheet.rowIterator();
        int lin = 0;

        while (rows.hasNext()){
            row=(HSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            int cel = 0;
            while (cells.hasNext()){
                cell=(HSSFCell) cells.next();

                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
                        //System.out.print(cell.getStringCellValue());
                }
                else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                          System.out.print(cell.getNumericCellValue()+" e");
                }
                if (cell.getStringCellValue().contains(",") == true){
                    //Professor fulano = new Professor();
                    //fulano.setNome(cell.getStringCellValue().split(",")[0]); 
                    //fulano.setSenha(cell.getStringCellValue().split(",")[1]);
                    if(impressos.contains(cell.getStringCellValue().split(",")[0]) == false){
                        impressos.add(cell.getStringCellValue().split(",")[0]);
                        System.out.println("professor: " + cell.getStringCellValue().split(",")[0]);
                    }
                    //grade.setAula(fulano, cel, lin);
                }
                cel++;
            }
            lin++;
        }
    }
        
    /**
     *
     * @throws IOException
     */
    public void pega_senhas() throws IOException{
        ArrayList<String> impressos = new ArrayList<>();
        Horarios grade = new Horarios();
        InputStream ExcelFileToRead = new FileInputStream("planilha.xls");
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

        HSSFSheet sheet=wb.getSheetAt(0);
        HSSFRow row; 
        HSSFCell cell;

        Iterator rows = sheet.rowIterator();
        int lin = 0;

        while (rows.hasNext()){
            row=(HSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            int cel = 0;
            while (cells.hasNext()){
                cell=(HSSFCell) cells.next();

                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
                        //System.out.print(cell.getStringCellValue());
                }
                else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                          System.out.print(cell.getNumericCellValue()+" e");
                }
                if (cell.getStringCellValue().contains(",") == true){
                    //Professor fulano = new Professor();
                    //fulano.setNome(cell.getStringCellValue().split(",")[0]); 
                    //fulano.setSenha(cell.getStringCellValue().split(",")[1]);
                    if(impressos.contains(cell.getStringCellValue().split(",")[0]) == false){
                        impressos.add(cell.getStringCellValue().split(",")[0]);
                        System.out.println("professor: " + cell.getStringCellValue().split(",")[0] + "  senha: " + cell.getStringCellValue().split(",")[1]);
                    }
                    //grade.setAula(fulano, cel, lin);
                }
                cel++;
            }
            lin++;
        }
                
    }
    
}

