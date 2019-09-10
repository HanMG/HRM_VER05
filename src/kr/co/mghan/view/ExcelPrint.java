package kr.co.mghan.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import kr.co.mghan.domain.EmpBean;

public class ExcelPrint
{
	public void setXls(List<EmpBean> list) {
		HSSFWorkbook wb = new HSSFWorkbook(); // 워크북 생성
		HSSFSheet hs = wb.createSheet(); // 워크 시트 생성
		
		HSSFRow hr = hs.createRow(0); // 행 생성
		HSSFCell hc; // 셀 생성
		
		Date time = new Date(); 
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String now = format1.format(time);
		
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
        
        
        EmpBean eb; // 정보 가져올 객체 
        
		
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            eb = list.get(rowIdx);
            
            // 행 생성
            hr = hs.createRow(rowIdx+1);
            
            hc = hr.createCell(0); // 사원번호 컬럼에
            hc.setCellValue(eb.getEmpno()); // 사원번호 값을 가져와 전달
            
            hc = hr.createCell(1); // 사원명 컬럼에
            hc.setCellValue(eb.getEname()); // 사원명 값을 가져와 전달
            
            hc = hr.createCell(2); // 상급자 사원번호 컬럼에
            hc.setCellValue(eb.getMgr()); // 상급자 사원번호 값을 가져와 전달
            
            hc = hr.createCell(3); // 직책 컬럼에
            hc.setCellValue(eb.getJob()); // 직책 값을 가져와 전달
            
            hc = hr.createCell(4);
            hc.setCellValue(eb.getHiredate());
            
            hc = hr.createCell(5);
            hc.setCellValue(eb.getSal());
            
            hc = hr.createCell(6);
            hc.setCellValue(eb.getComm());
            
            hc = hr.createCell(7);
            hc.setCellValue(eb.getDeptno());          
            
        }
        
        // 마지막 행 다다음 행 8번째 셀에 생성된 시각을 기입
        hr = hs.createRow(list.size()+1); 
        hc = hr.createCell(8); 
        hc.setCellValue(now); 
        
        
		
		// 특정위치에 파일생성
		File file = new File("C:\\lab\\workspace for java\\HRM_VER05\\excel\\EmpSheet.xls");
		
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
