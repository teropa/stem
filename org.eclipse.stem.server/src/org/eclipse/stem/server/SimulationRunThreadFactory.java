package org.eclipse.stem.server;

import java.util.concurrent.ThreadFactory;

public class SimulationRunThreadFactory implements ThreadFactory {
	
	private Handler HANDLER = new Handler();
	
	public Thread newThread(Runnable r) {
		Thread result = new Thread(r);
		result.setUncaughtExceptionHandler(HANDLER);
		return result;
	}

	private static class Handler implements Thread.UncaughtExceptionHandler {
		public void uncaughtException(Thread thread, Throwable cause) {
			System.out.println("Uncaught exception: "+cause);
			cause.printStackTrace();
		}
	}
}
