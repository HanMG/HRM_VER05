package kr.co.mghan.view;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.co.mghan.domain.DeptBean;
import kr.co.mghan.domain.DeptData;

public class DeptMenu extends CommonMethod
{
	Pattern p_number = Pattern.compile("(^[0-9]*$)"); // 숫자 패턴

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
				boolean repeat = true;
				while (repeat)
				{
					System.out.println("부서번호를 입력하세요.");
					String i_deptno = input_msg();
					Matcher m = p_number.matcher(i_deptno);
					if (m.find())
					{
						DeptBean db = null;
						db = new DeptData().getDept(Integer.parseInt(i_deptno), ar_db);
						new DeptMethod().dept_View(db);
					}
					else {
						System.out.println("부서번호만 입력해주세요.");
					}
					repeat = repeatCheck(repeat);
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
		String i_deptno; // 수정할 부서번호
		int e_deptno; // 수정될 부서번호
		String e_deptname; // 수정될 부서명
		String e_loc; // 수정될 부서위치
		boolean repeat = true; // 반복자

		int isDept = 0;
		while (repeat)
		{
			System.out.println("수정하실 부서번호를 입력하세요.");
			i_deptno = input_msg();
			Matcher m = p_number.matcher(i_deptno); // 입력받은 값을 Matcher를 통해 체크

			if (m.find())
			{
				int target = 0;
				for (target = 0; target < ar_db.size(); target++)
				{
					if (ar_db.get(target).getDeptno() == Integer.parseInt(i_deptno))
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
				}
			}
			else
			{
				System.out.println("부서번호만 입력해주세요.");
			}

			repeat = repeatCheck(repeat);
		}
		return ar_db;
	} // dept_mod END

	// 부서 삭제
	public List<DeptBean> dept_del(List<DeptBean> ar_db)
	{
		String i_deptno; // 입력받을 부서번호
		int isDept = 0; // 부서번호가 있는지
		boolean repeat = true; // 반복자

		while (repeat)
		{
			System.out.println("삭제하실 부서번호를 입력하세요.");
			i_deptno = (input_msg());

			Matcher m = p_number.matcher(i_deptno); // 입력받은 값을 Matcher를 통해 체크

			if (m.find()) // find() 패턴이 일치할 경우 true, 아닐경우 false를 반환
			{
				int target = 0; // 찾을 부서번호의 인덱스
				for (target = 0; target < ar_db.size(); target++)
				{
					// 부서가 존재하면 isDept의 값을 증가하고 for문 탈출
					if (ar_db.get(target).getDeptno() == Integer.parseInt(i_deptno))
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
				}
			}
			else
			{
				System.out.println("부서번호만 입력해주세요.");
			}

			repeat = repeatCheck(repeat);
		}
		return ar_db;
	}// dept_del END

}
