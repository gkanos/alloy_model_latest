open CollaborationTypes as Types

//scenario 1-4
one sig Ea1,Eb1,Ea2,Eb2,Ea3,Eb3,Ea4,Eb4,Ea6,Eb6 extends Engineer_Ws{}
//scenario 5
one sig Ea5,Eb5,Ec5 extends Engineer_Ws{}
one sig Da5 extends Delta{}
one sig Cab5, Cac5 extends Collaboration{}
one sig ct5f, ct5s extends Triggered{}
one sig t5 extends Trigger{}
//one sig t5s extends Trigger{}
//Scenario 7
one sig Ea7,Eb7,Ec7 extends Engineer_Ws{}
one sig Da7,Db7 extends Delta{}
one sig Cab7, Cbc7 extends Collaboration{}
one sig ct7 extends Triggered{}
one sig t7 extends Trigger{}
//General collaboration variables 1-5
one sig Da1,Da2,Da3,Da6 extends Delta{}
one sig Cab1,Cab2,Cab3, Cab4,Cab6 extends Collaboration{}
one sig ct1,ct3,ct6 extends Triggered{}
one sig ct2, ct4 extends Instant{}
one sig t1,t6 extends Trigger{}

pred scenarioRun
{

	//Initialization phaze of scenario 1
	Ea1.name = "Alice"
	Ea1.delta = Da1
	Ea1.collaboration = Cab1

	Eb1.name = "Bob"
	Eb1.collaboration = Cab1
	
	t1.sender = Ea1	

	Da1.initiator = Ea1
	
	//Collaboration Setup scenario 1 - This needs Actions
	Cab1.type = ct1

	ct1.name = "Triggered"

	Cab1.sender = Ea1
	Cab1.receiver = Eb1

	//Scenario Predicates
	

	//Initialization scenario 3
	Ea3.name = "Alice"
	Ea3.delta = Da3
	Ea3.collaboration = Cab3

	//Eb3.delta = Da3
	
	Eb3.name = "Bob"
	Eb3.collaboration = Cab3

	Cab3.sender = Ea3
	Cab3.receiver = Eb3	
	Cab3.type = ct3

	ct3.name = "Triggered"

	Da3.initiator = Ea3

	//Scenario Predicates
	no b:Eb3 | b.delta = Da3

	//Initialization phaze for scenario 2
	Ea2.name = "Alice"
	Ea2.delta = Da2
	Ea2.collaboration = Cab2
	Da2.initiator = Ea2

	Eb2.name = "Bob"
	Eb2.collaboration = Cab2

	//collaboration scenario 2
	ct2.name = "Instant"
	Cab2.type = ct2		
	Cab2.sender = Ea2
	Cab2.receiver = Eb2

	//Initialization scenario 4
	Ea4.name = "Alice"
	Ea4.collaboration = Cab4
	//Ea4.delta = d4
	//d4.initiator = Ea4

	Eb4.name = "Bob"
	Eb4.collaboration = Cab4
	
	//Collaboration  scenario 4
	ct4.name = "Instant"
	Cab4.type = ct4
	Cab4.sender = Ea4
	Cab4.receiver = Eb4

	//Predicates Scenario 4
	all b:Eb4 | b.delta = none

	//Initialization Scenario 5
	Ea5.name = "Alice"
	Ea5.delta = Da5
	Ea5.collaboration = Cab5+Cac5

	Eb5.name = "Bob"
	Eb5.collaboration = Cab5
	
	Ec5.name = "Charlie"
	Ec5.collaboration = Cac5

	//Collaboration Scenario 5
	Da5.initiator = Ea5
	
	ct5f.name = "Triggered"
	Cab5.type = ct5f
	Cab5.sender = Ea5
	Cab5.receiver = Eb5

	ct5s.name = "Triggered"
	Cac5.type = ct5s
	Cac5.sender = Ea5
	Cac5.receiver = Ec5
	
	t5.sender = Ea5
	
	
	//t5s.sender = Ea5
	//Exceptions to Model
	//t5s.sender = Eb5f
	
	//Initialization scenario 6
	Ea6.name = "Alice"
	Ea6.delta = Da6
	Ea6.collaboration = Cab6

	//Eb3.delta = Da3
	
	Eb6.name = "Bob"
	Eb6.collaboration = Cab6

	Cab6.sender = Ea6
	Cab6.receiver = Eb6
	Cab6.type = ct6

	ct6.name = "Triggered"

	Da6.initiator = Ea6
	
	t6.sender = Eb6
//	Eb6.delta = Da6
	//Scenario Predicates
	no b:Eb6 | b.delta = Da6 

	//Initialization Scenario 7
	
	Ea7.name = "Alice"
	Ea7.delta = Da7
//	Ea7.collaboration = Cab7
	
	Eb7.name = "Bob"
	Eb7.delta= Db7
//	Eb7.collaboration = Cab7 + Cbc7
	
	Ec7.name = "Charlie"
//	Ec7.collaboration = Cbc7
	//Collaboration Scenario 7
	Cab7.type = ct7
	Cbc7.type = ct7
	
	ct7.name = "Triggered"
	
	Cab7.sender = Ea7
	Cab7.receiver = Eb7
	
	Cbc7.sender = Eb7
	Cbc7.receiver = Ec7
	
	Da7.initiator = Ea7
	Db7.initiator = Eb7
	
	t7.sender = Eb7

	//Initialization Scenario 8
	
		
	//Constraints following
	all d:Delta | d in d.initiator.delta 
	all c:Collaboration | c in c.sender.collaboration
	all c:Collaboration | c in c.receiver.collaboration
	//no d:Delta | d.initiator = 
	//no t:Trigger, c:Collaboration | t.sender = c.receiver // This rule makes a blocking sequence to receiver triggering a communication.
	
	//Triggered Constrains
	//all t:Trigger |t.sender.delta = t.sender.collaboration.receiver.delta -> Involved to below
	all t:Trigger, c:t.sender.collaboration | t.sender.delta = c.receiver.delta// and c.receiver = t.sender.collaboration.receiver
	all d:Delta,t:Trigger | d.initiator.collaboration.type = Triggered implies d.initiator = t.sender
	//Instant Constrains
	all d:Delta, i:Instant | d.initiator.collaboration.type = i implies d.initiator.collaboration.receiver.delta = d.initiator.collaboration.sender.delta
	
	//all c:Collaboration | let type = c.type |  type = Instant  implies c.sender.delta = c.receiver.delta
}

run scenarioRun

pred collaboration()
{
	all c:Collaboration | c.sender.delta = c.receiver.delta
}

//	all c:Collaboration | c.sender.delta = d
//	all c : Collaboration | c in c.sender.collaboration 
//and c.receiver.delta = c.sender.delta or c.receiver.delta = none
//	
	//Constraint for transfer delta
	//some c:Collaboration, a:Engineer_Ws | c.sender = a and c.sender.delta = a.delta
	//all c:Collaboration | c.sender.delta = c.receiver.delta
	//collaboration[]
