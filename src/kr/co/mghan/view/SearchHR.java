package kr.co.mghan.view;

import java.util.List;

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
	
	public void all_View(List<EmpBean> ar_eb)
	{	
		System.out.println("------조회된 사원 결과------");
		System.out.println(ar_eb.size());
		for (int i = 0; i < ar_eb.size(); i++)
		{
			System.out.println((i + 1) + "번째 사원 정보----");
			System.out.println("사원번호 : " + ar_eb.get(i).getEmpno());
			System.out.println("사원이름 : " + ar_eb.get(i).getEname());
			System.out.println("부서번호 : " + ar_eb.get(i).getDeptno());
			System.out.println();
		} // for end		
	
	}// all_View end

	// 특정사원 번호 조회를 통한 사원 정보 출력
	public void emp_View(EmpBean eb)
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
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void AllView(Object ar_ob)
	{
		// TODO Auto-generated method stub
		all_View((List<EmpBean>) ar_ob);		
	}

	@Override
	public void selView(Object ob)
	{
		// TODO Auto-generated method stub
		emp_View((EmpBean)ob);
		
	}
} // SearchHR end
