package org.eclipse.stem.analysis.automaticexperiment;


/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * Minimizes a function using the Nelder-Mead algorithm.
 * 
 * Simplex function minimisation procedure due to Nelder+Mead(1965), as
 * implemented by O'Neill(1971, Appl.Statist. 20, 338-45), with subsequent
 * comments by Chambers+Ertel(1974, 23, 250-1), Benyon(1976, 25, 97) and
 * Hill(1978, 27, 380-2)
 * 
 * Authors:
 * 
 * Based on FORTRAN77 version by R ONeill 
 * This Java version by Yossi Mesika
 * 
 * Reference:
 * 
 * John Nelder, Roger Mead, A simplex method for function minimization, Computer
 * Journal, Volume 7, 1965, pages 308-313.
 * 
 * R ONeill, Algorithm AS 47: Function Minimization Using a Simplex Procedure,
 * Applied Statistics, Volume 20, Number 3, 1971, pages 338-345.
 */
public class NelderMeadAlgorithm implements SimplexAlgorithm {

	double ccoeff = 0.5;
	double del;
	double dn;
	double dnn;
	double ecoeff = 2.0;
	double eps = 0.001;
	int i;
	int ihi;
	int ilo;
	int j;
	int jcount;
	int l;
	int nn;
	double[] p;
	double[] p2star;
	double[] pbar;
	double[] pstar;
	double rcoeff = 1.0;
	double rq;
	double x;
	double[] y;
	double y2star;
	double ylo;
	double ystar;
	double z;

	int ifault = -1;
	int numres = -1;
	int icount = -1;
	double ynewlo;
	double[] xmin;

	public void execute(final SimplexFunction fn, final double[] startPoint,
			final double[] step, final double terminatingVariance) {
		execute(fn, startPoint, terminatingVariance, step,
				1, -1);
	}
	
