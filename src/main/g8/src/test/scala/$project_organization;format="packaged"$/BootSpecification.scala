package $project_organization$

import org.specs2.mutable.Specification

class BootSpecification extends Specification {

  "Boot object" should {
    "have implemented a helloWorld method" in {
      Boot.helloWorld should_== "Hello world"
    }
  }

}
