package kr.co.mghan.view;

import java.util.LinkedList;
import java.util.List;

import kr.co.mghan.domain.DeptBean;
import kr.co.mghan.domain.DeptData;

public class DeptMenu extends CommonMethod
{
	private static DeptMenu dm = new DeptMenu();

	static DeptMenu getInstance()
	{
		return dm;
	}

	public void dept_search(List<DeptBean> ar_db)
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

	public List<DeptBean> dept_add(List<DeptBean> ar_db)
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

	public List<DeptBean> dept_mod(List<DeptBean> ar_db)
	{
		int i_deptno;
		int e_deptno;
		String e_deptname;
		String e_loc;

		int isDept = 0;

		System.out.println("수정하실 부서번호를 입력하세요.");
		i_deptno = Integer.parseInt(input_msg());
		int target = 0;
		for (target = 0; target < ar_db.size(); target++)
		{
			if (ar_db.get(target).getDeptno() == i_deptno)
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

	public List<DeptBean> dept_del(List<DeptBean> ar_db)
	{		
		int i_deptno; // 입력받을 부서번호

		int isDept = 0;

		System.out.println("삭제하실 부서번호를 입력하세요.");
		i_deptno = Integer.parseInt(input_msg());
		int target = 0; // 찾을 부서번호의 인덱스
		for (target = 0; target < ar_db.size(); target++)
		{
			// 부서가 존재하면 isDept의 값을 증가하고 for문 탈출
			if (ar_db.get(target).getDeptno() == i_deptno)
			{				
				isDept++;
				break;
			}
		}
		if (isDept > 0)
		{
			List<DeptBean> ar_eb_ll = new LinkedList<DeptBean>();
			ar_eb_ll = ar_db;			
				
			ar_eb_ll.remove(target);		

			return ar_eb_ll;
		} // if 부서존재 END
		else
		{
			System.out.println("부서번호가 없습니다.");
			return ar_db;
		}

	}// dept_del END

}
