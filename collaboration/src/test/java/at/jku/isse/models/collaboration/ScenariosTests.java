package at.jku.isse.models.collaboration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import atoms.Collaboration;
import atoms.CollaborationType;
import atoms.Engineer__Ws;
import atoms.Trigger;

public class ScenariosTests{
	
	@Test
	public void Scenario1()
	{
		//ALICE -> BOB Triggered 
		Engineer__Ws ea1 = new Engineer__Ws(); //Lifeline 1
		Engineer__Ws eb1 = new Engineer__Ws(); //Lifeline 2
		ea1.setName("Alice");
		eb1.setName("Bob");

		Collaboration c1 = ea1.createCollaboration(); //Lifeline 3
		c1.setSender(ea1);
		c1.setReceiver(eb1);
		CollaborationType ct1 = c1.selectType("Triggered");
		c1.setType(ct1);
		
		ea1.addCollaboration(c1);
		eb1.addCollaboration(c1);
		
		Trigger t1 = new Trigger(); //LifeLine 4
		t1.setSender(ea1);
		
		ea1.createDelta(ea1); //Lifeline 5
			
		ea1.trigger(t1);
		
		assertEquals(ea1.getDelta(),eb1.getDelta());
		
		
		
	}
	
	@Test
	public void Scenario2()
	{
		//ALICE -> BOB INSTANT
		Engineer__Ws ea2 = new Engineer__Ws();
		Engineer__Ws eb2 = new Engineer__Ws();
		ea2.setName("Alice");
		eb2.setName("Bob");
		
		Collaboration c2 = ea2.createCollaboration();
		c2.setSender(ea2);
		c2.setReceiver(eb2);
		CollaborationType ct2 = c2.selectType("Instant");
		c2.setType(ct2);
		
		ea2.addCollaboration(c2);
		eb2.addCollaboration(c2);
		
		ea2.createDelta(ea2);
		
		assertEquals(ea2.getDelta(), eb2.getDelta());
	}
	
	@Test
	public void Scenario3()
	{
		Engineer__Ws ea3 = new Engineer__Ws();
		Engineer__Ws eb3 = new Engineer__Ws();
		ea3.setName("Alice");
		eb3.setName("Bob");
		
		Collaboration c3 = ea3.createCollaboration();
		c3.setSender(ea3);
		c3.setReceiver(eb3);
		CollaborationType ct3 = c3.selectType("Triggered");
		c3.setType(ct3);
		
		ea3.addCollaboration(c3);
		eb3.addCollaboration(c3);
		
		ea3.createDelta(ea3);
		
		assertEquals(0, eb3.getDelta().size());
	}
	
	@Test
	public void Scenario4() 
	{
		Engineer__Ws ea4 = new Engineer__Ws();
		Engineer__Ws eb4 = new Engineer__Ws();
		ea4.setName("Alice");
		eb4.setName("Bob");
		
		Collaboration c4 = ea4.createCollaboration();
		c4.setSender(ea4);
		c4.setReceiver(eb4);
		CollaborationType ct4 = c4.selectType("Instant");
		c4.setType(ct4);
		
		assertEquals(0, eb4.getDelta().size());
	}
	
	@Test
	public void Scenario5()
	{
		Engineer__Ws ea5 = new Engineer__Ws();
		Engineer__Ws eb5 = new Engineer__Ws();
		Engineer__Ws ec5 = new Engineer__Ws();
		ea5.setName("Alice");
		eb5.setName("Bob");
		ec5.setName("Charlie");
		
		Collaboration cab5 = ea5.createCollaboration();
		cab5.setSender(ea5);
		cab5.setReceiver(eb5);
		CollaborationType ct5 = cab5.selectType("Triggered");
		cab5.setType(ct5);
		
		Collaboration cac5 = eb5.createCollaboration();
		cac5.setSender(ea5);
		cac5.setReceiver(ec5);
		cac5.setType(ct5);
		
		ea5.addCollaboration(cab5);
		ea5.addCollaboration(cac5);
		
		eb5.addCollaboration(cab5);
		ec5.addCollaboration(cac5);
		
		Trigger t5 = new Trigger();
		t5.setSender(ea5);
		
		ea5.createDelta(ea5);
		
		ea5.trigger(t5);
		
		assertEquals(ea5.getDelta(), eb5.getDelta());
		assertEquals(ea5.getDelta(), ec5.getDelta());
		
	}
	
	@Test
	public void Scenario6()
	{
		Engineer__Ws ea6 = new Engineer__Ws(); //Lifeline 1
		Engineer__Ws eb6 = new Engineer__Ws(); //Lifeline 2
		ea6.setName("Alice");
		eb6.setName("Bob");
		
		Collaboration c6 = ea6.createCollaboration(); //Lifeline 3
		c6.setSender(ea6);
		c6.setReceiver(eb6);
		CollaborationType ct6 = c6.selectType("Triggered");
		c6.setType(ct6);
		
		ea6.addCollaboration(c6);
		eb6.addCollaboration(c6);
		
		Trigger t6 = new Trigger(); //LifeLine 4
		t6.setSender(eb6);
		
		ea6.createDelta(ea6); //Lifeline 5
		eb6.trigger(t6);
		
		assertEquals(0,eb6.getDelta().size());
	}
	
