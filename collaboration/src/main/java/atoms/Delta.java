package atoms;

public class Delta {
	private Engineer__Ws initiator;

	public Delta(Engineer__Ws engineer) 
	{
		//Rule here
		for(Collaboration c: engineer.getCollaborations()) {
			if(c.getSender() == engineer) {
				if(c.getType() instanceof Instant) 
				{
					c.getReceiver().getDelta().add(this);
					this.setInitiator(engineer);
					if(c.getReceiver() instanceof Group_Ws) 
					{
						((Group_Ws) c.getReceiver()).sendInstant(this);
					}
				}
				else
				{
					this.setInitiator(engineer);
				}
			}
		}
	}
	
	public Delta() {
		
	}
	
	//Getters and Setters
	public Engineer__Ws getInitiator() {
		return initiator;
	}

	public void setInitiator(Engineer__Ws initiator) {
		this.initiator = initiator;
	}
	
	

}
