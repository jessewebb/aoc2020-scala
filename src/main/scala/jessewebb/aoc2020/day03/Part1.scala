package jessewebb.aoc2020.day03

object Part1 {

  def solve(grid: Grid): Answer =
    countTreesInSlope(grid)(Slope(3, 1))

}