	@Test
	public void Scenario7() 
	{
		Engineer__Ws ea7 = new Engineer__Ws();
		Engineer__Ws eb7 = new Engineer__Ws();
		Engineer__Ws ec7 = new Engineer__Ws();
		ea7.setName("Alice");
		eb7.setName("Bob");
		ec7.setName("Charlie");
		
		Collaboration cab7 = ea7.createCollaboration();
		cab7.setSender(ea7);
		cab7.setReceiver(eb7);
		CollaborationType ct7 = cab7.selectType("Triggered");
		cab7.setType(ct7);
		
		ea7.addCollaboration(cab7);
		eb7.addCollaboration(cab7);
		
		Collaboration cbc7 = eb7.createCollaboration();
		cbc7.setSender(eb7);
		cbc7.setReceiver(ec7);
		cbc7.setType(ct7);
		
		eb7.addCollaboration(cbc7);
		ec7.addCollaboration(cbc7);
		
		ea7.createDelta(ea7);
		eb7.createDelta(eb7);
		
		Trigger tb7 = new Trigger();
		tb7.setSender(eb7);
		
		eb7.trigger(tb7);
		
		assertEquals(eb7.getDelta(), ec7.getDelta());
		assertNotEquals(ea7.getDelta(), eb7.getDelta());
		
	}
	
	@Test
	public void Scenario8()
	{
		Engineer__Ws ea8 = new Engineer__Ws();
		Engineer__Ws eb8 = new Engineer__Ws();
		
		ea8.setName("Alice");
		eb8.setName("Bob");
		
		Collaboration cab8 = ea8.createCollaboration();
		cab8.setSender(ea8);
		cab8.setReceiver(eb8);
		CollaborationType ct8 = cab8.selectType("Triggered");
		cab8.setType(ct8);
		
		ea8.addCollaboration(cab8);
		eb8.addCollaboration(cab8);
		
		Trigger ta8 = new Trigger();
		ta8.setSender(ea8);
		
		ea8.trigger(ta8);
		
		assertEquals(0, eb8.getDelta().size());
		
		ea8.createDelta(ea8);
		
		ea8.trigger(ta8);
		
		assertEquals(ea8.getDelta(), eb8.getDelta());
	}
	
	@Test
	public void Scenario9() 
	{
		Engineer__Ws ea9 = new Engineer__Ws();
		Engineer__Ws eb9 = new Engineer__Ws();
		Engineer__Ws ec9 = new Engineer__Ws();
		
		ea9.setName("Alice");
		eb9.setName("Bob");
		ec9.setName("Charlie");
		
		Collaboration cab9 = ea9.createCollaboration();
		cab9.setSender(ea9);
		cab9.setReceiver(eb9);
		CollaborationType ctTr = cab9.selectType("Triggered");
		cab9.setType(ctTr);
		
		ea9.addCollaboration(cab9);
		eb9.addCollaboration(cab9);
		
		Collaboration cac9 = ea9.createCollaboration();
		cac9.setSender(ea9);
		cac9.setReceiver(ec9);
		CollaborationType ctIn = cac9.selectType("Instant");
		cac9.setType(ctIn);
		
		ea9.addCollaboration(cac9);
		ec9.addCollaboration(cac9);
		
		ea9.createDelta(ea9);
		
		assertEquals(ea9.getDelta(), ec9.getDelta());
		assertNotEquals(ea9.getDelta(), eb9.getDelta());
		
		Trigger ct9 = new Trigger();
		ct9.setSender(ea9);
		
		ea9.trigger(ct9);
		
		assertEquals(ea9.getDelta(), eb9.getDelta());	
		
	}
	
	@Test
	public void Scenario10() 
	{
		Engineer__Ws ea10 = new Engineer__Ws();
		Engineer__Ws eb10 = new Engineer__Ws();
		ea10.setName("Alice");
		eb10.setName("Bob");
		
		Collaboration c10ab = ea10.createCollaboration();
		c10ab.setSender(ea10);
		c10ab.setReceiver(eb10);
		CollaborationType ct10ab = c10ab.selectType("Instant");
		c10ab.setType(ct10ab);
		
		ea10.addCollaboration(c10ab);
		eb10.addCollaboration(c10ab);
		
		ea10.createDelta(ea10);
		
//		for(Object x: LogGraphics.getGraphicsLog().values()) 
//		{
//			System.out.println(x.toString());
//		}
		
		assertEquals(ea10.getDelta(), eb10.getDelta());
		
		Collaboration c10ba = eb10.createCollaboration();
		c10ba.setSender(eb10);
		c10ba.setReceiver(ea10);
		CollaborationType ct10ba = c10ba.selectType("Instant");
		c10ab.setType(ct10ba);
		
		eb10.addCollaboration(c10ba);
		ea10.addCollaboration(c10ba);
		eb10.createDelta(eb10);
		
		assertEquals(eb10.getDelta(), ea10.getDelta());
	}
	
	@Test
	public void Scenario11() 
	{
		Engineer__Ws ea11 = new Engineer__Ws();
		Engineer__Ws eb11 = new Engineer__Ws();
		Engineer__Ws ec11 = new Engineer__Ws();
		
		Collaboration c11ab = ea11.createCollaboration();
		c11ab.setSender(ea11);
		c11ab.setReceiver(eb11);
		CollaborationType ct11ab = c11ab.selectType("Triggered");
		c11ab.setType(ct11ab);
		
		ea11.addCollaboration(c11ab);
		eb11.addCollaboration(c11ab);
		
		Collaboration c11ac = ea11.createCollaboration();
		c11ac.setSender(ea11);
		c11ac.setReceiver(ec11);
		CollaborationType ct11ac = c11ac.selectType("Instant");
		c11ac.setType(ct11ac);
		
		Collaboration c11cb = ec11.createCollaboration();
		c11cb.setSender(ec11);
		c11cb.setReceiver(eb11);
		CollaborationType ct11cb = c11cb.selectType("Triggered");
		c11cb.setType(ct11cb);
		
		ea11.addCollaboration(c11ab);
		ea11.addCollaboration(c11ac);
		
		eb11.addCollaboration(c11ab);
		eb11.addCollaboration(c11cb);
		
		ec11.addCollaboration(c11ac);
		ec11.addCollaboration(c11cb);
		
		ea11.createDelta(ea11);
		
		assertEquals(ea11.getDelta(), ec11.getDelta());
		assertEquals(0, eb11.getDelta().size());
		
		Trigger t11ab = new Trigger();
		t11ab.setSender(ea11);
		
		ea11.trigger(t11ab);
		
		assertEquals(ea11.getDelta(), eb11.getDelta());
		
		ec11.createDelta(ec11);
		
		assertNotEquals(ec11.getDelta(), eb11.getDelta());
		
		Trigger t11cb = new Trigger();
		t11cb.setSender(ec11);
		
		ec11.trigger(t11cb);
		
		assertEquals(ec11.getDelta(), eb11.getDelta());
		
		ec11.trigger(t11cb);
		
	}
	
