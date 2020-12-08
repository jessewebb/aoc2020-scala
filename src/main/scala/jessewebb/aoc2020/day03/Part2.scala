package jessewebb.aoc2020.day03

object Part2 {

  def solve(grid: Grid): Answer = {
    val slopes = List(
      Slope(right = 1, down = 1),
      Slope(right = 3, down = 1),
      Slope(right = 5, down = 1),
      Slope(right = 7, down = 1),
      Slope(right = 1, down = 2),
    )
    val counts = slopes.map(countTreesInSlope(grid))
    counts.product
  }

}
