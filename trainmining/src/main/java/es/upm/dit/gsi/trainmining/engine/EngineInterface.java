/**
 * 
 */
package es.upm.dit.gsi.trainmining.engine;

import java.util.List;

import es.upm.dit.gsi.trainmining.exceptions.NonSupportedCentralException;
import es.upm.dit.gsi.trainmining.exceptions.NonSupportedTimeWindowException;
import es.upm.dit.gsi.trainmining.model.Alarm;
import es.upm.dit.gsi.trainmining.model.Prediction;

/**
 * @author �lvaro
 *
 */
public interface EngineInterface {
	
	public Prediction predict(int timeWindow, String central,
			List<Alarm> alarms) throws NonSupportedTimeWindowException, NonSupportedCentralException;

}
