fun main(){
    var myAccount=CurrentAccount("000574634","Pascaline",10000.0)
    myAccount.deposit(2000.0)
    myAccount.withdraw(500.5)
    myAccount.details()

    var mySavingsAccount=SavingsAccount("000475663","Umulisa",50000.5,2)
    mySavingsAccount.deposit(3000.5)
    mySavingsAccount.withdraw(1000.5)
    println( mySavingsAccount.withdrawals)
    mySavingsAccount.details()

    var a=Product("tissue",12.0,200.0,"hygiene")
    var b=Product("mopper",30.0,1000.5,"hygiene")
    var c=Product("book",10.5,100.5,"other")
    var d=Product("carrots",3.5,600.0,"groceries")
    assignProducts(a)
    assignProducts(b)
    assignProducts(c)
    assignProducts(d)ls

    evenIndicesChar("banana")
    evenIndicesChar("Pascaline")


}
open class CurrentAccount(var accountNumber:String,var accountName:String,var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount: Double){
        balance-=amount
        println(balance)
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }

}
class SavingsAccount(accountNumber: String,accountName: String,balance: Double, var withdrawals:Int):CurrentAccount(accountNumber,accountName,balance){
    override fun withdraw(amount: Double) {
        if (withdrawals<4){
            balance-=amount
        }
        println(balance)
        withdrawals++
    }
}
data class Product(var name:String, var weight:Double,var price:Double,var category:String)
fun assignProducts(product:Product){

    var groceriesLists= mutableListOf<Product>()
    var hygieneLists= mutableListOf<Product>()
    var otherLists= mutableListOf<Product>()
    when(product.category){
        "groceries"-> groceriesLists.add(product)
        "hygiene"->hygieneLists.add(product)
        "other"->otherLists.add(product)
    }
   println( listOf(product))

}
fun evenIndicesChar(word:String):String{
    var newWord=""
    word.forEachIndexed { index, c ->
        if (index%2==0){
            newWord+=c
        }
    }
    println(newWord)
    return newWord

}
