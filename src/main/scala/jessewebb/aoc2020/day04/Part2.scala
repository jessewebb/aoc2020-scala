package jessewebb.aoc2020.day04

object Part2 {

  case class Passport(fields: Map[String, String]) {
    def isValid: Boolean = {
      Passport.requiredKeys.subsetOf(fields.keySet) &&
        fields.map(Passport.isFieldValid).reduce(_ && _)
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

    private def isFieldValid(field: (String, String)): Boolean = {
      field._1 match {
        case "byr" => isValidBirthYear(field._2)
        case "iyr" => isValidIssueYear(field._2)
        case "eyr" => isValidExpirationYear(field._2)
        case "hgt" => isValidHeight(field._2)
        case "hcl" => isValidHairColor(field._2)
        case "ecl" => isValidEyeColor(field._2)
        case "pid" => isValidPassportID(field._2)
        case "cid" => true
      }
    }

    private[day04] def isValidBirthYear(byr: String): Boolean = {
      val regex = """^(\d{4})$""".r
      byr match {
        case regex(birthYearStr) =>
          val birthYear = birthYearStr.toInt
          birthYear >= 1920 && birthYear <= 2002
        case _ =>
          false
      }
    }

    private[day04] def isValidIssueYear(iyr: String): Boolean = {
      val regex = """^(\d{4})$""".r
      iyr match {
        case regex(issueYearStr) =>
          val issueYear = issueYearStr.toInt
          issueYear >= 2010 && issueYear <= 2020
        case _ =>
          false
      }
    }

    private[day04] def isValidExpirationYear(eyr: String): Boolean = {
      val regex = """^(\d{4})$""".r
      eyr match {
        case regex(expirationYearStr) =>
          val expirationYear = expirationYearStr.toInt
          expirationYear >= 2020 && expirationYear <= 2030
        case _ =>
          false
      }
    }

    private[day04] def isValidHeight(hgt: String): Boolean = {
      val regexCM = """^(\d+)cm$""".r
      val regexIN = """^(\d+)in$""".r
      hgt match {
        case regexCM(heightInCmStr) =>
          val heightInCm = heightInCmStr.toInt
          heightInCm >= 150 && heightInCm <= 193
        case regexIN(heightInInStr) =>
          val heightInIn = heightInInStr.toInt
          heightInIn >= 59 && heightInIn <= 76
        case _ =>
          false
      }
    }

    private[day04] def isValidHairColor(hcl: String): Boolean = {
      val regex = """^#[0-9a-f]{6}""".r
      regex.matches(hcl)
    }

    private[day04] def isValidEyeColor(ecl: String): Boolean = {
      val validEyeColors = Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
      validEyeColors.contains(ecl)
    }

    private[day04] def isValidPassportID(pid: String): Boolean = {
      val regex = """^\d{9}""".r
      regex.matches(pid)
    }
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
