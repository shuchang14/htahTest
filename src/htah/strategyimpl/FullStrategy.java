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
public class FullStrategy implements Strategy {

	@Override
	public Map<Integer,Object> sendStrategy(List<W> wList,Goods goods) {
		// TODO �Զ����ɵķ������
		W w=wList.get(0);
		w.setSendNum(goods.getNum());
		//System.out.println("��Ʒ"+goods.getName()+"  ����"+goods.getNum()+"  �ֿ�"+w.get(0).getName());
		//System.out.println("����");
		Map<Integer,Object> map=new HashMap<>();
		map.put(1, w);
		return map;
		
       
	}

}
