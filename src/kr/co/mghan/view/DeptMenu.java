package kr.co.mghan.view;

import kr.co.mghan.domain.DeptBean;
import kr.co.mghan.domain.DeptData;

public class DeptMenu extends CommonMethod
{
	private static DeptMenu dm = new DeptMenu();

	static DeptMenu getInstance()
	{
		return dm;
	}

	public void dept_search(DeptBean[] ar_db)
	{
		for (;;)
		{
			System.out.println("@ 수행하고자 하는 메뉴 번호를 입력하세요.");
			System.out.println("a. 전체 부서 조회");
			System.out.println("b. 특정 부서 조회");
			System.out.println("exit. 종료");
			String d_menu = input_msg();
			if (d_menu.equals("a"))
			{
				new DeptMethod().dept_All_View(ar_db);
			}
			else if (d_menu.equals("b"))
			{
				boolean code = true;
				while (code)
				{
					System.out.println("부서번호를 입력하세요.");
					String deptno = input_msg();

					DeptBean db = null;
					int i_deptno = Integer.parseInt(deptno);
					db = new DeptData().getDept(i_deptno, ar_db);
					String s_code = new DeptMethod().dept_View(db);

					// code Y 다시 검색, code N 종료
					if (s_code.equals("n"))
					{
						code = false;
					}
				}
			}
			else if (d_menu.equals("exit"))
			{
				break;
			}
		}

	}

	public DeptBean[] dept_add(DeptBean[] ar_db)
	{
		int a_deptno;
		String a_deptname;
		String a_loc;
		System.out.println("추가할 부서번호를 입력하세요.");
		a_deptno = Integer.parseInt(input_msg());
		System.out.println("추가할 부서명를 입력하세요.");
		a_deptname = input_msg();
		System.out.println("추가할 부서의 위치를 입력하세요.");
		a_loc = input_msg();
		DeptMethod DM = new DeptMethod();

		ar_db = DM.ins_dept(a_deptno, a_deptname, a_loc, ar_db);

		return ar_db;

	}

	public DeptBean[] dept_mod(DeptBean[] ar_db)
	{
		int i_deptno;
		int e_deptno;
		String e_deptname;
		String e_loc;

		int isDept = 0;

		System.out.println("수정하실 부서번호를 입력하세요.");
		i_deptno = Integer.parseInt(input_msg());
		int target = 0;
		for (target = 0; target < ar_db.length; target++)
		{
			if (ar_db[target].getDeptno() == i_deptno)
			{
				isDept++;
				break;
			}
		}

		if (isDept > 0)
		{
			System.out.println("부서번호 수정");
			e_deptno = Integer.parseInt(input_msg());
			System.out.println("부서명 수정");
			e_deptname = input_msg();
			System.out.println("부서위치 수정");
			e_loc = input_msg();
			DeptMethod DM = new DeptMethod();
			ar_db = DM.mod_dept(e_deptno, e_deptname, e_loc, ar_db, target);

			return ar_db;
		}
		else
		{
			System.out.println("부서가 없습니다.");
			return ar_db;
		}

	}

	public DeptBean[] dept_del(DeptBean[] ar_db)
	{
		DeptBean[] old_ar_db = ar_db; // 현재 배열
		int i_deptno; // 입력받을 부서번호

		int isDept = 0;

		System.out.println("삭제하실 부서번호를 입력하세요.");
		i_deptno = Integer.parseInt(input_msg());
		int target = 0; // 찾을 부서번호의 인덱스
		for (target = 0; target < ar_db.length; target++)
		{
			// 부서가 존재하면 isDept의 값을 증가하고 for문 탈출
			if (ar_db[target].getDeptno() == i_deptno)
			{
				ar_db[target] = null;
				isDept++;
				break;
			}
		}
		if (isDept > 0)
		{
			// 정렬로 NULL로 된 객체를 배열 제일 마지막으로 이동시킴
			boolean cnt = true;
			while (cnt)
			{
				for (int j = 0; j < old_ar_db.length; j++)
				{
					DeptBean tmp = new DeptBean();
					if (old_ar_db[j] == null)
					{
						if (j != (old_ar_db.length - 1))
						{
							tmp = old_ar_db[j];
							old_ar_db[j] = old_ar_db[j + 1];
							old_ar_db[j + 1] = tmp;
						}
						if(j == old_ar_db.length - 1) {
							cnt = false;
						}
					}
				}

			}

			// 새로운 객체배열 생성, 현재 배열보다 한칸 작게
			DeptBean[] new_ar_db = new DeptBean[old_ar_db.length - 1];

			// 새로운 객체배열에 현재배열의 값을 입력
			for (int j = 0; j < new_ar_db.length; j++)
			{
				DeptBean db = new DeptBean();
				db.setDeptno(old_ar_db[j].getDeptno());
				db.setDeptname(old_ar_db[j].getDeptname());
				db.setLoc(old_ar_db[j].getLoc());
				new_ar_db[j] = db;
			}

			return new_ar_db;
		} // if 부서존재 END
		else
		{
			System.out.println("부서번호가 없습니다.");
			return ar_db;
		}

	}// dept_del END

}
