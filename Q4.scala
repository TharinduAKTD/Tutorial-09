class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= balance, "Insufficient balance")
    balance -= amount
  }

  def applyInterest(): Unit = {
    val interestRate = if (balance >= 0) 0.05 else 0.1
    balance *= (1 + interestRate)
  }

  def getBalance: Double = balance
}

class Bank(accounts: List[Account]) {
  def accountsWithNegativeBalances: List[Account] =
    accounts.filter(account => account.getBalance < 0)

  def totalBalance: Double =
    accounts.map(_.getBalance).sum

  def applyInterestToAll(): Unit =
    accounts.foreach(_.applyInterest())
}

// Example usage
val account1 = new Account(100)
val account2 = new Account(-200)
val account3 = new Account(500)

val bank = new Bank(List(account1, account2, account3))

println("Accounts with negative balances:")
bank.accountsWithNegativeBalances.foreach(account => println(account.getBalance))

println(s"Total balance of all accounts: ${bank.totalBalance}")

bank.applyInterestToAll()
println("Balances after applying interest:")
bank.accounts.foreach(account => println(account.getBalance))
