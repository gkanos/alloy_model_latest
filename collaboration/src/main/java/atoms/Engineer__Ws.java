package atoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graphicElements.LogGraphics;

public class Engineer__Ws {
	private List<Delta> delta; //TODO: Make it a list of deltas!
	private String name;
	private Set<Collaboration> collaborations;
	private Engineer__Ws parentWs;
	
	public Engineer__Ws() {
		this.collaborations = new HashSet<Collaboration>();
		this.delta = new ArrayList<Delta>();
		//LogGraphics.getGraphElements().add(this);
	}
	
	
	public void addCollaboration(Collaboration colab)
	{
		this.collaborations.add(colab);
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Collaboration> getCollaborations() {
		return collaborations;
	}
	public void setCollaborations(Set<Collaboration> collaborations) {
		this.collaborations = collaborations;
	}

	public List<Delta> getDelta() {
		return delta;
	}

	public void setDelta(List<Delta> delta) {
		this.delta = delta;
	}
	
	public void setDelta(Delta delta) 
	{
		this.delta.add(delta);
	}


	public Engineer__Ws getParentWs() {
		return parentWs;
	}


	public void setParentWs(Engineer__Ws parentWs) {
		this.parentWs = parentWs;
	}


	//Scenario Methods
	public Delta createDelta(Engineer__Ws engineer) {
		Delta d = new Delta(engineer);
		this.setDelta(d);
		//LogGraphics.getGraphElements().add(d);
		return d;
	}

	public Collaboration createCollaboration() {
		return new Collaboration();
	}


	public void trigger(Trigger t) {
		//LogGraphics.getGraphElements().add(t);
		t.trigger();
	}
	
	public void publishToWorkspace() 
	{
		if(parentWs != null) 
		{
			for(Delta d : delta) {
				if(!parentWs.getDelta().contains(d)) {
					parentWs.getDelta().add(d);
				}
			}
		}
	}

}
