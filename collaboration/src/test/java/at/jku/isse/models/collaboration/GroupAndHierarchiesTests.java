package at.jku.isse.models.collaboration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import atoms.Collaboration;
import atoms.CollaborationType;
import atoms.Engineer__Ws;
import atoms.Group_Ws;
import atoms.Trigger;

public class GroupAndHierarchiesTests {
	
	@Test
	public void groupTest1() 
	{
		
		Engineer__Ws ea1 = new Engineer__Ws();
		Engineer__Ws eb1 = new Engineer__Ws();
		ea1.setName("Alice");
		eb1.setName("Bob");
		
		Group_Ws group1 = new Group_Ws();
		group1.setName("GroupAliceBob");
		
		Collaboration ea1Group1 = new Collaboration();
		ea1Group1.setSender(ea1);
		ea1Group1.setReceiver(group1);
		CollaborationType ct1 = ea1Group1.selectType("Triggered");
		ea1Group1.setType(ct1);
		
		Collaboration group1Ea1 = new Collaboration();
		group1Ea1.setSender(group1);
		group1Ea1.setReceiver(ea1);
		group1Ea1.setType(ct1);
		
		Collaboration eb1Group1 = new Collaboration();
		eb1Group1.setSender(eb1);
		eb1Group1.setReceiver(group1);
		eb1Group1.setType(ct1);
		
		Collaboration group1Eb1 = new Collaboration();
		group1Eb1.setSender(group1);
		group1Eb1.setReceiver(eb1);
		group1Eb1.setType(ct1);
		
		ea1.addCollaboration(ea1Group1);
		ea1.addCollaboration(group1Ea1);
		
		eb1.addCollaboration(eb1Group1);
		eb1.addCollaboration(group1Eb1);
		
		group1.addCollaboration(group1Eb1);
		group1.addCollaboration(eb1Group1);
		group1.addCollaboration(group1Ea1);
		group1.addCollaboration(ea1Group1);
		
		Trigger t1 = new Trigger();
		t1.setSender(ea1);
		
		Trigger t1group = new Trigger();
		t1group.setSender(eb1);
		
		ea1.createDelta(ea1);
		ea1.trigger(t1);
		
		assertEquals(ea1.getDelta().size(), group1.getDelta().size());
		
		group1.triggerGroup(t1group);
		
		assertEquals(group1.getDelta().size(), eb1.getDelta().size());
		assertEquals(ea1.getDelta(), eb1.getDelta());
		
	}
	
	@Test
	public void groupTest2() 
	{
		Engineer__Ws ea2 = new Engineer__Ws();
		Engineer__Ws eb2 = new Engineer__Ws();
		Engineer__Ws ec2 = new Engineer__Ws();
		ea2.setName("Alice");
		eb2.setName("Bob");
		ec2.setName("Charlie");
		
		Group_Ws group2 = new Group_Ws();
		group2.setName("GroupAliceBobCharlie");
		
		Collaboration ea2group = new Collaboration();
		ea2group.setSender(ea2);
		ea2group.setReceiver(group2);
		CollaborationType type = ea2group.selectType("Triggered");
		ea2group.setType(type);
		
		Collaboration groupEa2 = new Collaboration();
		groupEa2.setSender(group2);
		groupEa2.setReceiver(ea2);
		groupEa2.setType(type);
		
		Collaboration eb2group = new Collaboration();
		eb2group.setSender(eb2);
		eb2group.setReceiver(group2);
		eb2group.setType(type);
		
		Collaboration groupEb2 = new Collaboration();
		groupEb2.setSender(group2);
		groupEb2.setReceiver(eb2);
		groupEb2.setType(type);
		
		Collaboration ec2group = new Collaboration();
		ec2group.setSender(ec2);
		ec2group.setReceiver(group2);
		ec2group.setType(type);
		
		Collaboration groupEc2 = new Collaboration();
		groupEc2.setSender(group2);
		groupEc2.setReceiver(ec2);
		groupEc2.setType(type);
				
		
		ea2.addCollaboration(ea2group);
		ea2.addCollaboration(groupEa2);
		
		eb2.addCollaboration(eb2group);
		eb2.addCollaboration(groupEb2);
		
		ec2.addCollaboration(ec2group);
		ec2.addCollaboration(groupEc2);
		
		group2.addCollaboration(groupEc2);
		group2.addCollaboration(ec2group);
		group2.addCollaboration(groupEb2);
		group2.addCollaboration(eb2group);
		group2.addCollaboration(groupEa2);
		group2.addCollaboration(ea2group);
		
		Trigger t2 = new Trigger();
		t2.setSender(ea2);
		
		Trigger t2GroupEb2 = new Trigger();
		t2GroupEb2.setSender(eb2);
		
		Trigger t2GroupEc2 = new Trigger();
		t2GroupEc2.setSender(ec2);
		
		ea2.createDelta(ea2);
		ea2.trigger(t2);
		
		assertEquals(ea2.getDelta().size(), group2.getDelta().size());
		assertNotEquals(eb2.getDelta().size(), group2.getDelta().size());
		
		group2.triggerGroup(t2GroupEb2);
		
		assertEquals(group2.getDelta().size(), eb2.getDelta().size());
		//
		group2.triggerGroup(t2GroupEc2);
		//
		assertEquals(group2.getDelta().size(),ec2.getDelta().size());
		
		assertEquals(group2.getDelta(), eb2.getDelta());
		
	}
	
