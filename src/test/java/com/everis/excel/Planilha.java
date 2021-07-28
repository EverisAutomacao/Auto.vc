package com.everis.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Planilha {

	public String fileName = "";
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	public String nameWorkSheet = "";
	public String dvTablename = "";
	public XSSFCell Cell; // celula
	public XSSFRow Row; // linha

	public void ds_startExcel(String f, String sheetName) {
		dvTablename = sheetName;
		fileName = f;
		ds_getName();

		try {
			file = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param row = linha
	 * @param col = coluna
	 * @return = valor da celula
	 */
	public String getValue(int row, int col) {
		try {
			return sheet.getRow(row).getCell(col).toString();
		} catch (Exception e) {
			return "";
		}
	}

	public String getValue(int row, String columnName) {
		try {
			int col = df_getColumnName(columnName);
			DataFormatter fmt = new DataFormatter();

			return fmt.formatCellValue(sheet.getRow(row).getCell(col));
		} catch (Exception e) {
			return "";
		}
	}

	@SuppressWarnings("unused")
	public void ds_writeData(String data, int row, int col) {
		XSSFCellStyle style = sheet.getRow(1).getCell(1).getCellStyle();
		XSSFCell cell = sheet.getRow(row).createCell(col); // celula
		try {
			sheet.getRow(row).createCell(col).setCellValue(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// cell.setCellStyle(style);
	}

	/**
	 * 
	 * @param valor
	 * @param row
	 * @param nomeDaColuna
	 */
	public void ds_writeData(String valor, int row, String nomeDaColuna) {
		try {
			int col = df_getColumnName(nomeDaColuna);
			sheet.getRow(row).createCell(col).setCellValue(valor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ds_closeData() {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ds_saveData() throws IOException {
		// System.out.println(fileName);
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param name = nome da coluna
	 * @return = numero da coluna
	 */
	public int df_getColumnName(String name) {
		int col = 0;
		while (getValue(0, col) != "NoDataFound") {
			if (getValue(0, col).equals(name))
				return col;
			col++;
		}
		return col;
	}

	public void ds_updateExcel(String sheetName) {
		try {
			ds_saveData();
			file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ds_addRow(int currentRow) {
		// XSSFCellStyle style = sheet.getRow(1).getCell(1).getCellStyle();
		try {
			sheet.shiftRows(currentRow, sheet.getLastRowNum(), 1);
		} catch (Exception e) {
		}
		try {
			ds_saveData();
		} catch (IOException e) {
		}
		// ds_updateExcel("Resultado");
		ds_updateExcel(dvTablename);
		sheet.createRow(currentRow);
		// sheet.createRow(currentRow).setRowStyle(style);
	}

	public void ds_getName() {
		String[] path;
		path = fileName.split("/");
		nameWorkSheet = path[path.length - 1];
		nameWorkSheet = nameWorkSheet.replace(".xlsx", "");
		nameWorkSheet = nameWorkSheet.replace(".xls", "");
	}

	// fonte: https://stackoverflow.com/questions/3454975/writing-to-excel-in-java
	// ============================================================================

	public String getCellValue(String name, int rowNumber) throws Exception {
		try {
			int colNumber = getColumnNumber(name);
			Cell = sheet.getRow(rowNumber).getCell(colNumber);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public String getCellValue(int RowNum, int ColNum) throws Exception {
		try {
			Cell = sheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * @param name = Nome da coluna
	 * @return = Numero da coluna
	 */
	public int getColumnNumber(String name) throws Exception {
		int col = 0;
		while (!getCellValue(0, col).isEmpty()) {
			if (getCellValue(0, col).equals(name)) {
				return col;
			}
			col++;
		}
		if (getCellValue(0, col).isEmpty()) {
			System.out.println("No Data Found");
			return 0;
		}
		return col;
	}

	/**
	 * Escreve na celula
	 * 
	 * @param Result = Valor a ser salvo
	 * @param RowNum = Numero da linha
	 * @param ColNum = Numero da coluna
	 */
	public void setCellValue(String value, int RowNum, int ColNum) {
		try {
			Cell = sheet.getRow(RowNum).getCell(ColNum);
			Cell.setCellValue(value);
			FileOutputStream fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Escreve na celula
	 * 
	 * @param colName = Nome da coluna
	 * @param value   = Valor a ser salvo
	 */
	public void setCellValue(String colName, int rowNumber, String value) {
		try {

			int ColNumber = getColumnNumber(colName); // numero da coluna
			// System.out.println("A coluna " + colName + " Esta na coluna: " + ColNumber);

			Cell = sheet.getRow(rowNumber).createCell(ColNumber);
			Cell.setCellValue(value);
			FileOutputStream fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cria uma nova linha e escreve um valor
	 * 
	 * @param Result = valor a ser escrito
	 * @param RowNum = linha
	 * @param ColNum = coluna
	 */
	public void setCellDataNewLine(String Result, int RowNum, int ColNum) {
		try {
			Row = sheet.createRow(RowNum);
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
			FileOutputStream fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muda a referencia para aba passada no parametro
	 * 
	 * @param nomeDaAba
	 */
	public void trocarAba(String nomeDaAba) {
		sheet = workbook.getSheet(nomeDaAba);
	}

}
