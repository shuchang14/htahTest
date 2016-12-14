package htah;

import htah.dto.Goods;
import htah.dto.W;
import htah.strategy.Strategy;

import java.util.List;
import java.util.Map;
/**
 * ��������
 * @author Administrator
 *
 */
public class Order {
	
	private Strategy strategy;
	private List<W> wList;
	private Goods goods;
	public Order(Strategy strategy,List<W> wList,Goods goods){
		this.strategy=strategy;
		this.wList=wList;
		this.goods=goods;
	}
	/**
	 * ���ó������Է���
	 * @return
	 */
	public Map<Integer, Object> strategy(){
		return strategy.sendStrategy(wList,goods);
	}
	
}
