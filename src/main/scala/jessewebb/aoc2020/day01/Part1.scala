package jessewebb.aoc2020.day01

object Part1 {

  type Expense = Int
  type Answer = Int

  def solve(expenses: Seq[Expense]): Answer = {
    expenses.combinations(2).collect {
      case Seq(a, b) if a + b == 2020 => a * b
    }.next()
  }

}
