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
	 * ͨ���жϿ���ȡ��������
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
						//�вֿ����㹻������
						 order=new Order(new FullStrategy(),fwL,goods);
						 return order;
					 }else{
					    i++;
					    if(i>=wList.size()){
					    	//���вֿ�û��һ������㹻������
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
		// ȡ���ֿ���Ϣ
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
		 //�������ȼ�˳����ӵ�����( w1->w3->w2)
		wList.add(w1);
		wList.add(w3);
		wList.add(w2);
		
		
		//1���жϾ��룺�˿���W1����������ȴ�W1����
		//2��W1��Ʒ���㣬�ж����ȼ��ߵ���Ʒ�Ƿ��㹻���⣬�㹻����⣬����������ж���һ��...
		//3�����Բֿⶼ���㣬������ȼ��ߵ������β������
		
		//�µ�A��Ʒ2��
		//System.out.println("*****�µ�A��Ʒ2��*****");
		System.out.println("*****�µ�B��Ʒ4��*****");
		System.out.println("��������    "+"��Ʒ����    "+"����    "+"�����ֿ�");
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
