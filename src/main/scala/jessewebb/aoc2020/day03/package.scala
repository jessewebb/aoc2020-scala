package jessewebb.aoc2020

import scala.annotation.tailrec

package object day03 {

  type Square = Char
  val OpenSquare: Square = '.'
  val Tree: Square = '#'

  type Grid = Seq[Seq[Square]]

  case class Slope(right: Int, down: Int)

  case class Position(x: Int, y: Int)

  type Answer = Long

  private[day03] def countTreesInSlope(grid: Grid)(slope: Slope): Long = {
    @tailrec
    def countTreesInSlopeRec(position: Position = Position(0, 0), treeCountAcc: Long = 0): Long = {
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
