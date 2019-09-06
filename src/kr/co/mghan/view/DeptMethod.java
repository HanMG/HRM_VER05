package kr.co.mghan.view;

import kr.co.mghan.domain.DeptBean;

// 부서메뉴 관련 함수 모음 
public class DeptMethod extends CommonMethod
{
	

	// 모든 부서 보기
	public void dept_All_View(DeptBean[] ar_db)
	{
		System.out.println("------조회된 부서 결과------");
		for (int i = 0; i < ar_db.length; i++)
		{
			System.out.println((i + 1) + "번째 부서 정보----");
			System.out.println("부서번호 : " + ar_db[i].getDeptno());
			System.out.println("부서명 : " + ar_db[i].getDeptname());
			System.out.println("부서위치 : " + ar_db[i].getLoc());
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

	public DeptBean[] ins_dept(int deptno, String deptname, String loc, DeptBean[] ar_db)
	{
		// 기존 사원 정보에서 매개변수에 입력된 정보 추가
		DeptBean[] old_ar_db = ar_db;
		// 추가된 공간 확보
		// 기존 공간수 + 1
		// 기존 공간수 확인
		DeptBean[] new_ar_db = new DeptBean[old_ar_db.length + 1];
		for (int i = 0; i < old_ar_db.length; i++)
		{
			DeptBean eb = new DeptBean();
			eb.setDeptno(old_ar_db[i].getDeptno());
			eb.setDeptname(old_ar_db[i].getDeptname());
			eb.setLoc(old_ar_db[i].getLoc());

			new_ar_db[i] = eb;
		}
		// 추가된 값을 마지막 배열에 추가시킴
		DeptBean n_db = new DeptBean();

		n_db.setDeptno(deptno);
		n_db.setDeptname(deptname);
		n_db.setLoc(loc);

		new_ar_db[new_ar_db.length - 1] = n_db;

		return new_ar_db;
	}

	public DeptBean[] mod_dept(int e_deptno, String e_deptname, String e_loc, DeptBean[] ar_db,
			int target)
	{
		// 수정 진행
		ar_db[target].setDeptno(e_deptno);
		ar_db[target].setDeptname(e_deptname);
		ar_db[target].setLoc(e_loc);

		return ar_db;
	}

}
