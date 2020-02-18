package atoms;

import java.util.List;

public class Trigger extends Action {
	private Engineer__Ws sender;
	
	//Getters and Setters
	public Engineer__Ws getSender() {
		return sender;
	}

	public void setSender(Engineer__Ws sender) {
		this.sender = sender;
	}
	
	//Scenario methods
	public void trigger() {
		List<Delta> deltas1 = this.sender.getDelta();
		for(Delta d1:deltas1) {
			try {
				for(Collaboration c : d1.getInitiator().getCollaborations()) //in order to propagate to all this must be changed to sender.getCollaborations
				//for(Collaboration c: sender.getCollaborations())
				{
					if(c.getType() instanceof Triggered && this.sender == c.getSender()) 
					{
						if(!c.getReceiver().getDelta().contains(d1)) {
							if(c.getReceiver() instanceof Group_Ws) 
							{
								((Group_Ws) c.getReceiver()).addDelta((Group_Ws) c.getReceiver(), d1);
							}
							else 
							{
								c.getReceiver().getDelta().add(d1);
							}
						}
						else 
						{
							//System.out.print("No new delta to push!");
						}
					}
					
				}
			}
			catch(NullPointerException e) 
			{
				//System.err.println("Collaboration not correctly set up on engineer " + this.sender.getName());
			}
//			else
//			{
//				System.out.println("No delta to push!");
//			}
		}
	}
	
	//Scenario Group method
	public void triggerGroup(Group_Ws groupWorkspace) 
	{
		List<Delta> deltas = groupWorkspace.getDelta();
		
		for(Delta d:deltas) 
		{
			try {
				for(Collaboration c: groupWorkspace.getCollaborations()) 
				{
					if(c.getReceiver().equals(this.getSender()) && c.getType() instanceof Triggered) {
						if(!c.getReceiver().equals(d.getInitiator()) && !c.getReceiver().getDelta().contains(d)) {
							c.getReceiver().getDelta().add(d);
						}
					}
				}
			}
			catch(NullPointerException e)
			{
				System.out.println("No collaboration established.");
			}
		}
	}
		
	

}
