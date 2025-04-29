package index;
import java.util.*;
public class Member extends Visitor{
	private Integer point;

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Member(String name, String code, Double balance, ArrayList<String> visit, Integer point) {
		super(name, code, balance, visit);
		this.point = point;
	}

	
	
}
