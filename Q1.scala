class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String =
    if (denominator == 1) numerator.toString else s"$numerator/$denominator"
}

object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}

// Example usage
val x = Rational(3, 4)
val negative_x = x.neg
println(s"x = $x")           // Output: x = 3/4
println(s"-x = $negative_x") // Output: -x = -3/4
