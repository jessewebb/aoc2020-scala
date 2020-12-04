package jessewebb.aoc2020.day02

object Part1 {

  type Password = String
  case class PasswordPolicy(min: Int, max: Int, char: Char)
  type Answer = Int

  def parseInput(lineOfInput: String): (Password, PasswordPolicy) = {
    val regex = """(\d+)\-(\d+)\s(\w):\s(\w*)""".r
    lineOfInput match {
      case regex(minStr, maxStr, charStr, password) =>
        (password, PasswordPolicy(minStr.toInt, maxStr.toInt, charStr.charAt(0)))
    }
  }

  def solve(passwordsAndPolicies: Seq[(Password, PasswordPolicy)]): Answer =
    countValidPasswords(passwordsAndPolicies)

  private[day02] def countValidPasswords(passwordsAndPolicies: Seq[(Password, PasswordPolicy)]): Int =
    passwordsAndPolicies.count {
      case (password, policy) => isPasswordValid(password, policy)
    }

  private[day02] def isPasswordValid(password: Password, policy: PasswordPolicy): Boolean =
    policy.min to policy.max contains password.count(_ == policy.char)

}
