package Aplicacion2;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcesoCallable implements Callable<Integer> {

	AtomicInteger contador =  new AtomicInteger(0);
	
	@Override
	public Integer call() throws Exception {
		return contador.getAndIncrement();
	}

}