	@Test
	public void groupTest3() 
	{
		Engineer__Ws ea3 = new Engineer__Ws();
		Engineer__Ws eb3 = new Engineer__Ws();
	
		ea3.setName("Alice");
		eb3.setName("Bob");
		
		Group_Ws group3 = new Group_Ws();
		group3.setName("GroupAliceBob");
		
		Collaboration ea3group = new Collaboration();
		ea3group.setSender(ea3);
		ea3group.setReceiver(group3);
		CollaborationType type = ea3group.selectType("Instant");
		ea3group.setType(type);
		
		Collaboration groupEa3 = new Collaboration();
		groupEa3.setSender(group3);
		groupEa3.setReceiver(ea3);
		groupEa3.setType(type);
		
		Collaboration eb3group = new Collaboration();
		eb3group.setSender(eb3);
		eb3group.setReceiver(group3);
		eb3group.setType(type);
		
		Collaboration groupEb3 = new Collaboration();
		groupEb3.setSender(group3);
		groupEb3.setReceiver(eb3);
		groupEb3.setType(type);
		
		ea3.addCollaboration(ea3group);
		ea3.addCollaboration(groupEa3);
		
		eb3.addCollaboration(eb3group);
		eb3.addCollaboration(groupEb3);
		
		group3.addCollaboration(groupEb3);
		group3.addCollaboration(eb3group);
		group3.addCollaboration(groupEa3);
		group3.addCollaboration(ea3group);
		
		ea3.createDelta(ea3);
		
		assertEquals(ea3.getDelta().size(), group3.getDelta().size());
		assertEquals(ea3.getDelta().size(), eb3.getDelta().size());
		
	}
	
	@Test
	public void groupTest4() 
	{
		Engineer__Ws ea4 = new Engineer__Ws();
		Engineer__Ws eb4 = new Engineer__Ws();
		Engineer__Ws ec4 = new Engineer__Ws();
		ea4.setName("Alice");
		eb4.setName("Bob");
		ec4.setName("Charlie");
		
		Group_Ws group4 = new Group_Ws();
		group4.setName("GroupAliceBobCharlie");
		
		Collaboration ea4group = new Collaboration();
		ea4group.setSender(ea4);
		ea4group.setReceiver(group4);
		CollaborationType type = ea4group.selectType("Instant");
		ea4group.setType(type);
		
		Collaboration groupEa4 = new Collaboration();
		groupEa4.setSender(group4);
		groupEa4.setReceiver(ea4);
		groupEa4.setType(type);
		
		Collaboration eb4group = new Collaboration();
		eb4group.setSender(eb4);
		eb4group.setReceiver(group4);
		eb4group.setType(type);
		
		Collaboration groupEb4 = new Collaboration();
		groupEb4.setSender(group4);
		groupEb4.setReceiver(eb4);
		groupEb4.setType(type);
		
		Collaboration ec4group = new Collaboration();
		ec4group.setSender(ec4);
		ec4group.setReceiver(group4);
		ec4group.setType(type);
		
		Collaboration groupEc4 = new Collaboration();
		groupEc4.setSender(group4);
		groupEc4.setReceiver(ec4);
		groupEc4.setType(type);
		
		ea4.addCollaboration(ea4group);
		eb4.addCollaboration(eb4group);
		ec4.addCollaboration(ec4group);
		
		group4.addCollaboration(groupEc4);
		group4.addCollaboration(groupEb4);
		group4.addCollaboration(groupEa4);
		
		ea4.createDelta(ea4);
		
		assertEquals(ea4.getDelta().size(), group4.getDelta().size());
		assertEquals(group4.getDelta().size(), ec4.getDelta().size());
		assertEquals(group4.getDelta().size(), eb4.getDelta().size());
		
		
	}
	
