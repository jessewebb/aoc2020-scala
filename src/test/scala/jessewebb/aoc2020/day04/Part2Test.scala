package jessewebb.aoc2020.day04

import jessewebb.aoc2020.day04.Part2.Passport
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part2Test extends AnyFunSuite with Matchers {

  test("Passport.isValidBirthYear") {
    // Examples
    Passport.isValidBirthYear("2002") shouldBe true
    Passport.isValidBirthYear("2003") shouldBe false

    // Extra
    Passport.isValidBirthYear("1919") shouldBe false
    Passport.isValidBirthYear("1920") shouldBe true
    Passport.isValidBirthYear("2000") shouldBe true
    Passport.isValidBirthYear("foo") shouldBe false
    Passport.isValidBirthYear("12345") shouldBe false
  }

  test("Passport.isValidIssueYear") {
    // Extra
    Passport.isValidIssueYear("2009") shouldBe false
    Passport.isValidIssueYear("2010") shouldBe true
    Passport.isValidIssueYear("2015") shouldBe true
    Passport.isValidIssueYear("2020") shouldBe true
    Passport.isValidIssueYear("2021") shouldBe false
    Passport.isValidIssueYear("bar") shouldBe false
    Passport.isValidIssueYear("12345") shouldBe false
  }

  test("Passport.isValidExpirationYear") {
    // Extra
    Passport.isValidExpirationYear("2019") shouldBe false
    Passport.isValidExpirationYear("2020") shouldBe true
    Passport.isValidExpirationYear("2025") shouldBe true
    Passport.isValidExpirationYear("2030") shouldBe true
    Passport.isValidExpirationYear("2031") shouldBe false
    Passport.isValidExpirationYear("baz") shouldBe false
    Passport.isValidExpirationYear("12345") shouldBe false
  }

  test("Passport.isValidHeight") {
    // Examples
    Passport.isValidHeight("60in") shouldBe true
    Passport.isValidHeight("190cm") shouldBe true
    Passport.isValidHeight("190in") shouldBe false
    Passport.isValidHeight("190") shouldBe false

    // Extra CM
    Passport.isValidHeight("149cm") shouldBe false
    Passport.isValidHeight("150cm") shouldBe true
    Passport.isValidHeight("185cm") shouldBe true
    Passport.isValidHeight("193cm") shouldBe true
    Passport.isValidHeight("194cm") shouldBe false

    // Extra IN
    Passport.isValidHeight("58in") shouldBe false
    Passport.isValidHeight("59in") shouldBe true
    Passport.isValidHeight("69in") shouldBe true
    Passport.isValidHeight("76in") shouldBe true
    Passport.isValidHeight("77in") shouldBe false

    // Extra Invalid
    Passport.isValidHeight("foo") shouldBe false
    Passport.isValidHeight("123bar") shouldBe false
    Passport.isValidHeight("123") shouldBe false
  }

  test("Passport.isValidHairColor") {
    // Examples
    Passport.isValidHairColor("#123abc") shouldBe true
    Passport.isValidHairColor("#123abz") shouldBe false
    Passport.isValidHairColor("123abc") shouldBe false

    // Extra
    Passport.isValidHairColor("#123456") shouldBe true
    Passport.isValidHairColor("#abcdef") shouldBe true
    Passport.isValidHairColor("#7890ff") shouldBe true
    Passport.isValidHairColor("#000000") shouldBe true
    Passport.isValidHairColor("#ffffff") shouldBe true
    Passport.isValidHairColor("#gggggg") shouldBe false
    Passport.isValidHairColor("#g12345") shouldBe false
    Passport.isValidHairColor("##123456") shouldBe false
  }

  test("Passport.isValidEyeColor") {
    // Examples
    Passport.isValidEyeColor("brn") shouldBe true
    Passport.isValidEyeColor("wat") shouldBe false

    // Extra
    Passport.isValidEyeColor("amb") shouldBe true
    Passport.isValidEyeColor("blu") shouldBe true
    Passport.isValidEyeColor("gry") shouldBe true
    Passport.isValidEyeColor("grn") shouldBe true
    Passport.isValidEyeColor("hzl") shouldBe true
    Passport.isValidEyeColor("oth") shouldBe true
    Passport.isValidEyeColor("foo") shouldBe false
    Passport.isValidEyeColor("bar") shouldBe false
    Passport.isValidEyeColor("123") shouldBe false
  }

  test("Passport.isValidPassportID") {
    // Examples
    Passport.isValidPassportID("000000001") shouldBe true
    Passport.isValidPassportID("0123456789") shouldBe false

    // Extra
    Passport.isValidPassportID("012345678") shouldBe true
    Passport.isValidPassportID("123456789") shouldBe true
    Passport.isValidPassportID("999999999") shouldBe true
    Passport.isValidPassportID("1") shouldBe false
    Passport.isValidPassportID("123") shouldBe false
    Passport.isValidPassportID("00012345") shouldBe false
  }

  test("Example Invalid Passports") {
    val input =
      s"""eyr:1972 cid:100
         |hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926
         |
         |iyr:2019
         |hcl:#602927 eyr:1967 hgt:170cm
         |ecl:grn pid:012533040 byr:1946
         |
         |hcl:dab227 iyr:2012
         |ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277
         |
         |hgt:59cm ecl:zzz
         |eyr:2038 hcl:74454a iyr:2023
         |pid:3556412378 byr:2007
         |""".stripMargin
    val passports = Part2.parseInput(input)
    passports.forall(!_.isValid) shouldBe true
    Part2.solve(passports) shouldBe 0
  }

  test("Example Valid Passports") {
    val input =
      s"""pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
         |hcl:#623a2f
         |
         |eyr:2029 ecl:blu cid:129 byr:1989
         |iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm
         |
         |hcl:#888785
         |hgt:164cm byr:2001 iyr:2015 cid:88
         |pid:545766238 ecl:hzl
         |eyr:2022
         |
         |iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
         |""".stripMargin
    val passports = Part2.parseInput(input)
    passports.forall(_.isValid) shouldBe true
    Part2.solve(passports) shouldBe 4
  }

}
