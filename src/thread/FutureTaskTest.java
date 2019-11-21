package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
	// 创建任务类，类似Runable
	public static class CallerTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			return "hello";
		}

		public static void main(String[] args) {
			// 创建异步任务
			FutureTask<String> future = new FutureTask<>(new CallerTask());
			// 启动线程
			new Thread(future).start();
			try {
				// 等待任务执行完毕，并返回结果
				String futureStr = future.get();
				System.out.println(futureStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