	@Test
	public void groupTest5() 
	{
		Engineer__Ws ea5 = new Engineer__Ws();
		Engineer__Ws eb5 = new Engineer__Ws();
		ea5.setName("Alice");
		eb5.setName("Bob");
		
		Group_Ws group5 = new Group_Ws();
		group5.setName("GroupAliceBob");
		
		Collaboration ea5group = new Collaboration();
		ea5group.setSender(ea5);
		ea5group.setReceiver(group5);
		CollaborationType ct5a = ea5group.selectType("Instant");
		ea5group.setType(ct5a);
		
		Collaboration groupEa5 = new Collaboration();
		groupEa5.setSender(group5);
		groupEa5.setReceiver(ea5);
		CollaborationType ct5b = groupEa5.selectType("Triggered");
		groupEa5.setType(ct5b);
		
		Collaboration eb5group = new Collaboration();
		eb5group.setSender(eb5);
		eb5group.setReceiver(group5);
		eb5group.setType(ct5a);
		
		Collaboration groupEb5 = new Collaboration();
		groupEb5.setSender(group5);
		groupEb5.setReceiver(eb5);
		groupEb5.setType(ct5b);
		
		ea5.addCollaboration(ea5group);
		eb5.addCollaboration(eb5group);
		
		group5.addCollaboration(groupEb5);
		group5.addCollaboration(groupEa5);
		
		ea5.createDelta(ea5);
		
		assertEquals(ea5.getDelta(), group5.getDelta());
		Trigger t5 = new Trigger();
		t5.setSender(ea5);
		
		Trigger t5group = new Trigger();
		t5group.setSender(eb5);
		
		group5.triggerGroup(t5group);
		
		assertEquals(group5.getDelta(), eb5.getDelta());
		
	}
	
	@Test
	public void groupTest6() 
	{
		Engineer__Ws ea6 = new Engineer__Ws();
		Engineer__Ws eb6 = new Engineer__Ws();
		ea6.setName("Alice");
		eb6.setName("Bob");
		
		Group_Ws group6 = new Group_Ws();
		group6.setName("GroupAliceBob");
		
		Collaboration ea6group = new Collaboration();
		ea6group.setSender(ea6);
		ea6group.setReceiver(group6);
		CollaborationType ct5a = ea6group.selectType("Triggered");
		ea6group.setType(ct5a);
		
		Collaboration groupEa6 = new Collaboration();
		groupEa6.setSender(group6);
		groupEa6.setReceiver(ea6);
		CollaborationType ct5b = groupEa6.selectType("Instant");
		groupEa6.setType(ct5b);
		
		Collaboration eb6group = new Collaboration();
		eb6group.setSender(eb6);
		eb6group.setReceiver(group6);
		eb6group.setType(ct5a);
		
		Collaboration groupEb6 = new Collaboration();
		groupEb6.setSender(group6);
		groupEb6.setReceiver(eb6);
		groupEb6.setType(ct5b);
		
		ea6.addCollaboration(ea6group);
		eb6.addCollaboration(eb6group);
		
		group6.addCollaboration(groupEb6);
		group6.addCollaboration(groupEa6);
		
		ea6.createDelta(ea6);
		
		
		Trigger t6 = new Trigger();
		t6.setSender(ea6);
		ea6.trigger(t6);
		
		assertEquals(ea6.getDelta(), group6.getDelta());
		assertEquals(group6.getDelta(), eb6.getDelta());
	}
	
