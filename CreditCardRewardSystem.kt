class CreditCardRewardSystem {
    //Total purchases of each merchant
    var Sportcheck: Int = 0
    var Subway: Int = 0
    var Tim_Hortons: Int = 0
    var Other: Int = 0
    //Total Rewardable Purchases Left
    var SpendingRewardsLeft: Int = 0
    //Total Reward Points 
    var Reward_Points: Int = 0

    //PURPOSE: Takes a list of transactions in a map format and calculates total spending for listed merchants
    fun addPurchases(transactions: Map<String, Map<String, Any>>){
        for ((transactionId, transactionData) in transactions) {
            val merchantCode = transactionData["merchant_code"] as? String //Avoids ClassCastException
            val amountCents = transactionData["amount_cents"] as? Int ?: 0
            when (merchantCode){
                "sportcheck" -> Sportcheck += amountCents
                "subway" -> Subway += amountCents
                "tim_hortons" -> Tim_Hortons += amountCents
                else -> Other += amountCents

            }
        }
        changeToDollar()
        spendingReward()
    }
    //PURPOSE: Enforces the rules for the credit card reward program to yield maximum reward points
    fun maximumRewards(){
        while(SpendingRewardsLeft > 0){
            convertToOther()
            if(Sportcheck >= 75 && Subway >= 25 && Tim_Hortons >= 25){
                Rule1Deduction(denom(1))
                
            }else if(Sportcheck >= 75 && Tim_Hortons >= 25){
                Rule2Deduction(denom(2))
                
            }else if(Sportcheck >= 25 && Tim_Hortons >= 10 && Subway >= 10){
                Rule4Deduction(denom(4))
                
            }else if(Sportcheck >= 20){
                Rule6Deduction(denom(6))
                
            }else{
                Rule7Deduction(denom(7))
            }
            
        }
    }

    //PURPOSE: After exhausting all options for the rules, rule 7 will be applied by converting all remainders to the other merchant category
    fun convertToOther(){
        if(Sportcheck < 20){
            Other += Sportcheck
            Other += Subway
            Other += Tim_Hortons
            Sportcheck = 0
            Subway = 0
            Tim_Hortons = 0
        }
        if(Tim_Hortons < 10){
            Other += Tim_Hortons
            Tim_Hortons = 0
        }
        if(Subway < 10){
            Other += Subway
            Subway = 0
        }
    }

    fun spendingReward(){
        SpendingRewardsLeft = Sportcheck + Subway + Tim_Hortons + Other
    }
    
    //PURPOSE: Converts amount_cents into dollars since the reward system is based in dollars
    fun changeToDollar(){
        if (Sportcheck > 0) {Sportcheck = Sportcheck/100}
        if (Subway > 0) {Subway = Subway/100}
        if (Tim_Hortons > 0) {Tim_Hortons = Tim_Hortons/100}
        if (Other > 0) {Other = Other/100}
    }
    fun denom(rule: Int): Int{
        var x: Int
        when (rule){
            1 -> x = minOf(Sportcheck/75, Subway/25, Tim_Hortons/25)
            2 -> x = minOf(Sportcheck/75, Tim_Hortons/25)
            4 -> x = minOf(Sportcheck/25, Subway/10, Tim_Hortons/10)
            6 -> x = minOf(Sportcheck/20)
            else -> x = 1
            
        }
        return x    
    }
    //******************
    //RULES
    //******************
    //Note: Since we are looking for optimality, rule 3 and rule 5 were elimated as they do not yield in optimal rewards. 
    //Case Rule 3: 200 points for $75 spent and sportcheck and $25 spent at Tim Hortons. 
    //However it is optimal to convert this to Rule 6, and Rule 7 which gives 3 x 75 points = 225 and 15 x 1 point = 15, giving a total of 240 points
    //Hence Rule 3 is not optimal
    
    //Case rule 5: 75 points for every $25 spent at SportsCheck and $10 spent at Tim Hortons
    //However it is optimal to convert this to Rule 6, and Rule 7 which gives 1 x 75 points = 75 and 15 x 1 = 15, giving a total of 90
    //Hence Rule 5 is not optimal
    fun Rule1Deduction(denom: Int){
        if(Sportcheck >= 75 && Subway >= 25 && Tim_Hortons >= 25){
            Sportcheck -= 75 * denom
            Subway -= 25 * denom
            Tim_Hortons -= 25 * denom
            Reward_Points += 500 * denom
        }
        spendingReward()
    }
    fun Rule2Deduction(denom: Int){
        if(Sportcheck >= 75 && Tim_Hortons >= 25){
            Sportcheck -= 75 * denom
            Tim_Hortons -= 25 * denom
            Reward_Points += 300 * denom
        }
        spendingReward()

    }
    fun Rule4Deduction(denom: Int){
        if(Sportcheck >= 25 && Subway >= 10 && Tim_Hortons >= 10){
            Sportcheck -= 25 * denom
            Subway -= 10 * denom
            Tim_Hortons -= 10 * denom
            Reward_Points += 150 * denom
        }
        spendingReward()

    }
    fun Rule6Deduction(denom: Int){
        if(Sportcheck >= 20){
            Sportcheck -= 20 * denom
            Reward_Points += 75 * denom
        }
        spendingReward()
    }
    fun Rule7Deduction(denom: Int){
        Reward_Points += Other * denom
        Other = 0
        spendingReward()
    }
}