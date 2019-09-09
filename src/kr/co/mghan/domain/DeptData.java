package kr.co.mghan.domain;

import java.util.ArrayList;
import java.util.List;

public class DeptData
{
	public List<DeptBean> def_data(){
		
		DeptBean db = new DeptBean();
		db.setDeptno(10);
		db.setDeptname("HR");
		db.setLoc("PANKYO");
		
		DeptBean db2 = new DeptBean();
		db2.setDeptno(20);
		db2.setDeptname("MAKETING");
		db2.setLoc("GANGNAM");
		
		DeptBean db3 = new DeptBean();
		db3.setDeptno(30);
		db3.setDeptname("IT");
		db3.setLoc("GURO");
		
		List<DeptBean> db_list = new ArrayList<DeptBean>() ; 
		
		db_list.add(db);
		db_list.add(db2);
		db_list.add(db3);		
		
		return db_list;
		
	}
	
	
	// 특정 부서 조회
	public DeptBean getDept(int deptno, List<DeptBean> ar_db)
	{
		for (int i = 0; i < ar_db.size(); i++)
		{
			if (ar_db.get(i).getDeptno() == deptno)
			{
				return ar_db.get(i);
			}
		}
		return null;
	}

}
