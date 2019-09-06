package kr.co.mghan.domain;

public class EmpData
{
	// 샘플 데이터 세팅
	public EmpBean[] def_data()
	{
		// empno, ename, mgr, job, sal, comm,
		// hiredate, deptno
		// 각각의 사원들에 대한 정보 입력

		EmpBean eb = new EmpBean();

		eb.setEmpno(9999);
		// int empno = 9999;
		eb.setEname("Smith");
		// String ename = "Smith";
		eb.setMgr(1111);
		// int mgr = 1111;
		eb.setJob("IT");
		// String job = "IT";
		eb.setSal(9800);
		// double sal = 9800;
		eb.setComm(9800);
		// double comm = 9800 * 0.15;
		eb.setHiredate("2019/09/03");
		// String hiredate = "2019/09/03";
		eb.setDeptno(10);
		// int deptno = 10;

		EmpBean eb2 = new EmpBean();
		eb2.setEmpno(2222);
		// int empno = 9999;
		eb2.setEname("King");
		// String ename = "Smith";
		eb2.setMgr(2222);
		// int mgr = 1111;
		eb2.setJob("IT");
		// String job = "IT";
		eb2.setSal(15000);
		// double sal = 9800;
		eb2.setComm(15000);
		// double comm = 9800 * 0.15;
		eb2.setHiredate("2015/05/09");
		// String hiredate = "2019/09/03";
		eb2.setDeptno(20);
		// int deptno = 10;

		EmpBean eb3 = new EmpBean();
		eb3.setEmpno(3333);
		// int empno = 9999;
		eb3.setEname("LISS");
		// String ename = "Smith";
		eb3.setMgr(3333);
		// int mgr = 1111;
		eb3.setJob("Maketing");
		// String job = "IT";
		eb3.setSal(12000);
		// double sal = 9800;
		eb3.setComm(12000);
		// double comm = 9800 * 0.15;
		eb3.setHiredate("2016/02/22");
		// String hiredate = "2019/09/03";
		eb3.setDeptno(30);
		// int deptno = 10;

		EmpBean[] ebb =
		{ eb, eb2, eb3 };
		EmpBean[] ebb2 = null;
		ebb2 = new EmpBean[]
		{ eb, eb2, eb3 };
		EmpBean[] ebb3 = new EmpBean[4];
		ebb3[0] = eb;
		ebb3[1] = eb2;
		ebb3[2] = eb3;

		return ebb;
	} // def_data end

	// 특정 사원 정보 조회 후 값 세팅하기 (def_data() 에 갖고 있는 초기값)
	public EmpBean getEmp(int empno, EmpBean[] ar_eb)
	{
		for (int i = 0; i < ar_eb.length; i++)
		{
			if (ar_eb[i].getEmpno() == empno)
			{
				return ar_eb[i];
			}
		}
		return null;
	}

	// 사원 추가 시키기 (Menu -> empno, ename ) 받아서 사용
	public EmpBean[] ins_emp(String empno, String ename, String deptno, EmpBean[] ar_eb)
	{
		// 기존 사원 정보에서 매개변수에 입력된 정보 추가
		EmpBean[] old_ar_eb = ar_eb;
		// 추가된 공간 확보
		// 기존 공간수 + 1
		// 기존 공간수 확인
		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
		for (int i = 0; i < old_ar_eb.length; i++)
		{
			EmpBean eb = new EmpBean();
			eb.setEmpno(old_ar_eb[i].getEmpno());
			eb.setEname(old_ar_eb[i].getEname());
			eb.setDeptno(old_ar_eb[i].getDeptno());
			new_ar_eb[i] = eb;
		}
		// 추가된 값을 마지막 배열에 추가시킴
		EmpBean n_eb = new EmpBean();
		n_eb.setEmpno(Integer.parseInt(empno));
		n_eb.setEname(ename);
		n_eb.setDeptno(Integer.parseInt(deptno));
		new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return new_ar_eb;
	}

