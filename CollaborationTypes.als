module Types

//Engineers' work spaces
sig Engineer_Ws
{
	delta : set Delta,
	name :  String,
	collaboration : set Collaboration
}

//Produced Changes
sig Delta 
{
	initiator: Engineer_Ws
}

//
sig CollaborationType{}
sig Instant extends CollaborationType
{
	name: String
}
sig Triggered extends CollaborationType
{
	name:String
	//Actions needed????
}

sig Collaboration
{
	type: CollaborationType,
	sender : Engineer_Ws,
	receiver : Engineer_Ws
}

sig Action{}
sig Trigger extends Action
{
	sender : one Engineer_Ws
}
//Add the boolean action?

