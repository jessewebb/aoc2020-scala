package jessewebb.aoc2020

import scala.annotation.tailrec

package object day05 {

  type BoardingPass = String

  type RowPartition = String
  type ColPartition = String

  type Row = Int
  type Col = Int

  type Seat = (Row, Col)
  type SeatID = Int

  private[day05] def determineSeatId(boardingPass: BoardingPass): SeatID = {
    val (rowPartition, colPartition) = boardingPass.splitAt(7)
    val row = findRow(rowPartition)
    val col = findCol(colPartition)
    row * 8 + col
  }

  private[day05] def findRow(rowPartition: RowPartition): Row = {
    @tailrec
    def findRowRec(rowPartition: RowPartition, rows: Range): Row = {
      if (rowPartition.isEmpty) return rows.head
      val (front, back) = rows.splitAt(rows.length / 2)
      val rowsToKeep = rowPartition.toArray.head match {
        case 'F' => front
        case 'B' => back
        case _ => throw new IllegalArgumentException(s"Invalid rowPartition: $rowPartition")
      }
      findRowRec(rowPartition.tail, rowsToKeep)
    }
    findRowRec(rowPartition, rows = 0 to 127)
  }

  private[day05] def findCol(colPartition: ColPartition): Col = {
    @tailrec
    def findColRec(colPartition: ColPartition, cols: Range): Col = {
      if (colPartition.isEmpty) return cols.head
      val (left, right) = cols.splitAt(cols.length / 2)
      val colsToKeep = colPartition.toArray.head match {
        case 'L' => left
        case 'R' => right
        case _ => throw new IllegalArgumentException(s"Invalid colPartition: $colPartition")
      }
      findColRec(colPartition.tail, colsToKeep)
    }
    findColRec(colPartition, cols = 0 to 7)
  }
}
