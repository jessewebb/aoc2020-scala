package jessewebb.aoc2020.day04

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part1Test extends AnyFunSuite with Matchers {
  import Part1Test._

  test("Passport.isValid Example #1") {
    val passport = examplePassport1
    passport.isValid shouldBe true
  }

  test("Passport.isValid Example #2") {
    val passport = examplePassport2
    passport.isValid shouldBe false
  }

  test("Passport.isValid Example #3") {
    val passport = examplePassport3
    passport.isValid shouldBe true
  }

  test("Passport.isValid Example #4") {
    val passport = examplePassport4
    passport.isValid shouldBe false
  }

  test("solve Example") {
    val passports = Seq(
      examplePassport1,
      examplePassport2,
      examplePassport3,
      examplePassport4,
    )
    val answer = Part1.solve(passports)
    answer shouldEqual 2
  }

  test("parseInput Example") {
    val input =
      s"""ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
         |byr:1937 iyr:2017 cid:147 hgt:183cm
         |
         |iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
         |hcl:#cfa07d byr:1929
         |
         |hcl:#ae17e1 iyr:2013
         |eyr:2024
         |ecl:brn pid:760753108 byr:1931
         |hgt:179cm
         |
         |hcl:#cfa07d eyr:2025 pid:166559648
         |iyr:2011 ecl:brn hgt:59in
         |""".stripMargin
    val passports = Part1.parseInput(input)
    passports shouldEqual Seq(
      examplePassport1,
      examplePassport2,
      examplePassport3,
      examplePassport4,
    )
  }

}

object Part1Test {

  private val examplePassport1 = Part1.Passport(fields = Map(
    "ecl" -> "gry",
    "pid" -> "860033327",
    "eyr" -> "2020",
    "hcl" -> "#fffffd",
    "byr" -> "1937",
    "iyr" -> "2017",
    "cid" -> "147",
    "hgt" -> "183cm",
  ))

  private val examplePassport2 = Part1.Passport(fields = Map(
    "iyr" -> "2013",
    "ecl" -> "amb",
    "cid" -> "350",
    "eyr" -> "2023",
    "pid" -> "028048884",
    "hcl" -> "#cfa07d",
    "byr" -> "1929",
  ))

  private val examplePassport3 = Part1.Passport(fields = Map(
    "hcl" -> "#ae17e1",
    "iyr" -> "2013",
    "eyr" -> "2024",
    "ecl" -> "brn",
    "pid" -> "760753108",
    "byr" -> "1931",
    "hgt" -> "179cm",
  ))

  private val examplePassport4 = Part1.Passport(fields = Map(
    "hcl" -> "#cfa07d",
    "eyr" -> "2025",
    "pid" -> "166559648",
    "iyr" -> "2011",
    "ecl" -> "brn",
    "hgt" -> "59in",
  ))

}
