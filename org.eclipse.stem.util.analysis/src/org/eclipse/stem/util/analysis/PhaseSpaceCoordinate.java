/**
 * 
 */
package org.eclipse.stem.util.analysis;


/**
 * An x-y coordinate in Phase Space 
 * Used, for example,  to compute trajectory and Lyapunov Exponent
 *
 */
public class PhaseSpaceCoordinate implements Comparable {
	
		
		double xValue;
		double yValue;
		
		/**
		 * constructor
		 * @param x
		 * @param y
		 */
		public PhaseSpaceCoordinate(double x,double y) {
			xValue = x;
			yValue = y;
		}
		
		/**
		 * getX
		 * @return xValue
		 */
		public double getXValue() {
			return xValue;
		}

		/**
		 * set xValue
		 * @param value 
		 */
		public void setXValue(double value) {
			xValue = value;
		}

		/**
		 * getY
		 * @return YValue
		 */
		public double getYValue() {
			return yValue;
		}

		/**
		 * set yValue
		 * @param value 
		 */
		public void setYValue(double value) {
			yValue = value;
		}
	
		/**
		 * integrate (sum) path values
		 * @param deltaXvalue 
		 * @param deltaYvalue 
		 */
		public void integratePath(double deltaXvalue, double deltaYvalue) {
			xValue += deltaXvalue;
			yValue += deltaYvalue;
		}
		
		/**
		 * normalize the coordinates
		 * @param normalization
		 * 
		 */
		public void normalize(double normalization) {
			xValue /= normalization;
			yValue /= normalization;
		}
		
		/**
		 * 
		 * @param otherPoint
		 * @return the distance between this point and other point in phase space
		 */
		public double getDistance(PhaseSpaceCoordinate otherPoint) {
			double dist2 = ((this.xValue - otherPoint.xValue)*(this.xValue - otherPoint.xValue))+
						   ((this.yValue - otherPoint.yValue)*(this.yValue - otherPoint.yValue))	;
			double dist = Math.sqrt(dist2);
			
			return dist;
		}
		
		/**
		 * for sorting coordinates by their x value
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		 public int compareTo(Object otherCoord) throws ClassCastException {
			    if (!(otherCoord instanceof PhaseSpaceCoordinate)) throw new ClassCastException("A Person object expected.");
			    double otherX = ((PhaseSpaceCoordinate)otherCoord).xValue;
			    if (this.xValue < otherX) return -1;
			    if (this.xValue > otherX) return 1;
			    return 0;
		 }

	
		
		
	

}//PhaseSpaceCoordinate class
