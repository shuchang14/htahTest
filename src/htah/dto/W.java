package htah.dto;

import java.util.List;
/**
 * �ֿ�ʵ����
 * @author Administrator
 *
 */
public class W {
	private String name;
	private int sendNum;
	private List<Goods> goodList;
	
	public W() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public W(String name,List<Goods> goodList) {
		this.name=name;
		this.goodList=goodList;
		// TODO �Զ����ɵĹ��캯�����
	}

	
	
	

	@Override
	public String toString() {
		return "W [name=" + name + ", sendNum=" + sendNum + ", goodList="
				+ goodList + "]";
	}

	public int getSendNum() {
		return sendNum;
	}

	public void setSendNum(int sendNum) {
		this.sendNum = sendNum;
	}

	public List<Goods> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<Goods> goodList) {
		this.goodList = goodList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