	@Test
	public void Scenario12() 
	{
		Engineer__Ws ea12 = new Engineer__Ws();
		Engineer__Ws eb12 = new Engineer__Ws();
		Engineer__Ws ec12 = new Engineer__Ws();
		
		ea12.setName("Alice");
		eb12.setName("Bob");
		ec12.setName("Charlie");
		
		Collaboration c12ba = new Collaboration();
		c12ba.setSender(eb12);
		c12ba.setReceiver(ea12);
		CollaborationType ct12ba = c12ba.selectType("Triggered");
		c12ba.setType(ct12ba);
		
		eb12.addCollaboration(c12ba);
		ea12.addCollaboration(c12ba);
		
		Collaboration c12ab = new Collaboration();
		c12ab.setSender(ea12);
		c12ab.setReceiver(eb12);
		CollaborationType ct12ab = c12ab.selectType("Instant");
		c12ab.setType(ct12ab);
		
		eb12.addCollaboration(c12ab);
		ea12.addCollaboration(c12ab);
		
		Collaboration c12bc = new Collaboration();
		c12bc.setSender(eb12);
		c12bc.setReceiver(ec12);
		CollaborationType ct12bc = c12bc.selectType("Instant");
		c12bc.setType(ct12bc);
		
		eb12.addCollaboration(c12bc);
		ec12.addCollaboration(c12bc);
		
		Collaboration c12ca = new Collaboration();
		c12ca.setSender(ec12);
		c12ca.setReceiver(ea12);
		CollaborationType ct12ca = c12ca.selectType("Triggered");
		c12ca.setType(ct12ca);
		
		ec12.addCollaboration(c12ca);
		ea12.addCollaboration(c12ca);
		
		//Create Communications
		
		eb12.createDelta(eb12);
		
		assertEquals(eb12.getDelta(), ec12.getDelta());
		assertEquals(0, ea12.getDelta().size());
		
		ec12.createDelta(ec12);
		
		assertNotEquals(ec12.getDelta(), eb12.getDelta());
		assertEquals(0, ea12.getDelta().size());
		
		Trigger t12ba = new Trigger();
		t12ba.setSender(eb12);
		
		eb12.trigger(t12ba);
		
		assertEquals(eb12.getDelta(), ea12.getDelta());
		assertEquals(2, ec12.getDelta().size());
	}
	
	@Test
	public void Scenario13()
	{
		//NO CYCLIC A->B->C
		Engineer__Ws ea13 = new Engineer__Ws();
		Engineer__Ws eb13 = new Engineer__Ws();
		Engineer__Ws ec13 = new Engineer__Ws();
		
		ea13.setName("Alice");
		eb13.setName("Bob");
		ec13.setName("Charlie");
		
		Collaboration c13ab = new Collaboration();
		c13ab.setSender(ea13);
		c13ab.setReceiver(eb13);
		CollaborationType ct13ab = c13ab.selectType("Triggered");
		c13ab.setType(ct13ab);
		
		ea13.addCollaboration(c13ab);
		eb13.addCollaboration(c13ab);
		
		Collaboration c13bc = new Collaboration();
		c13bc.setSender(eb13);
		c13bc.setReceiver(ec13);
		c13bc.setType(ct13ab);
		
		eb13.addCollaboration(c13bc);
		ec13.addCollaboration(c13bc);
		
		ea13.createDelta(ea13);
		
		Trigger t13ab = new Trigger();
		t13ab.setSender(ea13);
		
		Trigger t13bc = new Trigger();
		t13bc.setSender(eb13);
		
		eb13.createDelta(eb13);
		
		assertNotEquals(ea13.getDelta(), eb13.getDelta());
		assertEquals(0, ec13.getDelta().size());
		
		ea13.trigger(t13ab);
		
		assertNotEquals(ea13.getDelta(), eb13.getDelta());
		assertEquals(0, ec13.getDelta().size());
		
		eb13.trigger(t13bc);
		
		assertNotEquals(eb13.getDelta(), ec13.getDelta());//This is equal without the creators restriction
		assertNotEquals(ec13.getDelta(), ea13.getDelta());
		
		assertEquals(1, ea13.getDelta().size());
		assertEquals(2, eb13.getDelta().size());
		assertEquals(1, ec13.getDelta().size());//This becomes 2 because of B passing its own 		
		
	}
	
