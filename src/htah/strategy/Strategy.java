package htah.strategy;

import htah.dto.Goods;
import htah.dto.W;

import java.util.List;
import java.util.Map;

/**
 * ���Խӿ�
 * @author Administrator
 *
 */
public interface Strategy {	
	/**
	 * ��������
	 */
	 public Map<Integer,Object> sendStrategy(List<W> w,Goods goods);
}
