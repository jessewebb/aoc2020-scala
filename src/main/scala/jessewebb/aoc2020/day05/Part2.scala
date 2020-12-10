package jessewebb.aoc2020.day05

object Part2 {

  def solve(boardingPasses: Seq[BoardingPass]): SeatID = {
    val minSeatID = 0
    val maxSeatID = 127 * 8 + 7
    val occupiedSeatIDs = boardingPasses.map(determineSeatId)
    val mySeatID = (minSeatID to maxSeatID).find { seatID =>
      !occupiedSeatIDs.contains(seatID) &&
        occupiedSeatIDs.contains(seatID - 1) &&
        occupiedSeatIDs.contains(seatID + 1)
    }
    mySeatID.get
  }

}
