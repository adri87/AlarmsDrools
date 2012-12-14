/**
 * 
 */
package es.upm.dit.gsi.trainmining.engine.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.upm.dit.gsi.trainmining.engine.Engine;
import es.upm.dit.gsi.trainmining.exceptions.NonSupportedCentralException;
import es.upm.dit.gsi.trainmining.exceptions.NonSupportedTimeWindowException;
import es.upm.dit.gsi.trainmining.model.Alarm;
import es.upm.dit.gsi.trainmining.model.Prediction;

/**
 * @author �lvaro
 * 
 */
public class MockedPrediction {

	@Test
	public void NotNullPrediction() throws NonSupportedTimeWindowException, NonSupportedCentralException {
		Engine engine = mock(Engine.class);
		when(engine.predict(anyInt(), anyString(), anyList())).thenReturn(
				new Prediction());
		List<Alarm> alarms = new ArrayList<Alarm>();
		Prediction result = engine.predict(5, "antequera", alarms);
		assertTrue(result != null);
	}

	private int anyInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void NotNullPrediction2() throws NonSupportedTimeWindowException, NonSupportedCentralException {
		Engine engine = mock(Engine.class);
		when(engine.predict(eq(1), eq("antequera"), anyList()))
				.thenReturn(new Prediction());
		List<Alarm> alarms = new ArrayList<Alarm>();
		Prediction result = engine.predict(1, "antequera", alarms);
		assertTrue(result != null);
	}

	@Test
	public void InitialTimeStamp() throws NonSupportedTimeWindowException, NonSupportedCentralException {
		Engine engine = mock(Engine.class);
		Prediction p = new Prediction();
		p.setInitialTimestamp(System.currentTimeMillis());
		when(engine.predict(eq(1), eq("antequera"), anyList()))
				.thenReturn(p);
		List<Alarm> alarms = new ArrayList<Alarm>();
		Prediction result = engine.predict(1, "antequera", alarms);
		assertTrue(result.getInitialTimestamp() != 0);
	}

	@Test
	public void InitialTimeStamp2() throws NonSupportedTimeWindowException, NonSupportedCentralException {
		Engine engine = mock(Engine.class);
		Prediction p = new Prediction();
		p.setInitialTimestamp(System.currentTimeMillis());
		when(engine.predict(eq(1), eq("antequera"), anyList()))
				.thenReturn(p);
		List<Alarm> alarms = new ArrayList<Alarm>();
		Prediction result = engine.predict(1, "antequera", alarms);
		assertTrue(result.getInitialTimestamp() <= System.currentTimeMillis());
	}

}
