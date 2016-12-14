package htah.dto;

/**
 * 商品实体类
 * @author Administrator
 *
 */
public class Goods {
	private String name;
	private Integer num;
	
	public Goods() {
		super();
	}
	public Goods(String name,Integer num) {
		this.name=name;
		this.num=num;
	}
	
	@Override
	public String toString() {
		return "Goods [name=" + name + ", num=" + num + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	   


}
