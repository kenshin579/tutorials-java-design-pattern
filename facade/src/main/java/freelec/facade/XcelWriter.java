package freelec.facade;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;


/**
 * <pre>
 *
 * 엑셀 파일을 write할 수 있는 api를 제공
 *
 * use case
 * 		XcelWriter excel = new XcelWriter();
 * 		excel.setHSSFWorkBook();
 * 		excel.createSheet("test");
 * 		excel.createRow(0);
 * 		excel.createRow(1);
 * 		excel.createRow(2);
 * 		excel.createCells(excel.getRow(0), 6);
 * 		excel.createCells(excel.getRow(1), 6);
 * 		excel.createCells(excel.getRow(2), 6);
 * 		excel.mergeCell(0,0,1,0);
 * 		excel.mergeCell(0,2,1,2);
 * 		excel.mergeCell(0,4,1,4);
 * 		excel.mergeCell(2,0,2,1);
 * 		excel.mergeCell(2,2,2,3);
 * 		excel.mergeCell(2,4,2,5);
 * 		excel.setCellValue(excel.getRow(0), 0, "00,10");
 * 		excel.setCellValue(excel.getRow(0), 1, "01");
 * 		excel.setCellValue(excel.getRow(1), 1, "11");
 * 		excel.setCellValue(excel.getRow(0), 2, "02,12");
 * 		excel.setCellValue(excel.getRow(0), 3, "03");
 * 		excel.setCellValue(excel.getRow(1), 3, "13");
 * 		excel.setCellValue(excel.getRow(0), 4, "04,14");
 * 		excel.setCellValue(excel.getRow(0), 5, "05");
 * 		excel.setCellValue(excel.getRow(1), 5, 1.0);
 * 		excel.setCellValue(excel.getRow(2), 0, true);
 * 		excel.setCellValue(excel.getRow(2), 2, new java.util.Date());
 * 		excel.setCellValue(excel.getRow(2), 4, 10);
 * 		excel.setCellValue(3, 4, 10);
 * 		excel.writeXLS("c:/","dulee.xls");
 *
 *  </pre>
 *
 * @author umlkorea 김창호
 */
public class XcelWriter {

    /**
     * excel row의 배열
     */
    private HSSFRow rowset[];

    /**
     * respose.xml reader
     */
    //private PresidioMeta entity;

    /**
     * sheet의 갯수
     */
    private int pages;

    /**
     * 생성될 excel 문서의 header row 의 갯수
     */
    private int headerRow = 1;

    /**
     * sheet안의 row 객수
     */
    private int unit;

    /**
     * 기본 작업 장(workbook)
     */
    private static HSSFWorkbook wb;

    /**
     * 작업 sheet
     */
    private HSSFSheet sheet;

    /**
     * 최대 5만 row단위로 sheet를 분리한다. 즉 sheet가 두 장 이상일 경우
     */
    private HSSFSheet sheets[];

    /**
     * cell style
     */
    private HSSFCellStyle cellStyle;

    /**
     * 엑셀 파일의 헤더 rows
     */

    private HSSFRow hRows[];

    /**
     * 엑셀 파일의 헤더 columns
     */
    private HSSFCell hCells[];

    /**
     * 로우 집합체
     * rows collection
     */
    private Vector rows = new Vector();


    /**
     * cell 집합체
     */
    private Hashtable cells = new Hashtable();

    /**
     * 엑셀 작업장을 생성
     *
     * @param
     * @return HSSFWorkbook
     * @throws
     * @see getHSSFWorkBook()
     */

    public HSSFWorkbook getHSSFWorkBook() {
        return new HSSFWorkbook();
    }

    public HSSFWorkbook createHSSFWorkBook() {
        return new HSSFWorkbook();
    }

    /**
     * 엑셀 작업장을 생성하고, 설정
     *
     * @param
     * @return
     * @throws
     * @see getHSSFWorkBook()
     */

    public void setHSSFWorkBook() {
        wb = new HSSFWorkbook();
    }

    /**
     * 엑셀 시트 생성
     *
     * @param wb : 작업장
     * @return HSSFWorkbook
     * @throws
     * @ param name : 시트 이름
     * @see createSheet(HSSFWorkbook, String )
     */
    public HSSFSheet createSheet(HSSFWorkbook wb, String name) {
        return wb.createSheet(name);
    }

    /**
     * 엑셀 시트 생성하고 설정
     *
     * @param name : 시트 이름
     * @return HSSFSheet
     * @throws
     * @see createSheet(HSSFWorkbook, String)
     */