	// 사원번호와 객체배열을 받아 삭제 진행
	public EmpBean[] del_emp(String empno, EmpBean[] ar_eb)
	{
		EmpBean[] old_ar_eb = ar_eb; // 현재 배열
		int target = 0; // 제거될 타겟의 인덱스
		int isEmp = 0; // 사원이 있는 지 체크

		// 전체를 돌면서 타겟의 인덱스를 찾고 찾으면 해당 객체를 NULL로 하고 사원체크변수를 증가한뒤 for문 정지
		for (target = 0; target < old_ar_eb.length; target++)
		{
			if (old_ar_eb[target].getEmpno() == Integer.parseInt(empno))
			{
				old_ar_eb[target] = null;
				isEmp++;
				break;
			}
		}

		// 사원이 존재하면 아래를 실행
		if (isEmp > 0)
		{

			// 정렬로 NULL로 된 객체를 배열 제일 마지막으로 이동시킴
			for (int i = 0; i < old_ar_eb.length; i++)
			{
				for (int j = 0; j < old_ar_eb.length; j++)
				{
					EmpBean tmp = new EmpBean();
					if (old_ar_eb[j] == null)
					{
						if (j != (old_ar_eb.length - 1))
						{
							tmp = old_ar_eb[j];
							old_ar_eb[j] = old_ar_eb[j + 1];
							old_ar_eb[j + 1] = tmp;
						}
					}
				}
			}

			// 새로운 객체배열 생성, 현재 배열보다 한칸 작게
			EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length - 1];

			// 새로운 객체배열에 현재배열의 값을 입력
			for (int j = 0; j < new_ar_eb.length; j++)
			{
				EmpBean eb = new EmpBean();
				eb.setEmpno(old_ar_eb[j].getEmpno());
				eb.setEname(old_ar_eb[j].getEname());
				eb.setDeptno(old_ar_eb[j].getDeptno());
				new_ar_eb[j] = eb;
			}

			// 새로운 객체배열 리턴
			return new_ar_eb;
		} // if END

		// 사원번호체크 isEmp가 그대로일 경우 사원번호가 없음을 출력하고, 원래 객체배열을 다시 리턴
		else
		{
			System.out.println("사원번호가 없음.");
			return ar_eb;
		}
	} // del_emp END

	// 객체배열과 인덱스 번호를 받아 삭제 진행
	public EmpBean[] del_emp2(EmpBean[] ar_eb, String idx)
	{
		// 삭제 기능 메소드
		// 매개변수 -> ar_eb, idx
		// 삭제 된 이후의 배열 공간 재 할당
		// 만약에 인덱스 번호를 잘 못 입력했을 경우
		EmpBean[] new_ar_eb = new EmpBean[ar_eb.length - 1];
		// idx 번호에 있는 사람을 제외한 나머지 값을 new_ar_eb에 복사
		int i_idx = Integer.parseInt(idx);
		// 새롭게 복사될 idx 값 생성
		int n_idx = 0;

		try
		{
			for (int i = 0; i < ar_eb.length; i++)
			{
				if ((i_idx - 1) != i)
				{
					EmpBean eb = new EmpBean();
					eb.setEmpno(ar_eb[i].getEmpno());
					eb.setEname(ar_eb[i].getEname());
					new_ar_eb[n_idx] = eb;
					n_idx++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException aiobe)
		{
			System.out.println("해당값이 존재하지 않습니다.");
			return ar_eb;
		}

		return new_ar_eb;

	}// del_emp2 END

	public EmpBean[] mod_emp(EmpBean[] ar_eb, String m_empno, String m_ename, String idx)
	{
		// 수정 진행
		// ar_eb = 원본 emp 값, m_empno = 수정해야 할 사원번호
		// m_ename = 수정해야할 사원 이름, idx = 수정 대상 index번호
		int i_idx = Integer.parseInt(idx);

		ar_eb[i_idx - 1].setEmpno(Integer.parseInt(m_empno));
		ar_eb[i_idx - 1].setEname(m_ename);

		return ar_eb;
	}
}
