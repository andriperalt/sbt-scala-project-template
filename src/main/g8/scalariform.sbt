// -----------------------------------------------------
// Configuration file for plugin 'sbt-scalariform'
// https://github.com/sbt/sbt-scalariform
// -----------------------------------------------------
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import com.typesafe.sbt.SbtScalariform.defaultScalariformSettings
import scalariform.formatter.preferences._

defaultScalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 160)
  .setPreference(PreserveDanglingCloseParenthesis, true)
  .setPreference(SpaceInsideBrackets, true)
  .setPreference(SpaceInsideParentheses, true)
