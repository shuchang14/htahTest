package htah;

import htah.dto.Goods;
import htah.dto.W;
import htah.strategyimpl.FullStrategy;
import htah.strategyimpl.LackStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class OrderTest {
	
	/**
	 * 通过判断库存获取出货策略
	 * @param i
	 * @param wList
	 * @param goods
	 * @return
	 */
	public static Order getOrder(int i,List<W> wList,Goods goods){
		 Order order=null;
		 while(i<wList.size()){
			 for(Goods wgoods:wList.get(i).getGoodList()){
				 if(goods.getName()==wgoods.getName()){
					 
					 if(goods.getNum()<=wgoods.getNum()){ 
						 List<W> fwL=new ArrayList<>();
						 fwL.add(wList.get(i));
						//有仓库库存足够发货的
						 order=new Order(new FullStrategy(),fwL,goods);
						 return order;
					 }else{
					    i++;
					    if(i>=wList.size()){
					    	//所有仓库没有一个库存足够发货的
					    	 order=new Order(new LackStrategy(),wList,goods);
					    }else{
					       getOrder(i,wList,goods);
					     }
					 }
				 }	 
			 } 
		 }
		 return order;
	 }
	@Test
	public void test() {	
		// 取到仓库信息
		List<W> wList=new ArrayList<>();
		
		 List<Goods> goodsList=new ArrayList<>();
		 goodsList.add(new Goods("A",1));
		 goodsList.add(new Goods("B",2));
		 goodsList.add(new Goods("C",2));
		 W w1=new W("w1",goodsList);
		
		 
		 List<Goods> goodsList2=new ArrayList<>();
		 goodsList2.add(new Goods("A",2));
		 goodsList2.add(new Goods("B",1));
		 goodsList2.add(new Goods("C",2));
		 W w2=new W("w2",goodsList2);
		 
		 List<Goods> goodsList3=new ArrayList<>();
		 goodsList3.add(new Goods("A",2));
		 goodsList3.add(new Goods("B",3));
		 goodsList3.add(new Goods("C",1));
		 W w3=new W("w3",goodsList3);
		 //根据优先级顺序添加到集合( w1->w3->w2)
		wList.add(w1);
		wList.add(w3);
		wList.add(w2);
		
		
		//1、判断距离：顾客与W1最近，故优先从W1出库
		//2、W1商品不足，判断优先级高的商品是否足够出库，足够则出库，不足则进行判断下一级...
		//3、所以仓库都不足，则从优先级高到低依次补充出库
		
		//下单A商品2个
		//System.out.println("*****下单A商品2个*****");
		System.out.println("*****下单B商品4个*****");
		System.out.println("发货单号    "+"商品名称    "+"数量    "+"出货仓库");
		int i=1;
		//Goods goods=new Goods("A",2);
		Goods goods=new Goods("B",4);
		Map<Integer,Object> map=getOrder(0,wList,goods).strategy();    
		Iterator<Integer> it = map.keySet().iterator();   
		while(it.hasNext()){
			Integer key=it.next();
			W w=(W) map.get(key);
			System.out.println(i+"      "+goods.getName()+"      "+w.getSendNum()+"    "+w.getName());
			i++;
		}			
	}
}
