package jessewebb.aoc2020.day01

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part1Test extends AnyFunSuite with Matchers {

  test("Example") {
    val expenses = List(
      1721,
      979,
      366,
      299,
      675,
      1456,
    )
    val answer = Part1.solve(expenses)
    answer shouldEqual 514579
  }

}
