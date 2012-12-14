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
public class Engine implements EngineInterface {

	// Singleton code
	//
	// private Engine instance;
	//
	// private Engine () {
	//
	// }
	//
	// public Engine getInstance() {
	// if (instance == null) {
	// this.instance = new Engine();
	// }
	// return this.instance;
	// }

	public Engine() {

	}

	public Prediction predict(int timeWindow, String central,
			List<Alarm> alarms) throws NonSupportedTimeWindowException,
			NonSupportedCentralException {
		// TODO Auto-generated method stub
		return null;
	}

}