    public HSSFSheet createSheet(String name) {
        sheet = wb.createSheet(name);
        return sheet;
    }

    /**
     * 주어진 사이즈, 즉 row를 포함할 수 있는 sheet를 생성한다
     *
     * @param size
     * @return
     */
    public HSSFSheet[] createSheets(int size) {//,String name){

        int index = 0;

        int value = size / (65536);
        int mod = size % (65536);

        if (mod != 0) {
            index = value + 1;
            createSheets(value + 1);
        } else {
            index = value;
            createSheets(value);
        }

        HSSFSheet sheets[] = new HSSFSheet[index];
        for (int i = 0; i < sheets.length; i++) {
            sheets[i] = createSheet(+i + " th");
        }
        this.sheets = sheets;
        return sheets;
    }

    private HSSFRow rowarr[] = null;
    private HSSFCell cellarr[][] = null;

    public void create(int rowCount, String columnName[]) {

        int columnSize = columnName.length;
        int rowLimit = 65536; // -1 for column name

        int rowIndex = -1;

        HSSFSheet sheets[] = createSheets(rowCount);

        HSSFRow row = null;
        HSSFCell cell = null;

        int value = 0;
        int mod = 0;

        HSSFRow rows[][] = new HSSFRow[sheets.length][rowCount + 1];

        if (sheets.length > 2) {
            value = rowCount / (rowLimit - 1);
            mod = rowCount % (rowLimit - 1);
            if (mod != 0) {
                for (int i = 0; i < sheets.length - 1; i++) {
                    rows[i] = new HSSFRow[rowLimit];
                }
                rows[sheets.length - 1] = new HSSFRow[mod + 1];
            }
        }

        for (int i = 0; i < sheets.length; i++) {
            row = createRow(sheets[i], 0);
            for (int j = 0; j < columnSize; j++) {
                cell = createCell(row, j);
                cell.setCellValue(columnName[j]);
            }
        }


    }


    /**
     * Row 생성
     *
     * @return HSSFSheet
     * @throws
     * @ param sheet : 작업 대상이 되는 시트
     * @ param rownum row의 인덱스
     * @see createRow(HSSFSheet , int )
     */

    public HSSFRow createRow(HSSFSheet sheet, int rownum) {
        HSSFRow row = sheet.createRow((short) rownum);
        rows.addElement(row);
        return row;
    }

    /**
     * Row 생성, 설정
     *
     * @return HSSFSheet
     * @throws
     * @ param rownum row의 인덱스
     * @see createRow(int )
     */
    public HSSFRow createRow(int rownum) {
        HSSFRow row = sheet.createRow((short) rownum);
        rows.addElement(row);
        return row;
    }

    /**
     * 주어진 index에 해당하는 row를 반환
     *
     * @param i
     * @return
     */
    public HSSFRow getRow(int i) {
        HSSFRow row = (HSSFRow) rows.elementAt(i);
        return row;
    }

    /**
     * Cell 생성
     *
     * @return HSSFCell
     * @throws
     * @ param  row : 작업 대상이 되는 Row
     * @ param s : 생성할 Cell의 인덱스
     * @see createCell(HSSFRow, int s)
     */

    public HSSFCell createCell(HSSFRow row, int s) {
        return row.createCell((short) s);
    }


    /**
     * 해당 row에 포함되는 cell의 갯수를 생성
     *
     * @param row
     * @param size
     */
    public void createCells(HSSFRow row, int size) {
        HSSFCell arr[] = new HSSFCell[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = createCell(row, i);
        }
        cells.put(row, arr);
    }

