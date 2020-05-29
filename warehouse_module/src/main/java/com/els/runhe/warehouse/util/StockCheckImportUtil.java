package com.els.runhe.warehouse.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.els.base.core.exception.CommonException;
import com.els.runhe.warehouse.model.StockCheckImport;

/**
 * 操作Excel表格的功能类(针对Excel2007以后xlsx格式)
 */
public class StockCheckImportUtil {

	public static List<StockCheckImport> readImportData(InputStream in) throws Exception {
		List<StockCheckImport> list = null;
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(in);
			Sheet sheet = workbook.getSheetAt(0);

			// Row headRow = sheet.getRow(0); // 标题行

			List<Row> dataRows = getDataRows(sheet, 1); // 从第2行读起

			if (CollectionUtils.isEmpty(dataRows)) {
				throw new CommonException("导入文件没有数据行");
			}

			list = new ArrayList<>();
			for (Row row : dataRows) {
				StockCheckImport importRow = new StockCheckImport();
				// row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				cell1.setCellType(CellType.STRING);
				// cell2.setCellType(CellType.NUMERIC);
				// if (!cell1.getCellTypeEnum().equals(CellType.STRING)) {
				// throw new
				// CommonException("产品编码须为文本格式，请不要从其它地方直接复制内容过来，请使用模板格式并用手工录入内容");
				// }
				if (!cell2.getCellTypeEnum().equals(CellType.NUMERIC)) {
					throw new CommonException("实盘数量须为整数格式，请不要从其它地方直接复制内容过来，请使用模板格式并用手工录入内容");
				}
				importRow.setProductCode(cell1.getStringCellValue().trim());
				importRow.setAmount(Integer.valueOf(String.valueOf((int) cell2.getNumericCellValue())));
				// importRow.setAmount(Integer.valueOf(cell2.getStringCellValue()));

				list.add(importRow);
			}
			// catch (Throwable t) {
			// throw new
			// CommonException("导入文件内容格式不正确，请不要从其它地方直接复制内容过来，请使用模板格式并用手工录入内容");
			// }
		} finally {
			try {
				workbook.close();
			} catch (Exception e) {
				throw new CommonException("关闭Excel工作薄出错");
			}
		}

		return list;
	}

	private static List<Row> getDataRows(Sheet sheet, int dataStartRowIndex) {
		List<Row> list = new ArrayList<>();

		int rowCount = sheet.getLastRowNum() + 1;

		for (int i = dataStartRowIndex; i < rowCount; i++) {
			list.add(sheet.getRow(i));
		}

		return list;
	}

	public static void main(String[] args) {
		try {
			String filePath = "/Users/ithost/Downloads/stock_check_template.xlsx";
			InputStream in = new FileInputStream(filePath);
			readImportData(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
