package Main;

import java.util.Comparator;

public class Acountsort implements Comparator<Acount> {

	int ret=0;
	@Override
	public int compare(Acount o1, Acount o2) {
		if(o1.getPoint()<o2.getPoint()){
			ret=1;
		}else if(o1.getPoint()>o2.getPoint()) {
			ret=-1;
		}
		return ret;
	}
}