	@Test
	public void groupTest7() 
	{
		Engineer__Ws ea7 = new Engineer__Ws();
		Engineer__Ws eb7 = new Engineer__Ws();
		Engineer__Ws ec7 = new Engineer__Ws();
		ea7.setName("Alice");
		eb7.setName("Bob");
		ec7.setName("Charlie");
		
		Group_Ws group7 = new Group_Ws();
		group7.setName("GroupAliceBobCharlie");
		
		Collaboration ea7group = new Collaboration();
		ea7group.setSender(ea7);
		ea7group.setReceiver(group7);
		CollaborationType ct7a = ea7group.selectType("Instant");
		ea7group.setType(ct7a);
		
		Collaboration groupEa7 = new Collaboration();
		groupEa7.setSender(group7);
		groupEa7.setReceiver(ea7);
		CollaborationType ct7b = groupEa7.selectType("Triggered");
		groupEa7.setType(ct7b);
		
		Collaboration eb7group = new Collaboration();
		eb7group.setSender(eb7);
		eb7group.setReceiver(group7);
		eb7group.setType(ct7a);
		
		Collaboration groupEb7 = new Collaboration();
		groupEb7.setSender(group7);
		groupEb7.setReceiver(eb7);
		groupEb7.setType(ct7b);
		
		Collaboration ec7group = new Collaboration();
		ec7group.setSender(ec7);
		ec7group.setReceiver(group7);
		ec7group.setType(ct7a);
		
		Collaboration groupEc7 = new Collaboration();
		groupEc7.setSender(group7);
		groupEc7.setReceiver(ec7);
		groupEc7.setType(ct7b);
		
		
		ea7.addCollaboration(ea7group);
		eb7.addCollaboration(eb7group);
		ec7.addCollaboration(ec7group);
		
		group7.addCollaboration(groupEc7);
		group7.addCollaboration(groupEb7);
		group7.addCollaboration(groupEa7);
		
		ea7.createDelta(ea7);
		
		assertEquals(ea7.getDelta(), group7.getDelta());
		assertNotEquals(group7.getDelta(), eb7.getDelta());
		assertNotEquals(group7.getDelta(), ec7.getDelta());
		
		Trigger t7 = new Trigger();
		t7.setSender(ea7);
		
		Trigger t7groupEb7 = new Trigger();
		t7groupEb7.setSender(eb7);
		
		Trigger t7groupEc7 = new Trigger();
		t7groupEc7.setSender(ec7);
		
		group7.triggerGroup(t7groupEb7);
		assertEquals(group7.getDelta(), eb7.getDelta());
		group7.triggerGroup(t7groupEc7);
		assertEquals(group7.getDelta(), ec7.getDelta());
	}
	
	@Test
	public void groupTest8() 
	{
		Engineer__Ws ea8 = new Engineer__Ws();
		Engineer__Ws eb8 = new Engineer__Ws();
		Engineer__Ws ec8 = new Engineer__Ws();
		ea8.setName("Alice");
		eb8.setName("Bob");
		ec8.setName("Charlie");
		
		Group_Ws group8 = new Group_Ws();
		group8.setName("GroupAliceBobCharlie");
		
		Collaboration ea8group = new Collaboration();
		ea8group.setSender(ea8);
		ea8group.setReceiver(group8);
		CollaborationType ct8a = ea8group.selectType("Triggered");
		ea8group.setType(ct8a);
		
		Collaboration groupEa8 = new Collaboration();
		groupEa8.setSender(group8);
		groupEa8.setReceiver(ea8);
		CollaborationType ct8b = groupEa8.selectType("Instant");
		groupEa8.setType(ct8b);
		
		Collaboration eb8group = new Collaboration();
		eb8group.setSender(eb8);
		eb8group.setReceiver(group8);
		eb8group.setType(ct8a);
		
		Collaboration groupEb8 = new Collaboration();
		groupEb8.setSender(group8);
		groupEb8.setReceiver(eb8);
		groupEb8.setType(ct8b);
		
		Collaboration ec8group = new Collaboration();
		ec8group.setSender(ec8);
		ec8group.setReceiver(group8);
		ec8group.setType(ct8a);
		
		Collaboration groupEc8 = new Collaboration();
		groupEc8.setSender(group8);
		groupEc8.setReceiver(ec8);
		groupEc8.setType(ct8b);
		
		ea8.addCollaboration(ea8group);
		eb8.addCollaboration(eb8group);
		ec8.addCollaboration(ec8group);
		
		group8.addCollaboration(groupEc8);
		group8.addCollaboration(groupEb8);
		group8.addCollaboration(groupEa8);
		
		ea8.createDelta(ea8);
		
		assertNotEquals(ea8.getDelta(), group8.getDelta());
		
		//ksekina metafora dedomenwn.
		
		Trigger t8 = new Trigger();
		t8.setSender(ea8);
		
		ea8.trigger(t8);
		
		assertEquals(ea8.getDelta(), group8.getDelta());
		assertEquals(ea8.getDelta(), eb8.getDelta());
		assertEquals(ea8.getDelta(), ec8.getDelta());
		assertEquals(group8.getDelta(), eb8.getDelta());
		
	}
	