    /**
     * 엑셀 파일 헤더를 만들기 위한 셀 공간 확보, 헤더에서의 셸 병합은 현 단계에서는
     * 고려하지 않는다, 우선 공간을 확보한 후 병합 메소드를 호출하여 병합 할 수 있도록 한다
     *
     * @param row    헤더의 row 갯수
     * @param column 헤더의 column 갯수
     */
    public void initHeaderCell(HSSFSheet sheet, int row, int column) {
        HSSFRow rows[] = new HSSFRow[row];
        for (int i = 0; i < row; i++) {
            rows[i] = createRow(sheet, i);
        }
        HSSFCell cells[] = new HSSFCell[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cells[j] = createCell(rows[i], j);
            }
        }
        this.hRows = rows;
        this.hCells = cells;
    }


    /**
     * 주어진 reponse.xml 의 전체 row의 갯수와 sheet안의 포함될 수 있는
     * 최대 row 갯수를 비교하여 생성되어야 할 sheet 갯수를 결정
     *
     * @param size row의 갯수
     * @return 생성될 sheet 갯수
     */
    private int getPages(int size) {
        int count = size / unit;
        if (size % unit > 0) {
            ++count;
        }
        return count;
    }

	/*
     * response.xml의 data를 excel 문서에 적당히 바인딩한다
	 * @param contents response.xml로 부터 읽어온 data
	 
	public void setValue(String contents[][]){
		
		try{
		int row = entity.getRowSize();
		int column = entity.getColumnSize();
		int page = getPages(row);
		HSSFSheet []sheets = createSheets(page);
		HSSFRow rowSet[][] = new HSSFRow[sheets.length][unit+headerRow];
		for( int i = 0 ; i < sheets.length ; i++){
			for(int j = 0 ; j < unit + headerRow ; j++){
				HSSFRow _row = createRow(sheets[i], j);
				rowSet[i][j] = _row;
			}
		}
		String columns[] = entity.getColumns();
		for( int i = 0 ; i < sheets.length ; i++){
			int cIndex = 0;
			for( int j = 0 ; j < headerRow ; j++){
				HSSFRow _row = rowSet[i][j];
				for( int k = 0 ; k < column ; k++){
					HSSFCell cell = createCell( _row , k );
					setEncoding(cell);
					//System.out.println("column : " + columns[cIndex++] );
					setCellValue( cell, columns[cIndex++]);
				}
			}
			
			for( int j = headerRow ; j < (unit + headerRow) && j < (row + headerRow) ; j++){
				HSSFRow _row = rowSet[i][j];
				for( int k = 0 ; k < column ; k++){
					HSSFCell cell = createCell( _row , k );
					setEncoding(cell);
					String value = contents[i*unit + j-headerRow][k];
					setCellValue(cell, value);
				}
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}*/


    /**
     * CellStyle 생성,참조
     *
     * @return
     * @throws
     * @ param
     * @see getCellStyle(HSSFSheet , int )
     */

    public HSSFCellStyle getCellStyle() {
        return wb.createCellStyle();
    }

    /**
     * CellStyle 생성, 참조
     *
     * @return HSSFCellStyle
     * @throws
     * @ param  wb : CellStyle을 참조하기 위한 작업장
     * @see getCellStyle(HSSFWorkbook)
     */

    public HSSFCellStyle getCellStyle(HSSFWorkbook wb) {
        return wb.createCellStyle();
    }

    /**
     * CellStyle 설정
     *
     * @return
     * @throws
     * @ param  cell : CellStyle을 설정할 Cell
     * @ param style : 설정한 cellstyle
     * @see setCellStyle(HSSFCell, HSSFCellStyle )
     */

    public void setCellStyle(HSSFCell cell, HSSFCellStyle style) {
        cell.setCellStyle(style);
    }

    /**
     * 한글 인코딩 지원, 유니코드로 설정
     *
     * @return
     * @throws
     * @ param cell : 유니코드로 설정할 Cell
     * @see setEncoding(HSSFCell)
     */

    public void setEncoding(HSSFCell cell) {
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
    }

    /**
     * 주어진 row에 해당 cell 인덱스에 값을 할당
     *
     * @param row
     * @param index
     * @param value
     */
    public void setCellValue(HSSFRow row, int index, int value) {
        HSSFCell arr[] = (HSSFCell[]) cells.get(row);
        setCellValue(arr[index], value);
    }

    public void setCellValue(int row, int column, int value) {
        setCellValue(this.getRow(row), column, value);
    }


    /**
     * 주어진 row에 해당 cell 인덱스에 값을 할당
     *
     * @param row
     * @param index
     * @param value
     */
    public void setCellValue(HSSFRow row, int index, double value) {
        HSSFCell arr[] = (HSSFCell[]) cells.get(row);
        setCellValue(arr[index], value);
    }

    public void setCellValue(int row, int column, double value) {
        setCellValue(getRow(row), column, value);
    }

    /**
     * 주어진 row에 해당 cell 인덱스에 값을 할당
     *
     * @param row
     * @param index
     * @param value
     */
    public void setCellValue(HSSFRow row, int index, boolean value) {
        HSSFCell arr[] = (HSSFCell[]) cells.get(row);
        setCellValue(arr[index], value);
    }


    public void setCellValue(int row, int column, boolean value) {
        setCellValue(getRow(row), column, value);
    }


    /**
     * 주어진 row에 해당 cell 인덱스에 값을 할당
     *
     * @param row
     * @param index
     * @param value
     */
    public void setCellValue(HSSFRow row, int index, String value) {
        HSSFCell arr[] = (HSSFCell[]) cells.get(row);
        setCellValue(arr[index], value);
    }

    public void setCellValue(int row, int column, String value) {
        setCellValue(getRow(row), column, value);
    }

    /**
     * 주어진 row에 해당 cell 인덱스에 값을 할당
     *
     * @param row
     * @param index
     * @param value
     */
    public void setCellValue(HSSFRow row, int index, java.util.Date value) {
        HSSFCell arr[] = (HSSFCell[]) cells.get(row);
        setCellValue(arr[index], value);
    }

    public void setCellVvalue(int row, int column, java.util.Date value) {
        setCellValue(getRow(row), column, value);
    }


    /**
     * 셀에 값을 설정
     *
     * @return
     * @throws
     * @ param cell : 값을 설정할 Cell
     * @ param value : 설정할 값
     * @see setCellValue(HSSFCell, int )
     */

    public void setCellValue(HSSFCell cell, int value) {
        cell.setCellValue(value);
    }

    /**
     * 셀에 값을 설정
     *
     * @return
     * @throws
     * @ param cell : 값을 설정할 Cell
     * @ param value : 설정할 값
     * @see setCellValue(HSSFCell, String )
     */


    public void setCellValue(HSSFCell cell, String value) {
        setEncoding(cell);
        cell.setCellValue(value);
    }

    /**
     * 셀에 값을 설정
     *
     * @return
     * @throws
     * @ param cell : 값을 설정할 Cell
     * @ param value : 설정할 값
     * @see setCellValue(HSSFCell, java.util.Date )
     */


    public void setCellValue(HSSFCell cell, java.util.Date value) {
        cell.setCellValue(value);
    }

    /**
     * 셀에 값을 설정
     *
     * @return
     * @throws
     * @ param cell : 값을 설정할 Cell
     * @ param value : 설정할 값
     * @see setCellValue(HSSFCell, boolean )
     */


    public void setCellValue(HSSFCell cell, boolean value) {
        cell.setCellValue(value);
    }

    /**
     * 셀에 값을 설정
     *
     * @return
     * @throws
     * @ param cell : 값을 설정할 Cell
     * @ param value : 설정할 값
     * @see setCellValue(HSSFCell, double )
     */


    public void setCellValue(HSSFCell cell, double value) {
        cell.setCellValue(value);
    }


    /**
     * 셀 병합
     *
     * @return
     * @throws
     * @ param rowFrom : 병합할 셀의 좌상단 Row 좌표
     * @ param colFrom : 병합할 셀의 좌상단 Column 좌표
     * @ param rowTo : 병합할 셀의 우하단 Row 좌표
     * @ param colTo : 병합할 셀의 우하단 Column 좌표
     * @see mergeCell(int, int , int, int )
     */

    public void mergeCell(int rowFrom, int colFrom, int rowTo, int colTo) {
        mergeCell(getMergedRegion(rowFrom, (short) colFrom, rowTo, (short) colTo));
    }

    /**
     * 셀 병합
     *
     * @return
     * @throws
     * @ param sheet :sheet 병합할 cell을 포함하고 있는 sheet
     * @ param rowFrom : 병합할 셀의 좌상단 Row 좌표
     * @ param colFrom : 병합할 셀의 좌상단 Column 좌표
     * @ param rowTo : 병합할 셀의 우하단 Row 좌표
     * @ param colTo : 병합할 셀의 우하단 Column 좌표
     * @see mergeCell(HSSFSheet ,int, int , int, int )
     */

    public void mergeCell(HSSFSheet sheet, int rowFrom, int colFrom, int rowTo, int colTo) {
        mergeCell(sheet, getMergedRegion(rowFrom, colFrom, rowTo, colTo));
    }

    /**
     * 셀 병합
     *
     * @return
     * @throws
     * @ param  region : 병합할 지역
     * @see mergeCell(Region)
     */

    public void mergeCell(Region region) {
        sheet.addMergedRegion(region);
    }

    /**
     * 셀 병합
     *
     * @return
     * @throws
     * @ param sheet : 병합할 cell을 포함하고 있는 cell
     * @ param region : 병합할 구역
     * @see mergeCell(HSSFSheet , Region region)
     */

    public void mergeCell(HSSFSheet sheet, Region region) {
        sheet.addMergedRegion(region);
    }

    /**
     * 병합할 Cell의 구역을 생성
     *
     * @return Region
     * @throws
     * @ param rowFrom : 병합할 셀의 좌상단 Row 좌표
     * @ param colFrom : 병합할 셀의 좌상단 Column 좌표
     * @ param rowTo : 병합할 셀의 우하단 Row 좌표
     * @ param colTo : 병합할 셀의 우하단 Column 좌표
     * @see getMergedRegion(int rowFrom, short colFrom, int rowTo, short colTo)
     */

    public Region getMergedRegion(int rowFrom, int colFrom, int rowTo, int colTo) {
        return new Region(rowFrom, (short) colFrom, rowTo, (short) colTo);
    }

    /**
     * 바닥글 설정
     *
     * @return
     * @throws
     * @ param
     * @see setFooter()
     */
    public void setFooter() {
        HSSFFooter footer = sheet.getFooter();
        footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());
    }//*/

    /**
     * 바닥글 설정
     *
     * @return
     * @throws
     * @ param sheet : 바닥글을 설정할 SHEET
     * @see setFooter(HSSFSheet)
     */
    public void setFooter(HSSFSheet sheet) {
        HSSFFooter footer = sheet.getFooter();
        footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());
    }//*/


    /**
     * 엑셜 파일 저장
     *
     * @return
     * @throws IOException
     * @ param wb: 작업장
     * @ param path: 엑셀 파일 저장 경로
     * @ param name: 저장될 파일 이름
     * @see writeXLS(HSSFWorkbook ,String , String)
     */

    public void writeXLS(HSSFWorkbook wb, String path, String name) throws IOException {
        FileOutputStream fout = getFileTarget(path, name);
        wb.write(fout);
        fout.close();//*/
    }

    /**
     * 주어진 경로에 엑셀로 파일 저장
     *
     * @return
     * @throws IOException
     * @ param path: 엑셀 파일 저장 경로
     * @ param name: 저장될 파일 이름
     * @see writeXLS(String , String)
     */
    public void writeXLS(String path, String name) throws IOException {
        FileOutputStream fout = getFileTarget(path, name);
        wb.write(fout);
        fout.close();//*/
    }


    /**
     * 주어진 경로에 주어진 파일 이름으로 파일을 생성할 수 있는 FileOutputStream을
     * 생성하는 메소드, 만약 주어진 경로에 주어진 파일 이름을 가진 파일이 존재할 경우
     * replace 되어 진다.
     *
     * @param path 파일 경로
     * @param name 파일 이름
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private FileOutputStream getFileTarget(String path, String name) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(getFile(path, name));
        return fout;
    }

    /**
     * 주어진 경로와 이름을 갖는 File instance를 반환
     *
     * @param path 파일 경로
     * @param name 파일 이름
     * @return 주어진 경로와 이름을 갖는 File instance
     * @throws IOException
     */
    private File getFile(String path, String name) throws IOException {
        return new File(path + File.separator + name);
    }


    public static void main(String args[]) throws java.io.IOException {

        // 타개발자에게 기본적인 제공할 Prototype
        try {
            XcelWriter excel = new XcelWriter();

            excel.setHSSFWorkBook();
            excel.createSheet("test");
            excel.createRow(0);
            excel.createRow(1);
            excel.createRow(2);

            excel.createCells(excel.getRow(0), 6);
            excel.createCells(excel.getRow(1), 6);
            excel.createCells(excel.getRow(2), 6);

            excel.createCells(excel.createRow(3), 6);

            excel.mergeCell(0, 0, 1, 0);
            excel.mergeCell(0, 2, 1, 2);
            excel.mergeCell(0, 4, 1, 4);

            excel.mergeCell(2, 0, 2, 1);
            excel.mergeCell(2, 2, 2, 3);
            excel.mergeCell(2, 4, 2, 5);

            excel.setCellValue(excel.getRow(0), 0, "00,10");
            excel.setCellValue(excel.getRow(0), 1, "01");
            excel.setCellValue(excel.getRow(1), 1, "11");


            excel.setCellValue(excel.getRow(0), 2, "02,12");
            excel.setCellValue(excel.getRow(0), 3, "03");
            excel.setCellValue(excel.getRow(1), 3, "13");

            excel.setCellValue(excel.getRow(0), 4, "04,14");
            excel.setCellValue(excel.getRow(0), 5, "05");
            excel.setCellValue(excel.getRow(1), 5, 1.0);

            excel.setCellValue(excel.getRow(2), 0, true);
            excel.setCellValue(excel.getRow(2), 2, new java.util.Date());
            excel.setCellValue(excel.getRow(2), 4, 10);

            excel.setCellValue(3, 0, "temp");
            excel.setCellValue(3, 1, "djflkdjlk");

            excel.writeXLS("/Users/ykoh/Desktop/", "dulee.xls");
            System.out.println("Write completed");

        } catch (Exception e) {
            e.printStackTrace();
        }//*/

    }


}