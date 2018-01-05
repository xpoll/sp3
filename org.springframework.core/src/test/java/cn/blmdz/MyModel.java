package cn.blmdz;

public class MyModel {
	private String name;
	private String url;
	private Integer num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "MyModel [name=" + name + ", url=" + url + ", num=" + num + "]";
	}
}
