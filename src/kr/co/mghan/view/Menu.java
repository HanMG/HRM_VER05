package kr.co.mghan.view;

import kr.co.mghan.domain.EmpBean;
import kr.co.mghan.domain.EmpData;
import kr.co.mghan.ex.CodeValueNotFoundException;
import kr.co.mghan.ex.RunException;

import java.util.List;

import kr.co.mghan.domain.DeptBean;
import kr.co.mghan.domain.DeptData;

//KITRI Human Resource Management System에 오신것을 환영합니다.
//다음 수행하고자 하는 메뉴 번호를 누르세요.
//	1. 사원정보조회
//	2. 사원추가
//	3. 사원수정
//	4. 사원삭제
//	5. 부서정보조회
//	6. 종료

public class Menu extends CommonMethod
{
	List<EmpBean> ar_eb = null;
	List<DeptBean> ar_db = null;

	public void main_menu(int auth) throws CodeValueNotFoundException
	{
		// Data값 초기화
		ar_eb = new EmpData().def_data();
		ar_db = new DeptData().def_data();

		// 메뉴 반복 코드 값 추가
		boolean repeat = true;

		while (repeat)
		{
			System.out.println("-- KITRI Human Resource Management System에 오신것을 환영합니다.");
			System.out.println("-- 다음 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("- 1. 사원정보조회");
			if (auth != 3)
			{
				System.out.println("- 2. 사원추가");
				System.out.println("- 3. 사원수정");
			}
			if (auth < 3)
			{
				System.out.println("- 4. 사원삭제");
			}
			if (auth < 2)
			{
				System.out.println("- 5. 부서정보조회");
			}
			System.out.println("- 6. 종료");
			System.out.print("값을 입력하세요. => ");
			// 입력값 받을 수 있는 기능 수행
			String menu = super.input_msg();
			System.out.println("입력하신 값은 " + menu + " 입니다.");
			if (menu.equals("6"))
			{ // OR Integer.parseInt
				System.out.println("------------종료-----------");
				repeat = false;
			} // if 6 종료 end

			// 1번 메뉴 발생 시킬 수 있도록 구성하기
			else if (menu.equals("1"))
			{
				// 1번 세부 메뉴 실행 시킬 수 있도록 구성하기
				first_menu();
			} // else if first end

			else if (menu.equals("2") && auth != 4)
			{
				// 2번 메뉴 (사원 추가 실행시킬 수 있도록 구성하기)
				second_menu();
			} // else if second end
			else if (menu.equals("3") && auth != 4)
			{
				third_menu();
			}
			else if (menu.equals("4") && auth < 3)
			{
				// 4번 메뉴 ( 사원 삭제)
				fourth_menu();
			}
			else if (menu.equals("5") && auth < 2)
			{
				fifth_menu(auth);
			}
			else
			{
				try
				{
					new RunException().runException();
				} catch (CodeValueNotFoundException cvnf)
				{
					System.out.println("입력 값이 잘 못 되었습니다.");
				}
			}
		} // while end
	}// main end

	// 1번 메뉴 메소드 생성
	public void first_menu()
	{		

		for(;;)
		{
			System.out.println("------------------------------");
			System.out.println("----------사원정보조회 메뉴---------");
			System.out.println("------------------------------");
			System.out.println("@ 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("a. 사원정보조회");
			System.out.println("b. 특정사원조회");
			System.out.println("c. 사원정보엑셀로 추출");
			System.out.println("exit. 종료");
			System.out.print("값을 입력하세요. => ");
			// 입력값 받을 수 있는 기능 수행
			String menu = input_msg();

			if (menu.equals("exit")) // 사원조회 나가기
			{
				System.out.println("------------1번 메뉴 종료-----------");
				break;
			} // if exit end , exit시 종료
			else if (menu.equals("a"))
			{ // 전체사원조회
				// SearchHR shr = new SearchHR();
				SearchHR shr = SearchHR.getInstance();
				shr.AllView(ar_eb);
			} // else if 'a' END
			else if (menu.equals("b"))
			{ // 특정인물 조회
				boolean repeat = true;
				while (repeat)
				{
					System.out.println("사원번호를 입력하세요.");
					String empno = input_msg();

					EmpBean eb = null;
					int i_empno = Integer.parseInt(empno);
					eb = (EmpBean) new EmpData().getEmp(i_empno, ar_eb);
					SearchHR.getInstance().selView(eb);
					
					repeat = repeatCheck(repeat);
					
				} // while 특정사원찾기 END

			} // else if 'b' END
			else if(menu.equals("c")) {
				
				ExcelPrint xp = new ExcelPrint();
				
				xp.setXls(ar_eb);		
				
				System.out.println("실행되었습니다.");
			}
		} // while 사원조회  메뉴 END
	} // first_menu end

	// 2번 메뉴 메소드 생성
	public void second_menu()
	{ // 사원추가
		System.out.println("추가하고자 하는 사원의 번호를 입력하세요.");
		String empno = input_msg();
		System.out.println("추가하고자 하는 사원의 이름을 입력하세요.");
		String ename = input_msg();
		System.out.println("추가하고자 하는 사원의 부서번호을 입력하세요.");
		String deptno = input_msg();

		// 2가지 값을 전달해 추가
		EmpData ed = new EmpData();
		ar_eb = ed.ins_emp(empno, ename, deptno, ar_eb);
	}

	// 3번 메뉴 메소드 생성
	public void third_menu()
	{ // 사원정보 수정 실행
		SearchHR shr = SearchHR.getInstance();
		System.out.println("@ 수정 메뉴를 선택하셨습니다.");
		for (;;)
		{
			System.out.println("수정하고자하는 사원 리스트 번호를 입력하시오.");
			shr.all_View(ar_eb);
			String idx = super.input_msg();

			if (Integer.parseInt(idx) <= ar_eb.size())
			{
				System.out.println("수정하고자 하는 사원 번호를 입력하세요.");
				String m_empno = input_msg();
				System.out.println("수정하고자 하는 사원 이름을 입력하세요.");
				String m_ename = input_msg();
				EmpData ed = new EmpData();
				ar_eb = ed.mod_emp(ar_eb, m_empno, m_ename, idx);
				break;
			}
			else
			{
				System.out.println("잘못된 리스트 번호를 입력하셨습니다.");
			}
		}
	}

	// 4번 메뉴 메소드 생성
	public void fourth_menu()
	{
		// 삭제 메뉴 출력
		System.out.println("@ 삭제 메뉴를 선택하셨습니다.");

		System.out.println("삭제하고자 하는 사원의 리스트 번호를 입력하세요.");
		// 전체 사원 리스트 출력
		new SearchHR().all_View(ar_eb);

		String idx = input_msg();

		// 사원번
		EmpData ed = new EmpData();
		ar_eb = ed.del_emp2(ar_eb, idx); // 삭제된 객체배열을 리턴 받아 재정의

	}

	// 5번 메뉴 메소드 생성
	public void fifth_menu(int auth)
	{
		// 부서정보 조회 메뉴
		boolean repeat = true;
		while (repeat)
		{
			System.out.println("------------------------------");
			System.out.println("----------부서정보조회 메뉴---------");
			System.out.println("------------------------------");
			System.out.println("@ 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("1. 부서 조회");
			if (auth == 0)
			{
				System.out.println("2. 부서 추가");
				System.out.println("3. 부서 수정");
				System.out.println("4. 부서 삭제");
			}
			System.out.println("exit. 종료");
			System.out.print("값을 입력하세요. => ");
			String menu = input_msg();
			DeptMenu dm = DeptMenu.getInstance();
			if (menu.equals("exit"))
			{
				repeat = false;
			}
			else if (menu.equals("1"))
			{
				dm.dept_search(ar_db);
			}
			else if (menu.equals("2") && auth == 0)
			{
				ar_db = dm.dept_add(ar_db);
			}
			else if (menu.equals("3") && auth == 0)
			{
				ar_db = dm.dept_mod(ar_db);
			}
			else if (menu.equals("4") && auth == 0)
			{
				ar_db = dm.dept_del(ar_db);
			}
		}
	}

} // class menu end
