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

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    require(amount <= balance, "Insufficient balance for transfer")
    withdraw(amount)
    toAccount.deposit(amount)
  }

  def getBalance: Double = balance
}

// Example usage
val account1 = new Account(1000)
val account2 = new Account(500)

println(s"Account 1 balance: ${account1.getBalance}")  // Output: Account 1 balance: 1000.0
println(s"Account 2 balance: ${account2.getBalance}")  // Output: Account 2 balance: 500.0

account1.deposit(200)
account2.withdraw(100)

println(s"Account 1 balance: ${account1.getBalance}")  // Output: Account 1 balance: 1200.0
println(s"Account 2 balance: ${account2.getBalance}")  // Output: Account 2 balance: 400.0

account1.transfer(300, account2)

println(s"Account 1 balance: ${account1.getBalance}")  // Output: Account 1 balance: 900.0
println(s"Account 2 balance: ${account2.getBalance}")  // Output: Account 2 balance: 700.0
