package practice2;

public class OracleDao implements DataAccessObject{
	String a = "OracleDao";

	@Override
	public void select() {
		System.out.println(a + "검색");
		
	}

	@Override
	public void insert() {
		System.out.println(a + "삽입");
		
	}

	@Override
	public void update() {
		System.out.println(a + "수정");
		
	}

	@Override
	public void delete() {
		System.out.println(a + "삭제");
		
	}
	
}
