package generic_002_yes;

public class Tv { // &200
	String programName; // 런닝맨
	int channel; // 6
	int volum; // 15
	int light; // 50
	
	public Tv() {}
						//런닝맨 			6			15			50
	public Tv(String programName, int channel, int volum, int light) {
		this.programName = programName; //런닝맨
		this.channel = channel; // 6
		this.volum = volum;// 15
		this.light = light;// 50
	}
	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolum() {
		return volum;
	}

	public void setVolum(int volum) {
		this.volum = volum;
	}

	public int getLight() {
		return light;
	}

	public void setLight(int light) {
		this.light = light;
	}
	@Override
	public String toString() {
		return "Tv [programName=" + programName + ", channel=" + channel + ", volum=" + volum + ", light=" + light
				+ "]";
}
}