	@Test
	public void Scenario14() 
	{
		Engineer__Ws ea14 = new Engineer__Ws();
		Engineer__Ws eb14 = new Engineer__Ws();
		Engineer__Ws ec14 = new Engineer__Ws();
		
		ea14.setName("Alice");
		eb14.setName("Bob");
		ec14.setName("Charlie");
		
		Collaboration c14ab = new Collaboration();
		c14ab.setSender(ea14);
		c14ab.setReceiver(eb14);
		CollaborationType t14 = c14ab.selectType("Triggered");
		c14ab.setType(t14);
		
		ea14.addCollaboration(c14ab);
		eb14.addCollaboration(c14ab);
		
		Collaboration c14cb = new Collaboration();
		c14cb.setSender(ec14);
		c14cb.setReceiver(eb14);
		c14cb.setType(t14);
		
		eb14.addCollaboration(c14cb);
		ec14.addCollaboration(c14cb);
		
		ea14.createDelta(ea14);
		ec14.createDelta(ec14);
		
		assertEquals(0, eb14.getDelta().size());
		
		Trigger t14ab = new Trigger();
		t14ab.setSender(ea14);
		
		Trigger t14cb = new Trigger();
		t14cb.setSender(ec14);
		
		ea14.trigger(t14ab);
		
		assertEquals(ea14.getDelta(), eb14.getDelta());
		assertNotEquals(ea14.getDelta(), ec14.getDelta());
		assertNotEquals(ec14.getDelta(),eb14.getDelta());
		
		ec14.trigger(t14cb);
		assertEquals(2, eb14.getDelta().size());
		
		eb14.createDelta(eb14);
		System.out.println("Expected Misconfiguration Message Following");
		Trigger t14b = new Trigger();
		t14b.setSender(eb14);
		
		eb14.trigger(t14b);
		
		assertEquals(1, ea14.getDelta().size());
		
	}
	
	@Test
	public void Scenario15() 
	{
		Engineer__Ws ea15 = new Engineer__Ws();
		Engineer__Ws eb15 = new Engineer__Ws();
		Engineer__Ws ec15 = new Engineer__Ws();
		
		ea15.setName("Alice");
		eb15.setName("Bob");
		ec15.setName("Charlie");
		
		Collaboration c15ba = new Collaboration();
		c15ba.setSender(eb15);
		c15ba.setReceiver(ea15);
		CollaborationType ct15 = c15ba.selectType("Triggered");
		c15ba.setType(ct15);
		
		ea15.addCollaboration(c15ba);
		eb15.addCollaboration(c15ba);
		
		Collaboration c15bc = new Collaboration();
		c15bc.setSender(eb15);
		c15bc.setReceiver(ec15);
		c15bc.setType(ct15);
		
		ec15.addCollaboration(c15bc);
		eb15.addCollaboration(c15bc);
		
		eb15.createDelta(eb15);
		eb15.createDelta(eb15);
		
		Trigger t15b = new Trigger();
		t15b.setSender(eb15);
		
		eb15.trigger(t15b);
		
		assertEquals(eb15.getDelta(), ea15.getDelta());
		assertEquals(eb15.getDelta(), ec15.getDelta());
		assertEquals(ea15.getDelta(), ec15.getDelta());
	}
	
	@Test
	public void Scenario16() 
	{
		Engineer__Ws ea16 = new Engineer__Ws();
		Engineer__Ws eb16 = new Engineer__Ws();
		Engineer__Ws ec16 = new Engineer__Ws();
		
		ea16.setName("Alice");
		eb16.setName("Bob");
		ec16.setName("Charlie");
		
		Collaboration c16ab = new Collaboration();
		c16ab.setSender(ea16);
		c16ab.setReceiver(eb16);
		CollaborationType ct16 = c16ab.selectType("Triggered");
		c16ab.setType(ct16);
		
		ea16.addCollaboration(c16ab);
		eb16.addCollaboration(c16ab);
		
		Collaboration c16bc = new Collaboration();
		c16bc.setSender(eb16);
		c16bc.setReceiver(ec16);
		c16bc.setType(ct16);
		
		eb16.addCollaboration(c16bc);
		ec16.addCollaboration(c16bc);
		
		Collaboration c16ca = new Collaboration();
		c16ca.setSender(ec16);
		c16ca.setReceiver(ea16);
		c16ca.setType(ct16);
		
		ec16.addCollaboration(c16ca);
		ea16.addCollaboration(c16ca);
		
		ea16.createDelta(ea16);
		eb16.createDelta(eb16);
		ec16.createDelta(ec16);
		
		Trigger t16ab = new Trigger();
		Trigger t16bc = new Trigger();
		Trigger t16ca = new Trigger();
		
		t16ab.setSender(ea16);
		t16bc.setSender(eb16);
		t16ca.setSender(ec16);
		
		ea16.trigger(t16ab);
		assertEquals(1, ea16.getDelta().size());
		assertEquals(2, eb16.getDelta().size());
		assertEquals(1,ec16.getDelta().size());
		
		eb16.trigger(t16bc);
		assertEquals(1, ea16.getDelta().size());
		assertEquals(2, eb16.getDelta().size());
		assertEquals(2,ec16.getDelta().size());
		
		ec16.trigger(t16ca);
		assertEquals(2, ea16.getDelta().size());
		assertEquals(2, eb16.getDelta().size());
		assertEquals(2,ec16.getDelta().size());
		
		assertNotEquals(ea16.getDelta(), eb16.getDelta());
		assertNotEquals(eb16.getDelta(),ec16.getDelta());
		assertNotEquals(ec16.getDelta(), ea16.getDelta());
	}
	
