package jessewebb.aoc2020.day03

import scala.annotation.tailrec

object Part1 {

  type Square = Char
  val OpenSquare: Square = '.'
  val Tree: Square = '#'

  type Grid = Seq[Seq[Square]]

  case class Slope(right: Int, down: Int)

  case class Position(x: Int, y: Int)

  type Answer = Int

  def parseInput(lineOfInput: String): Seq[Square] = {
    lineOfInput.toCharArray
  }

  def solve(grid: Grid): Answer =
    countTreesInSlope(grid)(Slope(3, 1))

  private[day03] def countTreesInSlope(grid: Grid)(slope: Slope): Int = {
    @tailrec
    def countTreesInSlopeRec(position: Position = Position(0, 0), treeCountAcc: Int = 0): Int = {
      val newX = (position.x + slope.right) % grid(position.y).length
      val newY = position.y + slope.down
      val newPosition = Position(newX, newY)
      val newTreeCount = grid.lift(newPosition.y).flatMap(_.lift(newPosition.x)) match {
        case Some(Tree) =>
          treeCountAcc + 1
        case _ =>
          treeCountAcc
      }
      if (newPosition.y >= grid.length)
        newTreeCount
      else
        countTreesInSlopeRec(newPosition, newTreeCount)
    }

    countTreesInSlopeRec()
  }

}
