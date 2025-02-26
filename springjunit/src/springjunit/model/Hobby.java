package springjunit.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("hobby")
public class Hobby implements Serializable {

	private static final long serialVersionUID = 23532132132132164L;

	private String sort;

	public Hobby() {
	}

	public Hobby(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Hobby [sort=" + sort + "]";
	}

}
