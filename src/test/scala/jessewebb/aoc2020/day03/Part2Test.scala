package jessewebb.aoc2020.day03

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part2Test extends AnyFunSuite with Matchers {

  private val exampleGrid = List(
    List('.','.','#','#','.','.','.','.','.','.','.'),
    List('#','.','.','.','#','.','.','.','#','.','.'),
    List('.','#','.','.','.','.','#','.','.','#','.'),
    List('.','.','#','.','#','.','.','.','#','.','#'),
    List('.','#','.','.','.','#','#','.','.','#','.'),
    List('.','.','#','.','#','#','.','.','.','.','.'),
    List('.','#','.','#','.','#','.','.','.','.','#'),
    List('.','#','.','.','.','.','.','.','.','.','#'),
    List('#','.','#','#','.','.','.','#','.','.','.'),
    List('#','.','.','.','#','#','.','.','.','.','#'),
    List('.','#','.','.','#','.','.','.','#','.','#'),
  )

  test("countTreesInSlope Example Slope #1") {
    val slope = Slope(1, 1)
    val count = countTreesInSlope(exampleGrid)(slope)
    count shouldBe 2
  }

  test("countTreesInSlope Example Slope #2") {
    val slope = Slope(3, 1)
    val count = countTreesInSlope(exampleGrid)(slope)
    count shouldBe 7
  }

  test("countTreesInSlope Example Slope #3") {
    val slope = Slope(5, 1)
    val count = countTreesInSlope(exampleGrid)(slope)
    count shouldBe 3
  }

  test("countTreesInSlope Example Slope #4") {
    val slope = Slope(7, 1)
    val count = countTreesInSlope(exampleGrid)(slope)
    count shouldBe 4
  }

  test("countTreesInSlope Example Slope #5") {
    val slope = Slope(1, 2)
    val count = countTreesInSlope(exampleGrid)(slope)
    count shouldBe 2
  }

  test("Example") {
    val count = Part2.solve(exampleGrid)
    count shouldBe 336
  }

}
