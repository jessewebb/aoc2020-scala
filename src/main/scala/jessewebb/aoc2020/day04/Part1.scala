package jessewebb.aoc2020.day04

object Part1 {

  case class Passport(fields: Map[String, String]) {
    def isValid: Boolean = {
      Passport.requiredKeys.subsetOf(fields.keySet)
    }
  }

  object Passport {
    private val requiredKeys: Set[String] = Set(
      "byr",
      "iyr",
      "eyr",
      "hgt",
      "hcl",
      "ecl",
      "pid",
      // "cid",
    )
  }

  type Answer = Int

  def parseInput(input: String): Seq[Passport] = {
    def parsePassport(passportStr: String) = {
      val fields = passportStr.split("\\s+").map {
        _.split(':') match {
          case Array(key, value) => (key, value)
        }
      }.toMap
      Passport(fields)
    }
    input.split("\n{2}").map(parsePassport).toList
  }

  def solve(passports: Seq[Passport]): Answer =
    passports.count(_.isValid)

}
