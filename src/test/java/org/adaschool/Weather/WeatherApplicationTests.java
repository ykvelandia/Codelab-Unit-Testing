package org.adaschool.Weather;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private WeatherReportService weatherReportService;
	@InjectMocks
	private WeatherReportController weatherReportController;
	@BeforeEach
	public void setUp() {
		//MockitoAnnotations.openMocks(this);
		weatherReportController = new WeatherReportController(weatherReportService);
	}
	@Test
	public void testGetWeatherReport() {
		double latitude = 40.7128;
		double longitude = -74.0060;
		WeatherReport report = new WeatherReport();
		report.setTemperature(25.5);
		report.setHumidity(70);
		when(weatherReportService.getWeatherReport(anyDouble(), anyDouble()))
				.thenReturn(report);

		WeatherReport lWeatherReport = weatherReportController.getWeatherReport(latitude, longitude);
		assertEquals(report, lWeatherReport);

		}

}

