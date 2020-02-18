package atoms;

import graphicElements.LogGraphics;

public class Collaboration {
	private CollaborationType type;
	private Engineer__Ws sender;
	private Engineer__Ws receiver;

	public Collaboration() {
		LogGraphics.getGraphElements().add(this);
	}
	
	//Getters and setters
	public CollaborationType getType() {
		return type;
	}
	public void setType(CollaborationType type) {
		this.type = type;
	}
	public Engineer__Ws getSender() {
		return sender;
	}
	public void setSender(Engineer__Ws sender) {
		this.sender = sender;
	}
	public Engineer__Ws getReceiver() {
		return receiver;
	}
	public void setReceiver(Engineer__Ws receiver) {
		this.receiver = receiver;
	}
	
	
	//Scenario Methods
	public CollaborationType selectType(String string) {
		if(string.equals("Triggered")) 
		{
			Triggered ct = new Triggered();
			ct.setName(string);
			this.setType(ct);
			return ct;
		}
		else if(string.equals("Instant")) 
		{
			Instant ct = new Instant();
			ct.setName(string);
			this.setType(ct);
			return ct;
		}
		else 
		{
			try 
			{
				throw new NullPointerException("Invalid Collaboration Selection");
			}
			catch(NullPointerException e) 
			{
				throw e;
			}
		}
	}
	

}