	@Test
	public void groupTest9() 
	{
		Engineer__Ws ea9 = new Engineer__Ws();
		Engineer__Ws eb9 = new Engineer__Ws();
		Engineer__Ws ec9 = new Engineer__Ws();
		ea9.setName("Alice");
		eb9.setName("Bob");
		ec9.setName("Charlie");
		
		Group_Ws group9 = new Group_Ws();
		group9.setName("GroupAliceBobCharlie");
		
		Collaboration ea9group = new Collaboration();
		ea9group.setSender(ea9);
		ea9group.setReceiver(group9);
		CollaborationType ct9a = ea9group.selectType("Triggered");
		ea9group.setType(ct9a);
		
		Collaboration groupEa9 = new Collaboration();
		groupEa9.setSender(group9);
		groupEa9.setReceiver(ea9);
		groupEa9.setType(ct9a);
		
		Collaboration eb9group = new Collaboration();
		eb9group.setSender(eb9);
		eb9group.setReceiver(group9);
		CollaborationType ct9b = eb9group.selectType("Instant");
		eb9group.setType(ct9b);
		
		Collaboration groupEb9 = new Collaboration();
		groupEb9.setSender(group9);
		groupEb9.setReceiver(eb9);
		groupEb9.setType(ct9b);
		
		Collaboration ec9group = new Collaboration();
		ec9group.setSender(ec9);
		ec9group.setReceiver(group9);
		ec9group.setType(ct9a);
		
		Collaboration groupEc9 = new Collaboration();
		groupEc9.setSender(group9);
		groupEc9.setReceiver(ec9);
		groupEc9.setType(ct9a);
		
		ea9.addCollaboration(ea9group);
		eb9.addCollaboration(eb9group);
		ec9.addCollaboration(ec9group);
		
		group9.addCollaboration(groupEa9);
		group9.addCollaboration(groupEb9);
		group9.addCollaboration(groupEc9);
		
		
		//Adding the change creation and the transfer of data.
		
		ea9.createDelta(ea9);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(1,ea9.getDelta().size());
		assertEquals(group9.getDelta(), eb9.getDelta());
		assertEquals(group9.getDelta(), ec9.getDelta());
		
		eb9.createDelta(eb9);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(1,ea9.getDelta().size());
		assertEquals(group9.getDelta(), eb9.getDelta());
		assertEquals(group9.getDelta().size(), eb9.getDelta().size());
		assertNotEquals(group9.getDelta(), ec9.getDelta());
		
		ec9.createDelta(ec9);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(1,ea9.getDelta().size());
		assertEquals(group9.getDelta(), eb9.getDelta());
		assertEquals(group9.getDelta().size(), eb9.getDelta().size());
		assertNotEquals(group9.getDelta(), ec9.getDelta());
		
		Trigger t9a = new Trigger();
		t9a.setSender(ea9);
		
		ea9.trigger(t9a);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(1,ea9.getDelta().size());
		assertEquals(2,group9.getDelta().size());
		assertEquals(group9.getDelta().size(), eb9.getDelta().size());
		assertNotEquals(group9.getDelta(), ec9.getDelta());
		
		Trigger t9c = new Trigger();
		t9c.setSender(ec9);
		
		ec9.trigger(t9c);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(1,ea9.getDelta().size());
		assertEquals(3,group9.getDelta().size());
		assertEquals(group9.getDelta(), eb9.getDelta());
		assertNotEquals(group9.getDelta(), ec9.getDelta());
		
		group9.triggerGroup(t9a);
		
		assertNotEquals(ea9.getDelta(), group9.getDelta());
		assertEquals(3,ea9.getDelta().size());
		assertEquals(3,group9.getDelta().size());
		assertEquals(group9.getDelta().size(), eb9.getDelta().size());
		
		Trigger t9groupEc9 = new Trigger();
		t9groupEc9.setSender(ec9);
		
		group9.triggerGroup(t9groupEc9);
		
		assertEquals(group9.getDelta().size(), ec9.getDelta().size());
	}
	
