class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numerator, denominator)

  def sub(that: Rational): Rational =
    new Rational(numerator * that.denominator - that.numerator * denominator,
                 denominator * that.denominator)

  override def toString: String =
    if (denominator == 1) numerator.toString else s"$numerator/$denominator"
}

object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}

// Given rational numbers
val x = Rational(3, 4)
val y = Rational(5, 8)
val z = Rational(2, 7)

// Calculate xy - z
val result = x.sub(y).sub(z)
println(s"Result: $result")  // Output: Result: 3/8
