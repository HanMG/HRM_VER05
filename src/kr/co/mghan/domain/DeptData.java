package kr.co.mghan.domain;

public class DeptData
{
	public DeptBean[] def_data(){
		
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
		
		DeptBean[] arr_db = {db, db2, db3};
		
		return arr_db;
		
	}
	
	public DeptBean getDept(int deptno, DeptBean[] ar_db)
	{
		for (int i = 0; i < ar_db.length; i++)
		{
			if (ar_db[i].getDeptno() == deptno)
			{
				return ar_db[i];
			}
		}
		return null;
	}

}
