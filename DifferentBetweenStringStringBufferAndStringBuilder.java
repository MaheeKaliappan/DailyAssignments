package com.zoho.javaprograms;

public class DifferentBetweenStringStringBufferAndStringBuilder {

	public static void main(String[] args) {
		DifferentBetweenStringStringBufferAndStringBuilder differentBetweenStringStringBufferAndStringBuilder = new DifferentBetweenStringStringBufferAndStringBuilder();
		differentBetweenStringStringBufferAndStringBuilder.checkTheDifference();
	}

	private void checkTheDifference() {
		String name="Kishore";
		 findTheDifference("string",name);
		 findTheDifference("stringBuffer",name);
		 findTheDifference("stringBuilder",name);
		
		
	}

	private void findTheDifference(String stringMessage, String name) {
		if(stringMessage.equals("string"))
		{
			System.out.println("Before hashcode : "+System.identityHashCode(name));
			String stringValue = new String("Hi "+name);
			System.out.println("After hashcode : "+name.hashCode());
		}
		else if(stringMessage.equals("stringBuffer"))
		{
			System.out.println("Before hashcode : "+System.identityHashCode(name));
			StringBuffer stringBuffer = new StringBuffer("Hi "+name);
			System.out.println("After hashcode : "+System.identityHashCode(name));
		}
		else if(stringMessage.equals("stringBuilder"))
		{
			System.out.println("Before hashcode : "+name.hashCode());
			StringBuilder stringBuilder = new StringBuilder("Hi "+name);
			System.out.println("After hashcode : "+name.hashCode());
		}
		long startTime = System.currentTimeMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		for(int print = 0;print<50000;print++)
		{
			System.out.println("Hi "+name);
		}
		long endTime =System.currentTimeMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println(stringMessage +" Time   : "+ (endTime - startTime)+" ms");
		System.out.println("Memory : "+ (endMemory-startMemory));
		
	}

}
