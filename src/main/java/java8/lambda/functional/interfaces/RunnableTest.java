package java8.lambda.functional.interfaces;


public class RunnableTest {
	
	public static void main(String[] args) {
		
		Runnable r = () -> {
			for (int i = 0; i < 5000; i++){
				System.out.println(i);
			}
		};		
		new Thread(r).start();
		
		//unico statement
		new Thread(() -> {
							for (int i = 0; i < 5000; i++){
								System.out.println(i);
							}
						 }
				
				).start();
		
		
	}
	
	

}
