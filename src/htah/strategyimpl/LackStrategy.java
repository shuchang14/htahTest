package htah.strategyimpl;

import htah.dto.Goods;
import htah.dto.W;
import htah.strategy.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �ֿ������
 * @author Administrator
 *
 */
public class LackStrategy implements Strategy {
	
	@Override
	public Map<Integer,Object> sendStrategy(List<W> w,Goods goods) {
		//�ֿ����ȼ�������w1<w2<w3
		int i=0;
		int num=goods.getNum();
		Map<Integer,Object> map=new HashMap<>();
		while(i<w.size()){
			if(num>0){
				for(Goods wgoods:w.get(i).getGoodList()){
					if(wgoods.getName()==goods.getName()){
						if(num<wgoods.getNum()){		
							w.get(i).setSendNum(num);
							map.put(i, w.get(i));
							num=0;
						}else{
							num=num-wgoods.getNum();
							w.get(i).setSendNum(wgoods.getNum());
							map.put(i, w.get(i));
						}
						
					}
				}
			}
			i++;
		}
		
		return map;
	}

}
