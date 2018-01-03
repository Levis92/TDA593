// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.View;

import rover.Controller.IMissionManager;
import rover.View.Operator;

/************************************************************/
/**
 * 
 */
public class OperatorFactory {
	/**
	 * 
	 */
	private Operator nonTechnicalOperator = null;
	/**
	 * 
	 */
	private Operator technicalOperator = null;
	/**
	 * 
	 */
	public Operator operator = null;

	/**
	 * 
	 * @return 
	 */
	public Operator getNonTechnicalOperatorInstance() {
		if (nonTechnicalOperator == null) {
			nonTechnicalOperator = new Operator("non-technical", null);
		} 
		return nonTechnicalOperator;
	}


	/**
	 * 
	 * @return 
	 * @param missionManager 
	 */
	public Operator getTechnicalOperatorInstance(IMissionManager missionManager) {
		if (technicalOperator == null) {
			technicalOperator = new Operator("technical", missionManager);
		} 
		return technicalOperator;
	}
};