	@Test
	public void Scenario17() 
	{
		Engineer__Ws ea17 = new Engineer__Ws();
		Engineer__Ws eb17 = new Engineer__Ws();
		Engineer__Ws ec17 = new Engineer__Ws();
		
		ea17.setName("Alice");
		eb17.setName("Bob");
		ec17.setName("Charlie");
		
		Collaboration c17ab = new Collaboration();
		c17ab.setSender(ea17);
		c17ab.setReceiver(eb17);
		CollaborationType ct17 = c17ab.selectType("Triggered");
		c17ab.setType(ct17);
		
		ea17.addCollaboration(c17ab);
		eb17.addCollaboration(c17ab);
		
		Collaboration c17ac = new Collaboration();
		c17ac.setSender(ea17);
		c17ac.setReceiver(ec17);
		c17ac.setType(ct17);
		
		ea17.addCollaboration(c17ac);
		ec17.addCollaboration(c17ac);
		
		Collaboration c17cb = new Collaboration();
		c17cb.setSender(ec17);
		c17cb.setReceiver(eb17);
		c17cb.setType(ct17);
		
		ec17.addCollaboration(c17cb);
		eb17.addCollaboration(c17cb);
		
		ea17.createDelta(ea17);
		ec17.createDelta(ec17);
		
		Trigger t17a = new Trigger();
		t17a.setSender(ea17);
		
		Trigger t17cb = new Trigger();
		t17cb.setSender(ec17);
		
		ea17.trigger(t17a);
		
		assertEquals(1, ea17.getDelta().size());
		assertEquals(1, eb17.getDelta().size());
		assertEquals(2, ec17.getDelta().size());
		
		ec17.trigger(t17cb);
		assertEquals(1, ea17.getDelta().size());
		assertEquals(2, eb17.getDelta().size());
		assertEquals(2, ec17.getDelta().size());
				
	}
	
	@Test
	public void Scenario18() 
	{
		Engineer__Ws ea18 = new Engineer__Ws();
		Engineer__Ws eb18 = new Engineer__Ws();
		Engineer__Ws ec18 = new Engineer__Ws();
		
		ea18.setName("Alice");
		eb18.setName("Bob");
		ec18.setName("Charlie");
		
		Collaboration c18ab = new Collaboration();
		c18ab.setSender(ea18);
		c18ab.setReceiver(eb18);
		CollaborationType ct18 = c18ab.selectType("Triggered");
		c18ab.setType(ct18);
		
		ea18.addCollaboration(c18ab);
		eb18.addCollaboration(c18ab);
		
		Collaboration c18ba = new Collaboration();
		c18ba.setSender(eb18);
		c18ba.setReceiver(ea18);
		c18ba.setType(ct18);
		
		eb18.addCollaboration(c18ba);
		ea18.addCollaboration(c18ba);
		
		Collaboration c18cb = new Collaboration();
		c18cb.setSender(ec18);
		c18cb.setReceiver(eb18);
		c18cb.setType(ct18);
		
		ec18.addCollaboration(c18cb);
		eb18.addCollaboration(c18cb);
		
		ea18.createDelta(ea18);
		ec18.createDelta(ec18);
		
		Trigger t18a = new Trigger();
		t18a.setSender(ea18);
		
		Trigger t18cb = new Trigger();
		t18cb.setSender(ec18);
		
		ea18.trigger(t18a);
		
		assertEquals(1, ea18.getDelta().size());
		assertEquals(1, eb18.getDelta().size());
		assertEquals(1, ec18.getDelta().size());
		
		ec18.trigger(t18cb);
		assertEquals(1, ea18.getDelta().size());
		assertEquals(2, eb18.getDelta().size());
		assertEquals(1, ec18.getDelta().size());
		
		eb18.createDelta(eb18);
		
		Trigger t18ba = new Trigger();
		t18ba.setSender(eb18);
		
		eb18.trigger(t18ba);
		
		assertEquals(2, ea18.getDelta().size());
				
	}
	@Test
	public void Scenario19()
	{
		Engineer__Ws ea19 = new Engineer__Ws();
		Engineer__Ws eb19 = new Engineer__Ws();
		Engineer__Ws ec19 = new Engineer__Ws();
		
		ea19.setName("Alice");
		eb19.setName("Bob");
		ec19.setName("Charlie");
		
		Collaboration c19ab = new Collaboration();
		c19ab.setSender(ea19);
		c19ab.setReceiver(eb19);
		CollaborationType ct19 = c19ab.selectType("Triggered");
		c19ab.setType(ct19);
		
		ea19.addCollaboration(c19ab);
		eb19.addCollaboration(c19ab);
		
		Collaboration c19ba = new Collaboration();
		c19ba.setSender(eb19);
		c19ba.setReceiver(ea19);
		c19ba.setType(ct19);
		
		eb19.addCollaboration(c19ba);
		ea19.addCollaboration(c19ba);
		
		Collaboration c19bc = new Collaboration();
		c19bc.setSender(eb19);
		c19bc.setReceiver(ec19);
		c19bc.setType(ct19);
		
		ec19.addCollaboration(c19bc);
		eb19.addCollaboration(c19bc);
		
		ea19.createDelta(ea19);
		ec19.createDelta(ec19);
		
		Trigger t19a = new Trigger();
		t19a.setSender(ea19);
		
		ea19.trigger(t19a);
		
		assertEquals(1, ea19.getDelta().size());
		assertEquals(1, eb19.getDelta().size());
		assertEquals(1, ec19.getDelta().size());
		
		eb19.createDelta(eb19);
		
		Trigger t19ba = new Trigger();
		t19ba.setSender(eb19);
		
		eb19.trigger(t19ba);
		
		assertEquals(2, ec19.getDelta().size());
				
	}
	
