package jessewebb.aoc2020.day05

object Part1 {

  type Answer = Int

  def solve(boardingPasses: Seq[BoardingPass]): Answer =
    boardingPasses.map(determineSeatId).max

}
