package thread;

public class ThreadTest {

	// 继承Thread类并重写main方法
	public static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("I am a child thread");
		}
	}

	public static void main(String[] args) {
		// 创建线程
		MyThread thread = new MyThread();
		// 启动线程
		thread.run();
	}

}
