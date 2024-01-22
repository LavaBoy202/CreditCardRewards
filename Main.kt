import transactions
import CreditCardRewardSystem

//There's a lot more that can be added to this in term of functionality
//Some ideas: User's name, displaying month, tracking which merchants user spend most money at, input of transactions
//For simplicity I designed the algorithm to run in console and have the transactions hard-coded
//If you have any questions about my code or want to hear my ideas to scale it, I would love to share them with you :)

fun main() {
    var monthStatment = CreditCardRewardSystem()
    monthStatment.addPurchases(transactions)
    monthStatment.maximumRewards()
    println("Total Monthly Reward Points: ${monthStatment.Reward_Points}")
}
