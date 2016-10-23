// -----------------------------------------------------
// Configuration file for plugin 'sbt-scoverage'
// https://github.com/scoverage/sbt-scoverage
// -----------------------------------------------------

// ---------------------
// Settings
// ---------------------

// TODO: Revisar problemas de instrumentation que contamina el jar que se publica para poder habilitarlo - Andres Peralta
coverageEnabled := false

coverageFailOnMinimum := true

coverageMinimum := 80

// -----------------------
// Custom settings
// -----------------------

(coverageReport in Test) <<= (coverageReport in Test).triggeredBy(test in Test)
