package kr.co.mghan.view;

import java.util.List;

import kr.co.mghan.domain.DeptBean;

// 부서메뉴 관련 함수 모음 
public class DeptMethod extends CommonMethod
{
	

	// 모든 부서 보기
	public void dept_All_View(List<DeptBean> ar_db)
	{
		System.out.println("------조회된 부서 결과------");
		for (int i = 0; i < ar_db.size(); i++)
		{
			System.out.println((i + 1) + "번째 부서 정보----");
			System.out.println("부서번호 : " + ar_db.get(i).getDeptno());
			System.out.println("부서명 : " + ar_db.get(i).getDeptname());
			System.out.println("부서위치 : " + ar_db.get(i).getLoc());
			System.out.println();
		} // for end

	}// dept_all_View end

	// 특정부서 보기
	public String dept_View(DeptBean db)
	{
		// 부서가 있는지 체크
		if (db == null)
		{
			System.out.println("조회된 값이 없습니다.");
		}
		else
		{
			System.out.println("부서 정보는 다음과 같습니다.");
			System.out.println("부서번호 : " + db.getDeptno());
			System.out.println("부서명 : " + db.getDeptname());
			System.out.println("위치 : " + db.getLoc());
			System.out.println();
		}

		System.out.println("계속 검색 하시겠습니까? (y,n)");
		String code = input_msg(); // Y 다시 검색하는 메뉴 실행, N 종료

		return code;
	}

	public List<DeptBean> ins_dept(int deptno, String deptname, String loc, List<DeptBean> ar_db)
	{
		// 기존 사원 정보에서 매개변수에 입력된 정보 추가
		DeptBean n_db = new DeptBean();
		// 추가된 공간 확보
		// 기존 공간수 + 1
		// 기존 공간수 확인		

		n_db.setDeptno(deptno);
		n_db.setDeptname(deptname);
		n_db.setLoc(loc);
		ar_db.add(n_db); 
		

		return ar_db;
	}

	public List<DeptBean> mod_dept(int e_deptno, String e_deptname, String e_loc, List<DeptBean> ar_db,
			int target)
	{
		// 수정 진행
		ar_db.get(target).setDeptno(e_deptno);
		ar_db.get(target).setDeptname(e_deptname);
		ar_db.get(target).setLoc(e_loc);

		return ar_db;
	}

}
