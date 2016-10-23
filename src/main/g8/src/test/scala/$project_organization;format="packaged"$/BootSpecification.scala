package $project_organization$

import org.scalatest.{ Matchers, WordSpec }

class BootSpecification extends WordSpec with Matchers {

  "Boot object" should {
    "have implemented a helloWorld method" in {
      Boot.helloWorld shouldEqual "Hello world"
    }
  }

}
