package jessewebb.aoc2020.day02

object Part2 {

  type Password = String

  case class PasswordPolicy(pos1: Int, pos2: Int, char: Char)

  type Answer = Int

  def parseInput(lineOfInput: String): (Password, PasswordPolicy) = {
    val regex = """(\d+)-(\d+)\s(\w):\s(\w*)""".r
    lineOfInput match {
      case regex(pos1Str, pos2Str, charStr, password) =>
        (password, PasswordPolicy(pos1Str.toInt, pos2Str.toInt, charStr.charAt(0)))
    }
  }

  def solve(passwordsAndPolicies: Seq[(Password, PasswordPolicy)]): Answer =
    countValidPasswords(passwordsAndPolicies)

  private[day02] def countValidPasswords(passwordsAndPolicies: Seq[(Password, PasswordPolicy)]): Int =
    passwordsAndPolicies.count {
      case (password, policy) => isPasswordValid(password, policy)
    }

  private[day02] def isPasswordValid(password: Password, policy: PasswordPolicy): Boolean =
    (password.charAt(policy.pos1-1) == policy.char) != (password.charAt(policy.pos2-1) == policy.char)

}
