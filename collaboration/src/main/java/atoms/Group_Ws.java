package atoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Group_Ws extends Engineer__Ws {
	
	public Group_Ws() {
		super();
		//collaborations = new HashSet<Collaboration>();
		//delta = new ArrayList<Delta>();
	}
	
	public void triggerGroup(Trigger t) {
		//Select the groups collaborations and activate them.
		//use superclass method to retrieve collaborations
		//setup execution.
		//find the algorithm for it.
		//
		t.triggerGroup(this);
	}
	
	public void sendInstant(Delta d) {
		for(Collaboration c : getCollaborations()) 
		{

			if(c.getSender() == this && c.getType() instanceof Instant) 
			{
				if(d.getInitiator() != c.getReceiver()) {
					c.getReceiver().getDelta().add(d);
				}
			}

		}
	}
	
//	@Override
	public void addDelta(Group_Ws gWs, Delta d) 
	{
		gWs.sendInstant(d);
		gWs.getDelta().add(d);
	}

}
