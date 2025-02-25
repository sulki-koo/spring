package springdi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class TV {

	@Autowired
//	@Qualifier("samsungspeaker")
	@Qualifier("lgspeaker")
	private Speaker speaker;

	public TV() {
		System.out.println("TV°´Ã¼ »ý¼º");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

}
