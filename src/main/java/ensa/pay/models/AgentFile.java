package ensa.pay.models;


public class AgentFile {
	
	private Agent agent;
	
	private Files files;
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public AgentFile(Agent agent, Files files) {
		super();
		this.agent = agent;
		this.files = files;
	}
	public AgentFile() {
		
	}
	
	
}
