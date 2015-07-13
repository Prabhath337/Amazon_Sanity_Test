package Excel_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class read_excel 
{
	private static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	private static String excel_path="C:\\Users\\Prabhath Sharma\\workspace\\Amazon\\src\\Excel_Utility\\login_data.xlsx";
	private static FileInputStream file;
	private static int no_rows() 
	{
		try
		{
			file=new FileInputStream(excel_path);
			wb=new XSSFWorkbook(file);
			int row=wb.getSheet("data").getLastRowNum();
			return row;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				file.close();
				wb.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	private static int no_columns()
	{
		try
		{
			file=new FileInputStream(excel_path);
			wb=new XSSFWorkbook(file);
			int column=wb.getSheet("data").getRow(0).getLastCellNum();
			return column;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				file.close();
				wb.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static String emailid()
	{
		try
		{
			file=new FileInputStream(excel_path);
			wb=new XSSFWorkbook(file);
			int rows=no_rows();
			int columns=no_columns();
			if(rows>1)
			{
				XSSFCell data=wb.getSheet("data").getRow(1).getCell(1);
				String cell_emailid=data.toString();
				return cell_emailid;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static String password()
	{
		try
		{
			file=new FileInputStream(excel_path);
			wb=new XSSFWorkbook(file);
			int rows=no_rows();
			//int columns=no_columns();
			if(rows>1)
			{
				XSSFCell data=wb.getSheet("data").getRow(1).getCell(2);
				String cell_password=data.toString();
				return cell_password;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