	@Test
	public void HierarchyTest1() 
	{
		Engineer__Ws ea1 = new Engineer__Ws();
		Engineer__Ws eb1 = new Engineer__Ws();
		ea1.setName("Alice");
		eb1.setName("Bob");
		
		ea1.setParentWs(eb1);
		
		ea1.createDelta(ea1);
		
		ea1.publishToWorkspace();
		
		assertEquals(ea1.getDelta(), eb1.getDelta());
	}
	
	@Test
	public void HierarchyTest2() 
	{
		Engineer__Ws ea2 = new Engineer__Ws();
		Engineer__Ws eb2 = new Engineer__Ws();
		Engineer__Ws ec2 = new Engineer__Ws();
		ea2.setName("Alice");
		eb2.setName("Bob");
		ec2.setName("Charlie");
		
		ea2.setParentWs(eb2);
		eb2.setParentWs(ec2);
		
		ea2.createDelta(ea2);
		
		ea2.publishToWorkspace();
		assertEquals(ea2.getDelta(), eb2.getDelta());
		assertNotEquals(ea2.getDelta(), ec2.getDelta());
		assertNotEquals(eb2.getDelta(), ec2.getDelta());
		
		eb2.createDelta(eb2);
		assertNotEquals(ea2.getDelta(), eb2.getDelta());
		assertNotEquals(ea2.getDelta(), ec2.getDelta());
		assertNotEquals(eb2.getDelta(), ec2.getDelta());
		
		eb2.publishToWorkspace();
		assertNotEquals(ea2.getDelta(), eb2.getDelta());
		assertNotEquals(ea2.getDelta(), ec2.getDelta());
		assertEquals(eb2.getDelta(), ec2.getDelta());
		assertEquals(2, ec2.getDelta().size());
		
	}
	
	@Test
	public void HierarchyTest3() 
	{
		Engineer__Ws ea3 = new Engineer__Ws();
		Engineer__Ws eb3 = new Engineer__Ws();
		Engineer__Ws ec3 = new Engineer__Ws();
		ea3.setName("Alice");
		eb3.setName("Bob");
		ec3.setName("Charlie");
		
		ea3.setParentWs(eb3);
		eb3.setParentWs(ec3);
		
		ea3.createDelta(ea3);
		eb3.createDelta(eb3);
		
		assertNotEquals(ea3.getDelta(), eb3.getDelta());
		assertEquals(ea3.getDelta().size(), eb3.getDelta().size());
		
		eb3.publishToWorkspace();
		assertEquals(eb3.getDelta(), ec3.getDelta());
		assertNotEquals(ea3.getDelta(), ec3.getDelta());
		assertEquals(ea3.getDelta().size(), ec3.getDelta().size());
		
		ea3.publishToWorkspace();
		assertEquals(2, eb3.getDelta().size());
		assertNotEquals(ec3.getDelta(), eb3.getDelta());
		assertNotEquals(ec3.getDelta().size(), eb3.getDelta().size());
		
		eb3.publishToWorkspace();
		assertEquals(ec3.getDelta().size(), eb3.getDelta().size());
		
	}

}
