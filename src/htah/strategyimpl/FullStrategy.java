package htah.strategyimpl;

import htah.dto.Goods;
import htah.dto.W;
import htah.strategy.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库货充足
 * @author Administrator
 *
 */
public class FullStrategy implements Strategy {

	@Override
	public Map<Integer,Object> sendStrategy(List<W> wList,Goods goods) {
		// TODO 自动生成的方法存根
		W w=wList.get(0);
		w.setSendNum(goods.getNum());
		//System.out.println("商品"+goods.getName()+"  数量"+goods.getNum()+"  仓库"+w.get(0).getName());
		//System.out.println("充足");
		Map<Integer,Object> map=new HashMap<>();
		map.put(1, w);
		return map;
		
       
	}

}
