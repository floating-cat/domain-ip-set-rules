package dird

import java.nio.file.{Files, Path}
import scala.language.experimental.relaxedLambdaSyntax

@main def generateRuleFiles(useLocalDataFile: Boolean): Unit =
  Files.createDirectories(Path.of("data"))
  val domainRules = DomainRulesStore.load(useLocalDataFile)
  val ipSetRules = IpSetRulesStore.load(useLocalDataFile)
  generateDb(domainRules, ipSetRules)
