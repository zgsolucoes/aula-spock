import spock.lang.Specification

class TesteCicloVlidaSpec extends Specification {

	void setupSpec() {
		println('setup spec')
	}

	void setup() {
		println('setup method')
	}

	void cleanup() {
		println('cleanup method')
	}

	void cleanupSpec() {
		println('cleanup Spec')
	}

	void "test"() {
		setup:
		println('setup block')

		when:
		println('test code in when')

		then:
		false

		cleanup:
		println('cleanup block')
	}
}
