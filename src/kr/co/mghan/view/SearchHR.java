package kr.co.mghan.view;

import kr.co.mghan.domain.EmpBean;


public class SearchHR extends Search
{
	// 사원 조회를 위한 View 객체
	// 사원의 정보를 가져다가 구성함.
	
	// 싱글톤
	private static SearchHR shr = new SearchHR();
	
	static SearchHR getInstance() {
		
		return shr;
	}
	
	public void all_View(EmpBean[] ar_eb)
	{	
		System.out.println("------조회된 사원 결과------");
		for (int i = 0; i < ar_eb.length; i++)
		{
			System.out.println((i + 1) + "번째 사원 정보----");
			System.out.println("사원번호 : " + ar_eb[i].getEmpno());
			System.out.println("사원이름 : " + ar_eb[i].getEname());
			System.out.println("부서번호 : " + ar_eb[i].getDeptno());
			System.out.println();
		} // for end		
	
	}// all_View end

	// 특정사원 번호 조회를 통한 사원 정보 출력
	public String emp_View(EmpBean eb)
	{
		if (eb == null)
		{
			System.out.println("조회된 값이 없습니다.");
			
		}
		else
		{
			System.out.println("사원 정보는 다음과 같습니다.");
			System.out.println("사원번호 : " + eb.getEmpno());
			System.out.println("이름 : " + eb.getEname());
			System.out.println("부서 : " + eb.getDeptno());
			System.out.println();
		}
		
		System.out.println("계속 검색 하시겠습니까? (y,n)");
		String code =  input_msg(); // Y 다시 검색하는 메뉴 실행, N 종료
		
		return code;
	}

	@Override
	public void AllView(Object[] ar_ob)
	{
		// TODO Auto-generated method stub
		all_View((EmpBean[])ar_ob);
		
	}

	@Override
	public String selView(Object ob)
	{
		// TODO Auto-generated method stub
		return emp_View((EmpBean)ob);
		
	}
} // SearchHR end
