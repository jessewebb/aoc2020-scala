package jessewebb.aoc2020.day02

import jessewebb.aoc2020.day02.Part2.PasswordPolicy
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part2Test extends AnyFunSuite with Matchers {

  test("isPasswordValid Example #1") {
    val password = "abcde"
    val policy = PasswordPolicy(1, 3, 'a')
    val result = Part2.isPasswordValid(password, policy)
    result shouldBe true
  }

  test("isPasswordValid Example #2") {
    val password = "cdefg"
    val policy = PasswordPolicy(1, 3, 'b')
    val result = Part2.isPasswordValid(password, policy)
    result shouldBe false
  }

  test("isPasswordValid Example #3") {
    val password = "ccccccccc"
    val policy = PasswordPolicy(2, 9, 'c')
    val result = Part2.isPasswordValid(password, policy)
    result shouldBe false
  }

  test("Example") {
    val passwordsAndPolicies = Seq(
      ("abcde", PasswordPolicy(1, 3, 'a')),
      ("cdefg", PasswordPolicy(1, 3, 'b')),
      ("ccccccccc", PasswordPolicy(2, 9, 'c')),
    )
    val result = Part2.solve(passwordsAndPolicies)
    result shouldBe 1
  }

}