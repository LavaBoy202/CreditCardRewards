//Transactions should be mapped in this format for the method to calculate maximum reward points
//Assumptions: All entries are of the same month, we can check this if data is from multiple months
//IDEA: This can be added into the map via user input when scaled into an app. For simplicity it will be hard-coded for now
//IDEA: JUnit can be used to test the code usign different maps of transactions
val transactions = mapOf(
        "T01" to mapOf("date" to "2021-05-01", "merchant_code" to "sportcheck", "amount_cents" to 21000),
        "T02" to mapOf("date" to "2021-05-02", "merchant_code" to "sportcheck", "amount_cents" to 8700),
        "T03" to mapOf("date" to "2021-05-03", "merchant_code" to "tim_hortons", "amount_cents" to 323),
        "T04" to mapOf("date" to "2021-05-04", "merchant_code" to "tim_hortons", "amount_cents" to 1267),
        "T05" to mapOf("date" to "2021-05-05", "merchant_code" to "tim_hortons", "amount_cents" to 2116),
        "T06" to mapOf("date" to "2021-05-06", "merchant_code" to "tim_hortons", "amount_cents" to 2211),
        "T07" to mapOf("date" to "2021-05-07", "merchant_code" to "subway", "amount_cents" to 1853),
        "T08" to mapOf("date" to "2021-05-08", "merchant_code" to "subway", "amount_cents" to 2153),
        "T09" to mapOf("date" to "2021-05-09", "merchant_code" to "sportcheck", "amount_cents" to 7326),
        "T10" to mapOf("date" to "2021-05-10", "merchant_code" to "tim_hortons", "amount_cents" to 1321)
)

val transactions2 = mapOf(
        "T01" to mapOf("date" to "2021-05-01", "merchant_code" to "sportcheck", "amount_cents" to 2500),
        "T02" to mapOf("date" to "2021-05-02", "merchant_code" to "tim_hortons", "amount_cents" to 1000),
        "T03" to mapOf("date" to "2021-05-03", "merchant_code" to "bay", "amount_cents" to 500),
        
)
val transactions3  = mapOf(
        "T01" to mapOf("date" to "2021-05-01", "merchant_code" to "sportcheck", "amount_cents" to 750000),
        "T02" to mapOf("date" to "2021-05-02", "merchant_code" to "tim_hortons", "amount_cents" to 250000),
        "T03" to mapOf("date" to "2021-05-03", "merchant_code" to "subway", "amount_cents" to 5000),
        
)
val transactions4  = mapOf(
        "T01" to mapOf("date" to "2021-05-01", "merchant_code" to "sportcheck", "amount_cents" to 10000),
        
)