	@Test
	public void Scenario20()
	{
		Engineer__Ws ea20 = new Engineer__Ws();
		Engineer__Ws eb20 = new Engineer__Ws();
		Engineer__Ws ec20 = new Engineer__Ws();
		
		ea20.setName("Alice");
		eb20.setName("Bob");
		ec20.setName("Charlie");
		
		Collaboration c20ab = new Collaboration();
		c20ab.setSender(ea20);
		c20ab.setReceiver(eb20);
		CollaborationType ct20 = c20ab.selectType("Triggered");
		c20ab.setType(ct20);
		
		ea20.addCollaboration(c20ab);
		eb20.addCollaboration(c20ab);
		
		Collaboration c20ba = new Collaboration();
		c20ba.setSender(eb20);
		c20ba.setReceiver(ea20);
		c20ba.setType(ct20);
		
		eb20.addCollaboration(c20ba);
		ea20.addCollaboration(c20ba);
		
		Collaboration c20bc = new Collaboration();
		c20bc.setSender(eb20);
		c20bc.setReceiver(ec20);
		c20bc.setType(ct20);
		
		ec20.addCollaboration(c20bc);
		eb20.addCollaboration(c20bc);
		
		Collaboration c20ca = new Collaboration();
		c20ca.setSender(ec20);
		c20ca.setReceiver(ea20);
		c20ca.setType(ct20);
		
		ec20.addCollaboration(c20ca);
		ea20.addCollaboration(c20ca);
		
		ea20.createDelta(ea20);
		ec20.createDelta(ec20);
		
		Trigger t20ab = new Trigger();
		t20ab.setSender(ea20);
		
		ea20.trigger(t20ab);
		
		Trigger t20ca = new Trigger();
		t20ca.setSender(ec20);
		
		ec20.trigger(t20ca);
		
		assertEquals(2, ea20.getDelta().size());
		assertEquals(1, eb20.getDelta().size());
		assertEquals(1, ec20.getDelta().size());
		
		eb20.createDelta(eb20);
		
		Trigger t20b = new Trigger();
		t20b.setSender(eb20);
		
		eb20.trigger(t20b);
		
		assertEquals(3, ea20.getDelta().size());
				
	}
	
	@Test
	public void Scenario21()
	{
		Engineer__Ws ea21 = new Engineer__Ws();
		Engineer__Ws eb21 = new Engineer__Ws();
		Engineer__Ws ec21 = new Engineer__Ws();
		
		ea21.setName("Alice");
		eb21.setName("Bob");
		ec21.setName("Charlie");
		
		Collaboration c21ab = new Collaboration();
		c21ab.setSender(ea21);
		c21ab.setReceiver(eb21);
		CollaborationType ct21 = c21ab.selectType("Triggered");
		c21ab.setType(ct21);
		
		ea21.addCollaboration(c21ab);
		eb21.addCollaboration(c21ab);
		
		Collaboration c21ba = new Collaboration();
		c21ba.setSender(eb21);
		c21ba.setReceiver(ea21);
		c21ba.setType(ct21);
		
		eb21.addCollaboration(c21ba);
		ea21.addCollaboration(c21ba);
		
		Collaboration c21cb = new Collaboration();
		c21cb.setSender(ec21);
		c21cb.setReceiver(eb21);
		c21cb.setType(ct21);
		
		ec21.addCollaboration(c21cb);
		eb21.addCollaboration(c21cb);
		
		Collaboration c21ca = new Collaboration();
		c21ca.setSender(ec21);
		c21ca.setReceiver(ea21);
		c21ca.setType(ct21);
		
		ec21.addCollaboration(c21ca);
		ea21.addCollaboration(c21ca);
		
		ea21.createDelta(ea21);
		ec21.createDelta(ec21);
		
		Trigger t21ab = new Trigger();
		t21ab.setSender(ea21);
		
		ea21.trigger(t21ab);
		
		Trigger t21ca = new Trigger();
		t21ca.setSender(ec21);
		
		ec21.trigger(t21ca);
		
		assertEquals(2, ea21.getDelta().size());
		assertEquals(2, eb21.getDelta().size());
		assertEquals(1, ec21.getDelta().size());
		
		eb21.createDelta(eb21);
		
		Trigger t21b = new Trigger();
		t21b.setSender(eb21);
		
		eb21.trigger(t21b);
		
		assertEquals(3, ea21.getDelta().size());
				
	}
	
	@Test
	public void Scenario22()
	{
		Engineer__Ws ea22 = new Engineer__Ws();
		Engineer__Ws eb22 = new Engineer__Ws();
		Engineer__Ws ec22 = new Engineer__Ws();
		
		ea22.setName("Alice");
		eb22.setName("Bob");
		ec22.setName("Charlie");
		
		Collaboration c22ab = new Collaboration();
		c22ab.setSender(ea22);
		c22ab.setReceiver(eb22);
		CollaborationType ct22 = c22ab.selectType("Triggered");
		c22ab.setType(ct22);
		
		ea22.addCollaboration(c22ab);
		eb22.addCollaboration(c22ab);
		
		Collaboration c22ba = new Collaboration();
		c22ba.setSender(eb22);
		c22ba.setReceiver(ea22);
		c22ba.setType(ct22);
		
		eb22.addCollaboration(c22ba);
		ea22.addCollaboration(c22ba);
		
		Collaboration c22bc = new Collaboration();
		c22bc.setSender(eb22);
		c22bc.setReceiver(ec22);
		c22bc.setType(ct22);
		
		ec22.addCollaboration(c22bc);
		eb22.addCollaboration(c22bc);
		
		Collaboration c22ac = new Collaboration();
		c22ac.setSender(ea22);
		c22ac.setReceiver(ec22);
		c22ac.setType(ct22);
		
		ec22.addCollaboration(c22ac);
		ea22.addCollaboration(c22ac);
		
		ea22.createDelta(ea22);
		ec22.createDelta(ec22);
		
		Trigger t22a = new Trigger();
		t22a.setSender(ea22);
		
		ea22.trigger(t22a);
		
//		Trigger t22c = new Trigger();
//		t22c.setSender(ec22);
//		
//		ec22.trigger(t22c);
		
		assertEquals(1, ea22.getDelta().size());
		assertEquals(1, eb22.getDelta().size());
		assertEquals(2, ec22.getDelta().size());
		
		eb22.createDelta(eb22);
		
		Trigger t22b = new Trigger();
		t22b.setSender(eb22);
		
		eb22.trigger(t22b);
		
		assertEquals(3, ec22.getDelta().size());
		assertEquals(2, eb22.getDelta().size());
				
	}
	
