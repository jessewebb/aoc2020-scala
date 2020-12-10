package jessewebb.aoc2020.day05

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part1Test extends AnyFunSuite with Matchers {

  test("findRow Example #1") {
    val rowPartition = "FBFBBFF"
    val result = Part1.findRow(rowPartition)
    result shouldEqual 44
  }

  test("findRow Example #2") {
    val rowPartition = "BFFFBBF"
    val result = Part1.findRow(rowPartition)
    result shouldEqual 70
  }

  test("findRow Example #3") {
    val rowPartition = "FFFBBBF"
    val result = Part1.findRow(rowPartition)
    result shouldEqual 14
  }

  test("findRow Example #4") {
    val rowPartition = "BBFFBBF"
    val result = Part1.findRow(rowPartition)
    result shouldEqual 102
  }

  test("findCol Example #1") {
    val colPartition = "RLR"
    val result = Part1.findCol(colPartition)
    result shouldEqual 5
  }

  test("findCol Example #2") {
    val colPartition = "RRR"
    val result = Part1.findCol(colPartition)
    result shouldEqual 7
  }

  test("findCol Example #3") {
    val colPartition = "RLL"
    val result = Part1.findCol(colPartition)
    result shouldEqual 4
  }

  test("determineSeatId Example #1") {
    val boardingPass = "FBFBBFFRLR"
    val result = Part1.determineSeatId(boardingPass)
    result shouldEqual 357
  }

  test("determineSeatId Example #2") {
    val boardingPass = "BFFFBBFRRR"
    val result = Part1.determineSeatId(boardingPass)
    result shouldEqual 567
  }

  test("determineSeatId Example #3") {
    val boardingPass = "FFFBBBFRRR"
    val result = Part1.determineSeatId(boardingPass)
    result shouldEqual 119
  }

  test("determineSeatId Example #4") {
    val boardingPass = "BBFFBBFRLL"
    val result = Part1.determineSeatId(boardingPass)
    result shouldEqual 820
  }

}