	/**
	 * @param fn the {@link SimplexFunction} to be minimized
	 * @param start a starting point for the first iteration
	 * @param reqmin the terminating limit for the variance of function values
	 * @param step determines the size and shape of the initial simplex. The relative magnitudes of 
	 * its elements should reflect the units of the variables.
	 * @param konvge the convergence check is carried out every KONVGE iterations
	 * @param kcoun the maximum number of function evaluations
	 */
	private void execute(SimplexFunction fn, double start[], double reqmin, double step[], int konvge, int kcount) {
		int n = start.length;
		//
		// Check the input parameters.
		//
		if (reqmin <= 0.0) {
			ifault = 1;
			return;
		}

		if (n < 1) {
			ifault = 1;
			return;
		}

		if (konvge < 1) {
			ifault = 1;
			return;
		}

		p = new double[n * (n + 1)];
		pstar = new double[n];
		p2star = new double[n];
		pbar = new double[n];
		y = new double[n + 1];
		xmin = new double[n];

		icount = 0;
		numres = 0;

		jcount = konvge;
		dn = (n);
		nn = n + 1;
		dnn = (nn);
		del = 1.0;
		rq = reqmin * dn;
		//
		// Initial or restarted loop.
		//
		for (;;) {
			for (i = 0; i < n; i++) {
				p[i + n * n] = start[i];
			}
			y[n] = fn.getValue(start);
			icount = icount + 1;

			for (j = 0; j < n; j++) {
				x = start[j];
				start[j] = start[j] + step[j] * del;
				for (i = 0; i < n; i++) {
					p[i + j * n] = start[i];
				}
				y[j] = fn.getValue(start);
				icount = icount + 1;
				start[j] = x;
			}
			//	                    
			// The simplex construction is complete.
			//	                    
			// Find highest and lowest Y values. YNEWLO = Y(IHI) indicates
			// the vertex of the simplex to be replaced.
			//	                
			ylo = y[0];
			ilo = 0;

			for (i = 1; i < nn; i++) {
				if (y[i] < ylo) {
					ylo = y[i];
					ilo = i;
				}
			}
			//
			// Inner loop.
			//
			for (;;) {
				if (kcount != -1 && kcount <= icount) {
					break;
				}
				ynewlo = y[0];
				ihi = 0;

				for (i = 1; i < nn; i++) {
					if (ynewlo < y[i]) {
						ynewlo = y[i];
						ihi = i;
					}
				}
				//
				// Calculate PBAR, the centroid of the simplex vertices
				// excepting the vertex with Y value YNEWLO.
				//
				for (i = 0; i < n; i++) {
					z = 0.0;
					for (j = 0; j < nn; j++) {
						z = z + p[i + j * n];
					}
					z = z - p[i + ihi * n];
					pbar[i] = z / dn;
				}
				//
				// Reflection through the centroid.
				//
				for (i = 0; i < n; i++) {
					pstar[i] = pbar[i] + rcoeff * (pbar[i] - p[i + ihi * n]);
				}
				ystar = fn.getValue(pstar);
				icount = icount + 1;
				//
				// Successful reflection, so extension.
				//
				if (ystar < ylo) {
					for (i = 0; i < n; i++) {
						p2star[i] = pbar[i] + ecoeff * (pstar[i] - pbar[i]);
					}
					y2star = fn.getValue(p2star);
					icount = icount + 1;
					//
					// Check extension.
					//
					if (ystar < y2star) {
						for (i = 0; i < n; i++) {
							p[i + ihi * n] = pstar[i];
						}
						y[ihi] = ystar;
					}
					//
					// Retain extension or contraction.
					//
					else {
						for (i = 0; i < n; i++) {
							p[i + ihi * n] = p2star[i];
						}
						y[ihi] = y2star;
					}
				}
				//
				// No extension.
				//
				else {
					l = 0;
					for (i = 0; i < nn; i++) {
						if (ystar < y[i]) {
							l = l + 1;
						}
					}

					if (1 < l) {
						for (i = 0; i < n; i++) {
							p[i + ihi * n] = pstar[i];
						}
						y[ihi] = ystar;
					}
					//
					// Contraction on the Y(IHI) side of the centroid.
					//
					else if (l == 0) {
						for (i = 0; i < n; i++) {
							p2star[i] = pbar[i] + ccoeff
									* (p[i + ihi * n] - pbar[i]);
						}
						y2star = fn.getValue(p2star);
						icount = icount + 1;
						//
						// Contract the whole simplex.
						//
						if (y[ihi] < y2star) {
							for (j = 0; j < nn; j++) {
								for (i = 0; i < n; i++) {
									p[i + j * n] = (p[i + j * n] + p[i + ilo
											* n]) * 0.5;
									xmin[i] = p[i + j * n];
								}
								y[j] = fn.getValue(xmin);
								icount = icount + 1;
							}
							ylo = y[0];
							ilo = 0;

							for (i = 1; i < nn; i++) {
								if (y[i] < ylo) {
									ylo = y[i];
									ilo = i;
								}
							}
							continue;
						}
						//
						// Retain contraction.
						//
						else {
							for (i = 0; i < n; i++) {
								p[i + ihi * n] = p2star[i];
							}
							y[ihi] = y2star;
						}
					}
					//
					// Contraction on the reflection side of the centroid.
					//
					else if (l == 1) {
						for (i = 0; i < n; i++) {
							p2star[i] = pbar[i] + ccoeff * (pstar[i] - pbar[i]);
						}
						y2star = fn.getValue(p2star);
						icount = icount + 1;
						//
						// Retain reflection?
						//
						if (y2star <= ystar) {
							for (i = 0; i < n; i++) {
								p[i + ihi * n] = p2star[i];
							}
							y[ihi] = y2star;
						} else {
							for (i = 0; i < n; i++) {
								p[i + ihi * n] = pstar[i];
							}
							y[ihi] = ystar;
						}
					}
				}
				//
				// Check if YLO improved.
				//
				if (y[ihi] < ylo) {
					ylo = y[ihi];
					ilo = ihi;
				}
				jcount = jcount - 1;

				if (0 < jcount) {
					continue;
				}
				//
				// Check to see if minimum reached.
				//
				if (kcount == -1 || icount <= kcount) {
					jcount = konvge;

					z = 0.0;
					for (i = 0; i < nn; i++) {
						z = z + y[i];
					}
					x = z / dnn;

					z = 0.0;
					for (i = 0; i < nn; i++) {
						z = z + Math.pow(y[i] - x, 2);
					}

					if (z <= rq) {
						break;
					}
				}
			}
			//
			// Factorial tests to check that YNEWLO is a local minimum.
			//
			for (i = 0; i < n; i++) {
				xmin[i] = p[i + ilo * n];
			}
			ynewlo = y[ilo];

			if (kcount != -1 && kcount < icount) {
				ifault = 2;
				break;
			}

			ifault = 0;

			for (i = 0; i < n; i++) {
				del = step[i] * eps;
				xmin[i] = xmin[i] + del;
				z = fn.getValue(xmin);
				icount = icount + 1;
				if (z < ynewlo) {
					ifault = 2;
					break;
				}
				xmin[i] = xmin[i] - del - del;
				z = fn.getValue(xmin);
				icount = icount + 1;
				if (z < ynewlo) {
					ifault = 2;
					break;
				}
				xmin[i] = xmin[i] + del;
			}

			if (ifault == 0) {
				break;
			}
			//
			// Restart the procedure.
			//
			for (i = 0; i < n; i++) {
				start[i] = xmin[i];
			}
			del = eps;
			numres = numres + 1;
		}
	}

	public double getMinimumFunctionValue() {
		return this.ynewlo;
	}

	public double[] getMinimumParametersValues() {
		return this.xmin;
	}

	public void setParameterLimits(final int parameterIndex,
			final double lowerBound, final double upperBound) {
		// TODO Auto-generated method stub
	}

}
