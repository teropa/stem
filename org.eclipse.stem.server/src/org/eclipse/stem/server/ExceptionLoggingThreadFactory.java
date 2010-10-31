package org.eclipse.stem.server;

import java.util.concurrent.ThreadFactory;

public class ExceptionLoggingThreadFactory implements ThreadFactory {
	
	private ExceptionLoggingHandler HANDLER = new ExceptionLoggingHandler();
	
	public Thread newThread(Runnable r) {
		Thread result = new Thread(r);
		result.setUncaughtExceptionHandler(HANDLER);
		return result;
	}

	private static class ExceptionLoggingHandler implements Thread.UncaughtExceptionHandler {
		public void uncaughtException(Thread thread, Throwable cause) {
			cause.printStackTrace();
		}
	}
}
