package kr.co.mghan.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import kr.co.mghan.domain.EmpBean;

public class ExcelPrint
{
	public void setXls(List<EmpBean> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet hs = wb.createSheet();
		
		HSSFRow hr = hs.createRow(0);
		HSSFCell hc;
		
		// 헤더 정보 구성

        hc = hr.createCell(0);
        hc.setCellValue("사원번호");        
        hc = hr.createCell(1);
        hc.setCellValue("사원명");        
        hc = hr.createCell(2);
        hc.setCellValue("상급자 사원번호");        
        hc = hr.createCell(3);
        hc.setCellValue("직책");        
        hc = hr.createCell(4);
        hc.setCellValue("고용일자");
        hc = hr.createCell(5);
        hc.setCellValue("월급");
        hc = hr.createCell(6);
        hc.setCellValue("보너스");
        hc = hr.createCell(7);
        hc.setCellValue("부서번호");
        
        EmpBean eb;
		
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            eb = list.get(rowIdx);
            
            // 행 생성
            hr = hs.createRow(rowIdx+1);
            
            hc = hr.createCell(0);
            hc.setCellValue(eb.getEmpno());
            
            hc = hr.createCell(1);
            hc.setCellValue(eb.getEname());
            
            hc = hr.createCell(2);
            hc.setCellValue(eb.getMgr());
            
            hc = hr.createCell(3);
            hc.setCellValue(eb.getJob());
            
            hc = hr.createCell(4);
            hc.setCellValue(eb.getHiredate());
            
            hc = hr.createCell(5);
            hc.setCellValue(eb.getSal());
            
            hc = hr.createCell(6);
            hc.setCellValue(eb.getComm());
            
            hc = hr.createCell(7);
            hc.setCellValue(eb.getDeptno());
            
        }
		
		
		File file = new File("c:/Test/TestExcel2.xls");
		
		if(file.exists()) {
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			wb.write(fos);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try
			{
				wb.close();
				fos.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
				
	}
}