	@Test
	public void Scenario23()
	{
		Engineer__Ws ea23 = new Engineer__Ws();
		Engineer__Ws eb23 = new Engineer__Ws();
		Engineer__Ws ec23 = new Engineer__Ws();
		
		ea23.setName("Alice");
		eb23.setName("Bob");
		ec23.setName("Charlie");
		
		Collaboration c22ab = new Collaboration();
		c22ab.setSender(ea23);
		c22ab.setReceiver(eb23);
		CollaborationType ct23 = c22ab.selectType("Triggered");
		c22ab.setType(ct23);
		
		ea23.addCollaboration(c22ab);
		eb23.addCollaboration(c22ab);
		
		Collaboration c23ba = new Collaboration();
		c23ba.setSender(eb23);
		c23ba.setReceiver(ea23);
		c23ba.setType(ct23);
		
		eb23.addCollaboration(c23ba);
		ea23.addCollaboration(c23ba);
		
		Collaboration c23cb = new Collaboration();
		c23cb.setSender(ec23);
		c23cb.setReceiver(eb23);
		c23cb.setType(ct23);
		
		ec23.addCollaboration(c23cb);
		eb23.addCollaboration(c23cb);
		
		Collaboration c23ca = new Collaboration();
		c23ca.setSender(ec23);
		c23ca.setReceiver(ea23);
		c23ca.setType(ct23);
		
		ec23.addCollaboration(c23ca);
		ea23.addCollaboration(c23ca);
		
		Collaboration c23bc = new Collaboration();
		c23bc.setSender(eb23);
		c23bc.setReceiver(ec23);
		c23bc.setType(ct23);
		
		eb23.addCollaboration(c23bc);
		ec23.addCollaboration(c23bc);
				
		ea23.createDelta(ea23);
		ec23.createDelta(ec23);
		
		Trigger t23a = new Trigger();
		t23a.setSender(ea23);
		
		ea23.trigger(t23a);
		
		Trigger t23c = new Trigger();
		t23c.setSender(ec23);
		
		ec23.trigger(t23c);
		
		assertEquals(2, ea23.getDelta().size());
		assertEquals(2, eb23.getDelta().size());
		assertEquals(1, ec23.getDelta().size());
		
		eb23.createDelta(eb23);
		
		Trigger t23b = new Trigger();
		t23b.setSender(eb23);
		
		eb23.trigger(t23b);
		
		assertEquals(3, ea23.getDelta().size());
		assertEquals(3, eb23.getDelta().size());
		assertEquals(2, ec23.getDelta().size());
				
	}
	
	@Test
	public void Scenario24()
	{
		Engineer__Ws ea24 = new Engineer__Ws();
		Engineer__Ws eb24 = new Engineer__Ws();
		Engineer__Ws ec24 = new Engineer__Ws();
		
		ea24.setName("Alice");
		eb24.setName("Bob");
		ec24.setName("Charlie");
		
		Collaboration c24ab = new Collaboration();
		c24ab.setSender(ea24);
		c24ab.setReceiver(eb24);
		CollaborationType ct24 = c24ab.selectType("Triggered");
		c24ab.setType(ct24);
		
		ea24.addCollaboration(c24ab);
		eb24.addCollaboration(c24ab);
		
		Collaboration c24ba = new Collaboration();
		c24ba.setSender(eb24);
		c24ba.setReceiver(ea24);
		c24ba.setType(ct24);
		
		eb24.addCollaboration(c24ba);
		ea24.addCollaboration(c24ba);
		
		Collaboration c24cb = new Collaboration();
		c24cb.setSender(ec24);
		c24cb.setReceiver(eb24);
		c24cb.setType(ct24);
		
		ec24.addCollaboration(c24cb);
		eb24.addCollaboration(c24cb);
		
		Collaboration c24ca = new Collaboration();
		c24ca.setSender(ec24);
		c24ca.setReceiver(ea24);
		c24ca.setType(ct24);
		
		ec24.addCollaboration(c24ca);
		ea24.addCollaboration(c24ca);
		
		Collaboration c24bc = new Collaboration();
		c24bc.setSender(eb24);
		c24bc.setReceiver(ec24);
		c24bc.setType(ct24);
		
		eb24.addCollaboration(c24bc);
		ec24.addCollaboration(c24bc);
		
		Collaboration c24ac = new Collaboration();
		c24ac.setSender(ea24);
		c24ac.setReceiver(ec24);
		c24ac.setType(ct24);
		
		ea24.addCollaboration(c24ac);
		ec24.addCollaboration(c24ac);
						
		ea24.createDelta(ea24);
		ec24.createDelta(ec24);
		
		
		Trigger t24a = new Trigger();
		t24a.setSender(ea24);
		
		ea24.trigger(t24a);
		
		Trigger t24c = new Trigger();
		t24c.setSender(ec24);
		
		ec24.trigger(t24c);
		
		assertEquals(2, ea24.getDelta().size());
		assertEquals(2, eb24.getDelta().size());
		assertEquals(2, ec24.getDelta().size());
		
		eb24.createDelta(eb24);
		Trigger t24b = new Trigger();
		t24b.setSender(eb24);
		
		eb24.trigger(t24b);
		
		assertEquals(3, ea24.getDelta().size());
		assertEquals(3, eb24.getDelta().size());
		assertEquals(3, ec24.getDelta().size());
				
	}
	
