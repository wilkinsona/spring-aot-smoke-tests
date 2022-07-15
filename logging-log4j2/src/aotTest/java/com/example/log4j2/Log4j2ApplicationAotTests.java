package com.example.log4j2;

import java.time.Duration;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import org.springframework.aot.smoketest.support.assertj.AssertableOutput;
import org.springframework.aot.smoketest.support.junit.AotSmokeTest;

import static org.assertj.core.api.Assertions.assertThat;

@AotSmokeTest
class Log4j2ApplicationAotTests {

	@Test
	void expectedLoggingIsProduced(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(30)).untilAsserted(() -> {
			assertThat(output).hasNoLinesContaining("Trace message").hasSingleLineContaining("Debug message")
					.hasSingleLineContaining("Info message").hasSingleLineContaining("Warn message")
					.hasSingleLineContaining("Error message").hasSingleLineContaining("Fatal message")
					.hasSingleLineContaining("Info with parameters: 1").hasSingleLineContaining("Error with stacktrace")
					.hasSingleLineContaining("java.lang.RuntimeException: Boom")
					.hasSingleLineContaining("at com.example.log4j2.CLR.run(CLR.java");
		});
	}

}
