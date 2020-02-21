package com.sosen.competetiondata;

import com.sosen.service.ServiceMain;

import junit.framework.TestCase;

public class TestCompetition extends TestCase {
	private ServiceMain serviceMain;

	@Override
	protected void setUp() throws Exception {
		serviceMain = new ServiceMain();
		serviceMain.start();
	}
	
	public void testCountries() {
		assertEquals(new CompetetionDataService().getCountries("").size(), 2);
	}
	
	public void testTeams() {
		assertEquals(new CompetetionDataService().getTeams("148").size(), 20);
	}
	
	public void testNoTeams() {
		assertNotSame(new CompetetionDataService().getTeams("99").size(), 20);
	}
	
	public void testLeagues() {
		assertEquals(new CompetetionDataService().getLeagues("41").size(), 1);
	}

	@Override
	protected void tearDown() throws Exception {
		serviceMain.stop();
	}
}
