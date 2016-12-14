package htah.strategy;

import htah.dto.Goods;
import htah.dto.W;

import java.util.List;
import java.util.Map;

/**
 * 策略接口
 * @author Administrator
 *
 */
public interface Strategy {	
	/**
	 * 发货策略
	 */
	 public Map<Integer,Object> sendStrategy(List<W> w,Goods goods);
}
