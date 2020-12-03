package jessewebb.aoc2020.day01

object Part2 {

  type Expense = Int
  type Answer = Int

  def solve(expenses: Seq[Expense]): Answer = {
    expenses.combinations(3).collect {
      case Seq(a, b, c) if a + b + c == 2020 => a * b * c
    }.next()
  }

}