	@Test
	public void Scenario25()
	{
		Engineer__Ws ea25 = new Engineer__Ws();
		Engineer__Ws eb25 = new Engineer__Ws();
		Engineer__Ws ec25 = new Engineer__Ws();
		
		ea25.setName("Alice");
		eb25.setName("Bob");
		ec25.setName("Charlie");
		
		Collaboration c25ab = new Collaboration();
		c25ab.setSender(ea25);
		c25ab.setReceiver(eb25);
		CollaborationType ct25 = c25ab.selectType("Triggered");
		c25ab.setType(ct25);
		
		ea25.addCollaboration(c25ab);
		eb25.addCollaboration(c25ab);
		
		Collaboration c25ba = new Collaboration();
		c25ba.setSender(eb25);
		c25ba.setReceiver(ea25);
		CollaborationType ct25instant = c25ba.selectType("Instant");
		c25ba.setType(ct25instant);
		
		eb25.addCollaboration(c25ba);
		ea25.addCollaboration(c25ba);
		
		Collaboration c25cb = new Collaboration();
		c25cb.setSender(ec25);
		c25cb.setReceiver(eb25);
		c25cb.setType(ct25);
		
		ec25.addCollaboration(c25cb);
		eb25.addCollaboration(c25cb);
		
		Collaboration c25ca = new Collaboration();
		c25ca.setSender(ec25);
		c25ca.setReceiver(ea25);
		c25ca.setType(ct25);
		
		ec25.addCollaboration(c25ca);
		ea25.addCollaboration(c25ca);
		
		Collaboration c25bc = new Collaboration();
		c25bc.setSender(eb25);
		c25bc.setReceiver(ec25);
		c25bc.setType(ct25instant);
		
		eb25.addCollaboration(c25bc);
		ec25.addCollaboration(c25bc);
		
		Collaboration c25ac = new Collaboration();
		c25ac.setSender(ea25);
		c25ac.setReceiver(ec25);
		c25ac.setType(ct25);
		
		ea25.addCollaboration(c25ac);
		ec25.addCollaboration(c25ac);
						
		ea25.createDelta(ea25);
		ec25.createDelta(ec25);			
		eb25.createDelta(eb25);
		
		assertEquals(2, ea25.getDelta().size());
		assertEquals(1, eb25.getDelta().size());
		assertEquals(2, ec25.getDelta().size());
		
		Trigger t25a = new Trigger();
		t25a.setSender(ea25);
		
		ea25.trigger(t25a);
		
		Trigger t25c = new Trigger();
		t25c.setSender(ec25);
		
		ec25.trigger(t25c);
		
		assertEquals(3, ea25.getDelta().size());
		assertEquals(3, eb25.getDelta().size());
		assertEquals(3, ec25.getDelta().size());
				
	}
	
	@Test
	public void Scenario26()
	{
		Engineer__Ws ea26 = new Engineer__Ws();
		Engineer__Ws eb26 = new Engineer__Ws();
		Engineer__Ws ec26 = new Engineer__Ws();
		
		ea26.setName("Alice");
		eb26.setName("Bob");
		ec26.setName("Charlie");
		
		Collaboration c26ab = new Collaboration();
		c26ab.setSender(ea26);
		c26ab.setReceiver(eb26);
		CollaborationType ct26 = c26ab.selectType("Instant");
		c26ab.setType(ct26);
		
		ea26.addCollaboration(c26ab);
		eb26.addCollaboration(c26ab);
		
		Collaboration c26ba = new Collaboration();
		c26ba.setSender(eb26);
		c26ba.setReceiver(ea26);
		c26ba.setType(ct26);
		
		eb26.addCollaboration(c26ba);
		ea26.addCollaboration(c26ba);
		
		Collaboration c26cb = new Collaboration();
		c26cb.setSender(ec26);
		c26cb.setReceiver(eb26);
		c26cb.setType(ct26);
		
		ec26.addCollaboration(c26cb);
		eb26.addCollaboration(c26cb);
		
		Collaboration c26ca = new Collaboration();
		c26ca.setSender(ec26);
		c26ca.setReceiver(ea26);
		c26ca.setType(ct26);
		
		ec26.addCollaboration(c26ca);
		ea26.addCollaboration(c26ca);
		
		Collaboration c26bc = new Collaboration();
		c26bc.setSender(eb26);
		c26bc.setReceiver(ec26);
		c26bc.setType(ct26);
		
		eb26.addCollaboration(c26bc);
		ec26.addCollaboration(c26bc);
		
		Collaboration c26ac = new Collaboration();
		c26ac.setSender(ea26);
		c26ac.setReceiver(ec26);
		c26ac.setType(ct26);
		
		ea26.addCollaboration(c26ac);
		ec26.addCollaboration(c26ac);
						
		ea26.createDelta(ea26);
		
		assertEquals(1, ea26.getDelta().size());
		assertEquals(1, eb26.getDelta().size());
		assertEquals(1, ec26.getDelta().size());
		
		ec26.createDelta(ec26);
		
		assertEquals(2, ea26.getDelta().size());
		assertEquals(2, eb26.getDelta().size());
		assertEquals(2, ec26.getDelta().size());
		
		eb26.createDelta(eb26);
		
		assertEquals(3, ea26.getDelta().size());
		assertEquals(3, eb26.getDelta().size());
		assertEquals(3, ec26.getDelta().size());
		
		ea26.createDelta(ea26);
		
		assertEquals(4, ea26.getDelta().size());
		assertEquals(4, eb26.getDelta().size());
		assertEquals(4, ec26.getDelta().size());
				
	}
	
}
